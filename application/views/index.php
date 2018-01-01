<?php
defined('BASEPATH') OR exit('No direct script access allowed');

	require ('site.php');
	echo set_header();
	echo top_nav(); ?>
	
	<div class="content panel panel-primary">
		<div class="panel-heading">HALAMAN CONTENT</div>
		<div class="panel-body"> Demi kelancaran pengiriman email dari Bagian Administrasi Akademik UKSW, &#xa;silahkan menggunakan email student.uksw.edu yang telah diberikan.&#xa;Bagian Administrasi Akademik UKSW tidak bertanggung jawab, &#xa;apabila data yang anda berikan salah.&#xa;Jika anda belum melakukan registrasi ulang pada semester ini silahkan &#xa;lakukan registrasi ulang pada form di bawah </div>
		<div class="row">
			<div class="col-lg-12">
				<div id="isi-content">
					<form class="form-inline" method="POST">
						<label>Masukkan No. Hp </label><input type="text" class="form-control"></input>
						<label>Masukkan Email  </label><input type="email" class="form-control"></input>
						<button type="submit" class="btn btn-primary">SIMPAN</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<?php 
	echo set_footer();
?>
<script type="text/javascript">
	$(document).ready(function(){
		$('#m1').click(function(){

		});
	});
</script>