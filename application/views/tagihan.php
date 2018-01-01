<?php
defined('BASEPATH') OR exit('No direct script access allowed');

	require('site.php');
	echo set_header();
	echo top_nav(); ?>
	
	<div class="container">
		<div class="content panel panel-primary">
		<div class="panel-heading">Tagihan</div>
		<div class="panel-body">
			<?php
				echo "<table class=\"table table-default\">";
				foreach($tagihan as $row){
				echo "<tr><th>Semester/Tahun Ajaran </th><th>".$row->SMS." ".$row->TA."</th></tr>";
				echo "<tr><td>Jumlah Tagihan Anda 	  : </td><td>".$row->JUMLAH."</td></tr>";
				echo "<tr><td>Terbayar			  	  : </td><td>".$row->TERBAYAR."</td></tr>";
				echo "<tr><td>Sisa			  		  : </td><td>".$row->SISA."</td></tr>";
				echo "<tr><td>Jatuh Tempo Pembayaran : </td><td>".$row->DEADLINE."</td></tr>";
			} 
				echo "</table>";
			?>

			</div>
		</div>
	</div>
	
<?php	echo set_footer();

?>