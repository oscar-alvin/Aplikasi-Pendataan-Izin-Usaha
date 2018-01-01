<?php
defined('BASEPATH') OR exit('No direct script access allowed');

	require('site.php');
	echo set_header();
	echo top_nav(); ?>
	
	<div class="container">
		<div class="content panel panel-primary">
		<div class="panel-heading">REGISTRASI ULANG</div>
		<div class="panel-body">
			<?php
				if(isset($status)) {
					echo "<div class=\"alert alert-success\" role=\"alert\"><h4>".$status."</h4></div>";
				} else {
					if($regsks == true) echo "<div class=\"alert alert-success\" role=\"alert\"><h4>Anda Telah Melakukan Registrasi Ulang Pada Semester Ini </h4></div>";
					else {
						echo "<div class=\"alert alert-warning\" role=\"alert\"><h4>Anda Belum Melakukan Registrasi Ulang Pada Semester Ini</h4>";
						echo "<form method=\"POST\" action=\"regisUlang\">";
						echo "<div class=\"form-group\">";
						echo "<select class=\"bg-primary\">";
						echo "<option> 8 sks </option><";
						echo "</select>";
						echo "<button type=\"submit\" class=\"btn btn-success\">REGISTRASI ULANG</button>";
						echo "</form>";
						echo "</div></div>\n";
					}
				}
				
			?>
			<br/><br/><br/>
			<p class="bg-primary"><h3>Untuk Melakukan perubahan registrasi silahkan menghubungi BARA UKSW</h3></p>
			</div>
		</div>
	</div>
	
<?php	echo set_footer();
?>