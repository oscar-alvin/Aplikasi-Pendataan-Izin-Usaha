<?php
defined('BASEPATH') OR exit('No direct script access allowed');

	require('site.php');
	echo set_header();
	echo top_nav();
	echo view_hs($hs);
	echo set_footer();

?>