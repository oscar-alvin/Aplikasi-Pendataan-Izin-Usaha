<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class loginMHS extends CI_Controller {
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
		$error = array();
		if(isset($_POST['login'])){
			$data['users'] = $this->mhs_model->getUsers();
			if($data['users'] == null){
				$error['login'] = "Username / Password Salah !";
				$this->load->view('login', $error);
			}else {
				foreach($data['users'] as $row){
					$_SESSION['umhs'] = $row->NIM;
					$_SESSION['fakultas'] = $row->FAKULTAS;
				}
				if(isset($_SESSION['id_sms']) && isset($_SESSION['sms'])){
					return;
				}else {
					$data['sms'] = $this->mhs_model->getAktifSemester($_SESSION['fakultas']);
					foreach ($data['sms'] as $row) {
						$_SESSION['id_sms'] = $row->ID_SMS;
						$_SESSION['semester'] = $row->SMS;
					}
				}
				$this->load->view('index');
			}
		} else if(isset($_SESSION['umhs'])){
			$this->load->view('index');
		}else {
			$error['login'] = "";
			$this->load->view('login', $error);
		}
	}
}
