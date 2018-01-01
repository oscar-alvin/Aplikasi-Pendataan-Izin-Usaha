<?php
defined('BASEPATH') OR exit('No direct script access allowed');

	class mhs_model extends CI_Model {
		
		public function __construct(){
			parent::__construct();
		}
		public function getUsers(){
			$query = $this->db->where('NIM', $_POST['txtNim']);
			$query = $this->db->where('SANDI', $_POST['txtPWD']);
			return $query = $this->db->get('MAHASISWA')->result();
		}
		function getAllMakul($fak, $sms){
			$query = $this->db->where('ID_FAKULTAS', $fak);
			$query = $this->db->where('OPEN_SMS', $sms);
			return $query = $this->db->get('matakuliah')->result();		
		}

		function getAktifSemester($fak){
			$query = $this->db->where('ID_FAKULTAS', $fak);
			$query = $this->db->where('STATUS', 'AKTIF');
			return $query = $this->db->get('SEMESTER')->result();
		}
		
		function getKelasByID($id){
			$query = $this->db->where('KODE_MAKUL', $id);
			return $query = $this->db->get('kelas')->result();
		}
		
		function addKST($nim, $id, $sms, $thn){
			$this->db->set('NIM',$nim);
			$this->db->set('IDKLS',$id);
			$this->db->set('SEMESTER',$sms);
			$this->db->set('THN',$thn);
	        return $this->db->insert('tb_kst');
		}
		function delKST($nim, $id){
			$this->db->where('NIM',$nim);
			$this->db->where('IDKLS',$id);
			
			return $this->db->delete('tb_kst');
		}
		function getKST($nim){
			$sql = "SELECT HARI, KODE_KELAS, MATAKULIAH.KODE_MAKUL, NAMA_MAKUL, RUANG, MULAI, SELESAI, SKS_A, SKS_B, 
					NAMA_DOSEN FROM TB_KST, KELAS, MATAKULIAH, DOSEN 
					WHERE NIM = ? AND TB_KST.IDKLS = KELAS.KODE_KELAS AND KELAS.KODE_MAKUL = 
					MATAKULIAH.KODE_MAKUL AND KELAS.DOSEN = DOSEN.ID_DOSEN GROUP BY HARI ASC";
			$query = $this->db->query($sql, array($nim));						
			return $query->result();
		}
		function getTotalAmbilSKS($nim, $sms){
			$sql = "SELECT SUM(SKS_A) AS AMBIL, SUM(SKS_B) AS BAYAR FROM MATAKULIAH WHERE KODE_MAKUL 
					IN(SELECT LEFT(IDKLS, 5) FROM TB_KST WHERE NIM=? AND SEMESTER=?)";
			$query = $this->db->query($sql, array($nim, $sms));						
			return $query->result();
		}
		function getTranskrip($nim){
			$sql = "SELECT NAMA_MAKUL, TRANSKRIP.KODE_MAKUL, SKS_A, CONCAT_WS('/', TRANSKRIP.SEMESTER, TAHUN_AMBIL) AS SEMESTER, 
			NILAI FROM TRANSKRIP, MATAKULIAH WHERE NIM = ? AND TRANSKRIP.KODE_MAKUL = MATAKULIAH.KODE_MAKUL";
			$query = $this->db->query($sql, array($nim));
			return $query->result();		
		}
		function getTagihan($nim){
			$sql = "SELECT SMS, TA, TAGIHAN.NIM, SKS, JUMLAH, TERBAYAR, SISA, DEADLINE FROM SEMESTER, REGISTRASI, TAGIHAN WHERE 
				(SEMESTER.ID_SMS = REGISTRASI.ID_SMS AND REGISTRASI.ID_REG = TAGIHAN.ID_REG) AND TAGIHAN.NIM = ".$nim. " AND SISA > 0";
			$query = $this->db->query($sql);
			return $query->result();
		}
		function cekRegis($nim, $sms, $status){
			$sql = "SELECT * FROM REGISTRASI WHERE NIM = ? AND STATUS = ? AND ID_SMS=?";
			$query = $this->db->query($sql, array($nim, $status, $sms));
			$jumlah = $query->num_rows() >= 1 ? true : false;
			return $jumlah; 
		}
		function regisUlang($nim, $status, $sks, $idsms){
			$data = array('ID_SMS' => $idsms, 'NIM' => $nim,'STATUS' => $status,'SKS' => $sks);
			return $this->db->insert('REGISTRASI', $data);;
		}
		function hasil_studi($nim){
			$sql = "SELECT * FROM TB_KST, KELAS, MATAKULIAH WHERE TB_KST.IDKLS = KELAS.KODE_KELAS AND KELAS.KODE_MAKUL = MATAKULIAH.KODE_MAKUL AND NIM = ".$nim;
			$query = $this->db->query($sql);
			return $query->result();
		}
		function cekJadwalSiasat($nim, $fak){
			$sql = "SELECT OPEN, CLOSE FROM JADWAL_SIASAT WHERE ID_FAKULTAS=? AND (ANGKATAN=SUBSTRING(?,3,4) OR ANGKATAN=0)";
			$query = $this->db->query($sql, array($fak, $nim));
			return $query->result();
		}
	}