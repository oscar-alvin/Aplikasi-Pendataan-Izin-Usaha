<?php
defined('BASEPATH') OR exit('No direct script access allowed');

	require('site.php');
	echo set_header();
	echo top_nav();
	echo daftar_kelas($kelas);
	echo set_footer();

?>