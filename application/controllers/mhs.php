<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class mhs extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see https://codeigniter.com/user_guide/general/urls.html
	 */
	public function __construct(){
		parent::__construct();
		$this->load->library('session');
		$this->load->model('mhs_model');
	}
	public function index()
	{
		echo $_SESSION['umhs'];
		$error = array();
		if(isset($_SESSION['umhs'])){
			$this->load->view('index');
		} else {
			$error[] = "Anda Harus Login Terlebih Dahulu";
			$this->load->view('login', $error);
		}
	}
	public function logout()
	{
		unset($_SESSION['umhs']);
		redirect(base_url());
	}
	public function StatusRegis(){
		if(isset($_SESSION['umhs'])){
			if(isset($_SESSION['id_sms'])){
				$data['regsks'] = $this->mhs_model->cekRegis($_SESSION['umhs'], $_SESSION['id_sms'], "KULIAH");
				$this->load->view('regsks', $data);
			} else {
				$data['status'] = "Request tidak dapat di proses, Semester belum di buka pada tahun ajaran ini !";
				$this->load->view('regsks', $data);
			}
		}else redirect(base_url());
	}
	public function regisUlang(){
		if(isset($_SESSION['umhs'])){
			if(isset($_SESSION['semester'])){
				$status = $this->mhs_model->regisUlang($_SESSION['umhs'], 'KULIAH', '8', $_SESSION['id_sms']);
					if($status == 1) redirect('mahasiswa/tagihan');
					else echo "Gagal Registrasi";	
			}else show_error($message = "Data Semester Belum Di buat", 
							$status_code = 10, $heading = "Informasi");
		}else redirect(base_url());
	}
	public function regis_makul(){
		$waktu =  date('D-M-Y');
		if(isset($_SESSION['umhs']) && isset($_SESSION['id_sms'])){
			if($this->mhs_model->cekRegis($_SESSION['umhs'], $_SESSION['id_sms'], "KULIAH") == true){
				$data['tagihan'] = $this->mhs_model->getTagihan($_SESSION['umhs']);
				foreach($data['tagihan'] as $row){
					if($row->TERBAYAR >= $row->JUMLAH){
						$data['jadwal'] = $this->mhs_model->cekJadwalSiasat($_SESSION['umhs'], $_SESSION['fakultas']);
						foreach($data['jadwal'] as $row){
							if($row->OPEN == null) {
								show_error($message = "Jadwal Tidak tersedia, hubungi bara untuk info lebih lanjut!", 
								$status_code = 10, $heading = "Informasi");
							} else {
								if($waktu > $row->OPEN  && $row->CLOSE <= $waktu){
									$data['makul'] = $this->mhs_model->getAllMakul($_SESSION['fakultas'], 
										$_SESSION['semester']);
									$this->load->view('regis', $data);
								} else {
									show_error($message = "Jadwal Siasat Anda ".$row->OPEN." sampai ".$row->CLOSE, 
									$status_code = 10, $heading = "Informasi");
								}
							}
						}
					} else show_error($message = "Anda Belum Melunasi Tagihan", 
							$status_code = 10, $heading = "Informasi");
				} 
				
			}else show_error($message = "Anda Belum Melakukan Registrasi Ulang", 
							$status_code = 10, $heading = "Informasi");
			
			
		} else { show_error($message = "Semester belum di buka", $status_code = 10, $heading = "Informasi"); }
	}
	public function DaftarKelas($id){
		if(isset($_SESSION['umhs'])){
			$data['kelas'] = $this->mhs_model->getKelasByID($id);
			$this->load->view('kelas', $data);
		} else { redirect(base_url()); }
	}
	public function addkst($id){
		if(isset($_SESSION['umhs'])){
			$data['temp'] = $this->mhs_model->getKST($_SESSION['umhs']);
			foreach ($data['temp'] as $row) {
				if($row->KODE_MAKUL == substr($id, 0, 5)){
					show_error($message = "Matakuliah Telah Di Ambil", $status_code = 10, $heading = "Error");
					return;
				}
			}
			if($this->mhs_model->addKST($_SESSION['umhs'], $id, $_SESSION['semester'], 2017)){
				$data['kst'] = $this->mhs_model->getKST($_SESSION['umhs']);
				$this->load->view('kst', $data);
			}
		} else {
			$this->load->view('login');
		}
	}
	public function delkst($id){
		if(isset($_SESSION['umhs'])){
			if($this->mhs_model->delKST($_SESSION['umhs'], $id)){
				$data['kst'] = $this->mhs_model->getKST($_SESSION['umhs']);
				$this->load->view('kst', $data);
			} else {
				 show_error($message = "Gagal menghapus data matakuliah", $status_code = 10, $heading = "Error Tambah Data");
			}
		} else {
			$this->load->view('login');
		}
	}
	public function loadKST(){
		if(isset($_SESSION['umhs'])){
			if(isset($_SESSION['id_sms'])){
					$data['kst'] = $this->mhs_model->getKST($_SESSION['umhs']);
					$data['sks'] = $this->mhs_model->getTotalAmbilSKS($_SESSION['umhs'], $_SESSION['semester']);
					$this->load->view('kst', $data);
			}else {
				show_error($message = "Request tidak dapat di proses, Semester belum di buka pada tahun ajaran ini !", 
					$status_code = 10, $heading = "Error Request KST");
			}
		} else { redirect(base_url()); }
	}
	public function loadJadwal(){
		if(isset($_SESSION['umhs'])){
			$data['jadwal'] = $this->mhs_model->getKST($_SESSION['umhs']);
			$this->load->view('jadwal', $data);
		} else { redirect(base_url()); }
	}
	public function loadTranskrip(){
		if(isset($_SESSION['umhs'])){
			$data['transkrip'] = $this->mhs_model->getTranskrip($_SESSION['umhs']);
			$this->load->view('transkrip', $data);
		} else { redirect(base_url()); }
	}
	public function tagihan(){
		if(isset($_SESSION['umhs'])){
			if(isset($_SESSION['id_sms'])){
				$data['tagihan'] = $this->mhs_model->getTagihan($_SESSION['umhs']);
				$this->load->view('tagihan', $data);
			}else {
				show_error($message = "Request tidak dapat di proses, Semester belum di buka pada tahun ajaran ini !", 
					$status_code = 10, $heading = "Error proses tagihan");
			}
		}else redirect(base_url());
	}
	public function hasil_studi(){
		if(isset($_SESSION['umhs'])){
			$data['hs'] = $this->mhs_model->hasil_studi($_SESSION['umhs']);
			$this->load->view('hasil', $data);
		}else redirect(base_url());
	}
}
