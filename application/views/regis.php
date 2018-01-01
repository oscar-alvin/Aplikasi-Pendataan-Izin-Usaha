<?php
defined('BASEPATH') OR exit('No direct script access allowed');

	require('site.php');
	echo set_header();
	echo top_nav();
	echo regis_mtk($makul);
	echo set_footer();

?>