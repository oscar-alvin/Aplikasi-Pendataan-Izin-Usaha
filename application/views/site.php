<?php 
defined('BASEPATH') OR exit('No direct script access allowed');

	function set_header(){
		$s = "";
		$s .= "<!DOCTYPE html>\n";
		$s .= "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n";
		$s .= "<head>\n";
		$s .= "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n";
		$s .= "<title>".base_url()."</title>\n";
		$s .= "<link rel=\"stylesheet\" type=\"text/css\" href=\"".base_url()."/assets/css/bootstrap.min.css\" />\n";
		$s .= "<link rel=\"stylesheet\" type=\"text/css\" href=\"".base_url()."/assets/css/bootstrap-theme.min.css\" />\n";
		$s .= "<link rel=\"stylesheet\" type=\"text/css\" href=\"".base_url()."/assets/style.css\" />\n";
		$s .= "</head>\n";
		$s .= "<body>\n";
		return $s;
	}
	function set_footer(){
		$s = ""; // modal //
		$s .= "<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n";
		$s .= "<div class=\"modal-dialog\" role=\"document\">\n";
		$s .= "		<div class=\"modal-content\">\n";
		$s .= "			<div class=\"modal-header\">\n";
        $s .= "				<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n";
        $s .= "					<h4 class=\"modal-title\" id=\"myModalLabel\">Ganti Password</h4>\n";
		$s .= "				</div>\n";
		$s .= "			<div class=\"modal-body\">\n";
        $s .= "				content of the modal \n";
		$s .= "			</div>\n";
		$s .= "		<div class=\"modal-footer\">\n";
        $s .= "				<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n";
        $s .= "				<button type=\"button\" class=\"btn btn-primary\">Save changes</button>\n";
		$s .= "			</div>\n";
		$s .= "		</div>\n";
		$s .= "</div>\n";
		$s .= "</div>\n";
		$s .= "<script type=\"text/javascript\" src=\"".base_url()."/assets/js/bootstrap.js\"></script>\n";
		$s .= "<script type=\"text/javascript\" src=\"".base_url()."/assets/js/jquery-1.11.3.min.js\"></script>\n";
		$s .= "<script type=\"text/javascript\" src=\"".base_url()."/assets/js/bootstrap.min.js\"></script>\n";
		$s .= "</body>\n";
		$s .= "</html>\n";
		return $s;
	}
	function top_nav(){
		$s = "";
		$s .= "<nav class=\"navbar navbar-inverse navbar-fixed-top\"\n>";
        $s .= "<div class=\"container\"\n>";
        $s .= "		<div class=\"navbar-header\"\n>";
        $s .= "     <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar\"\n>";
        $s .= "     <span class=\"sr-only\">Toggle navigation</span>\n";
        $s .= "     <span class=\"icon-bar\"></span>\n";
        $s .= "     <span class=\"icon-bar\"></span>\n";
        $s .= "     <span class=\"icon-bar\"></span>\n";
        $s .= "     </button>\n";
        $s .= "     <a href=\"".base_url()."\" class=\"navbar-brand\">SIASAT UKSW</a>\n";
        $s .= "</div>\n";

        $s .= "<div class=\"collapse navbar-collapse\" id=\"navbar\">\n";
        $s .= "        <ul class=\"nav navbar-nav navbar-right\">\n";
        $s .= "         <li>".anchor('mahasiswa/StatusRegis', 'Registrasi Ulang')."</li>\n";
		$s .= "			<li>".anchor('mahasiswa/regis','Registrasi Matakuliah')."</li>\n";
		$s .= "			<li>".anchor('mahasiswa/hasil','Hasil Studi')."</li>\n";
		$s .= "			<li>".anchor('mahasiswa/kst','KST')."</li>\n";
		$s .= "			<li>".anchor('mahasiswa/jadwal','Jadwal')."</li>\n";
		$s .= "			<li>".anchor('mahasiswa/tagihan', 'Tagihan')."</li>\n";
		$s .= "			<li>".anchor('mahasiswa/transkrip','Transkrip')."</li>\n";
		$s .= "			<li class=\"dropdown\">\n";
        $s .= "			<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">".$_SESSION['umhs']."<span class=\"caret\"></span></a>\n";
        $s .= "  			<ul class=\"dropdown-menu\">\n";
        $s .= "    				<li><a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\">Ganti Password</a></li>\n";
        $s .= "   				<li role=\"separator\" class=\"divider\"></li>\n";
        $s .= "   				<li>".anchor('mahasiswa/logout', 'Logout')."</li>\n";
        $s .= " 			</ul>\n";
        $s .= "			</li>\n";
        $s .= "        </ul>\n";
        $s .= "    </div>\n";
        $s .= "</div>\n";
		$s .= "</nav>\n";
		return $s;
	}
	function regis_mtk($data){
		$s = "";
		$s .= "<div class=\"content panel panel-primary\">\n";
		$s .= "<div class=\"panel-heading\">DAFTAR MATAKULIAH YANG DI BUKA</div>\n";
		$s .= "<div class=\"panel-body\">\n";
		$s .= "<table class=\"table\">\n";
		$s .= "<tr>
				<th> KODE </th>
				<th> MATAKULIAH </th>
				<th> SKS ANGKAT </th>
				<th> SKS BAYAR </th>
				</tr>\n";
				foreach($data as $row)
				{
					$s .= "<tr>\n";
					$s .= "		<td>".anchor("mahasiswa/kelas/".$row->KODE_MAKUL, $row->KODE_MAKUL)."</td>\n";
					$s .= "		<td>".$row->NAMA_MAKUL."</td>\n";
					$s .= "		<td>".$row->SKS_A."</td>\n";
					$s .= "		<td>".$row->SKS_B."</td>\n";
					$s .= "</tr>\n";
				}
		$s .= "</div>\n";
		$s .= "</table>\n";
		$s .= "</div>\n";
		return $s;
	}
	function daftar_kelas($data){
		$s = "";
		$s .= "<div class=\"content panel panel-primary\">\n";
		$s .= "<div class=\"panel-heading\">DAFTAR MATAKULIAH YANG DI BUKA</div>\n";
		$s .= "<div class=\"panel-body\">\n";
		$s .= "<table class=\"table\">\n";
		$s .= "<tr>
				<th> KODE </th>
				<th> RUANG </th>
				<th> HARI </th>
				<th> MULAI </th>
				<th> SELESAI </th>
				<th> DOSEN </th>
				<th> KAPASITAS </th>
				</tr>\n";
		foreach($data as $row)
			{
				$s .= "<tr>\n";
				$s .= "		<td>".anchor("mahasiswa/addkst/".$row->KODE_KELAS, $row->KODE_KELAS)."</td>\n";
				$s .= "		<td>".$row->RUANG."</td>\n";
				$s .= "		<td>".$row->HARI."</td>\n";
				$s .= "		<td>".$row->MULAI."</td>\n";
				$s .= "		<td>".$row->SELESAI."</td>\n";
				$s .= "		<td>".$row->DOSEN."</td>\n";
				$s .= "		<td>".$row->KAPASITAS."</td>\n";
				$s .= "</tr>\n";
			}
		$s .= "</div>\n";
		$s .= "</table>\n";
		$s .= "</div>\n";
		return $s;
	}
	function view_kst($kst, $sks){
		$s = "";
		$s .= "<div class=\"content panel panel-primary\">\n";
		$s .= "<div class=\"panel-heading\">KARTU STUDI TETAP</div>\n";
		$s .= "<div class=\"panel-body\">\n";
		$s .= "<table class=\"table\">\n";
		$s .= "<tr>
				<th> HARI </th>
				<th> KODE </th>
				<th> MATAKULIAH </th>
				<th> RUANG </th>
				<th> WAKTU </th>
				<th> SKS A/B </th>
				<th> DOSEN </th>
				<th> </th>
				</tr>\n";
		foreach($kst as $row)
			{
				$s .= "<tr>\n";
				$s .= "		<td>".$row->HARI."</td>\n";
				$s .= "		<td>".$row->KODE_KELAS."</td>\n";
				$s .= "		<td>".$row->NAMA_MAKUL."</td>\n";
				$s .= "		<td>".$row->RUANG."</td>\n";
				$s .= "		<td>".$row->MULAI." - ".$row->SELESAI."</td>\n";
				$s .= "		<td>".$row->SKS_A." / ".$row->SKS_B."</td>\n";
				$s .= "		<td>".$row->NAMA_DOSEN."</td>\n";
				$s .= "		<td>".anchor("mahasiswa/delkst/".$row->KODE_KELAS, "Hapus")."</td>\n";
				$s .= "</tr>\n";
			}
			foreach ($sks as $row) {
				$s .= "<tr><td></td><td></td><td>Total SKS </td><td></td><td></td><td>".$row->AMBIL." / ".
				$row->BAYAR."</td><td></td></tr>";
			}
		$s .= "</div>\n";
		$s .= "</table>\n";
		$s .= "<button type=\"button\" class=\"btn btn-success\">PRINT</button>\n";
		$s .= "</div>\n";
		return $s;
	}
	
	function view_jadwal($data){
		$s = "";
		$s .= "<div class=\"content panel panel-primary\">\n";
		$s .= "<div class=\"panel-heading\">JADWAL KULIAH</div>\n";
		$s .= "<div class=\"panel-body\">\n";
		$s .= "<table class=\"table\">\n";
		$s .= "<tr>
				<th> HARI </th>
				<th> JAM </th>
				<th> KODE </th>
				<th> MATAKULIAH </th>
				<th> RUANG </th>
				<th> DOSEN </th>
				</tr>\n";
		foreach($data as $row)
			{
				$s .= "<tr>\n";
				$s .= "		<td>".$row->HARI."</td>\n";
				$s .= "		<td>".$row->MULAI." - ".$row->SELESAI."</td>\n";
				$s .= "		<td>".$row->KODE_KELAS."</td>\n";
				$s .= "		<td>".$row->NAMA_MAKUL."</td>\n";
				$s .= "		<td>".$row->RUANG."</td>\n";
				$s .= "		<td>".$row->NAMA_DOSEN."</td>\n";
				$s .= "</tr>\n";
			}
		$s .= "</div>\n";
		$s .= "</table>\n";
		$s .= "</div>\n";
		return $s;
	}
	function view_transkrip($data){
		$s = "";
		$s .= "<div class=\"content panel panel-primary\">\n";
		$s .= "<div class=\"panel-heading\">TRANSKRIP NILAI</div>\n";
		$s .= "<div class=\"panel-body\">\n";
		$s .= "<table class=\"table\">\n";
		$s .= "<tr>
				<th> KODE </th>
				<th> MATAKULIAH </th>
				<th> SKS </th>
				<th> SEM/THN </th>
				<th> NILAI </th>
				<th> AK </th>
				</tr>\n";
		foreach($data as $row)
			{
				$s .= "<tr>\n";
				$s .= "		<td>".$row->KODE_MAKUL."</td>\n";
				$s .= "		<td>".$row->NAMA_MAKUL."</td>\n";
				$s .= "		<td>".$row->SKS_A."</td>\n";
				$s .= "		<td>".$row->SEMESTER."</td>\n";
				$s .= "		<td>".$row->NILAI."</td>\n";
				$s .= "		<td>".$row->SKS_A."</td>\n";
				$s .= "</tr>\n";
			}
		$s .= "</div>\n";
		$s .= "</table>\n";
		$s .= "</div>\n";
		return $s;
	}
	function view_hs($data){
		$s = "";
		$s .= "<div class=\"content panel panel-primary\">\n";
		$s .= "<div class=\"panel-heading\">HASIL STUDI </div>\n";
		$s .= "<div class=\"panel-body\">\n";
		$s .= "<table class=\"table\">\n";
		$s .= "<tr>
				<th> KODE </th>
				<th> MATAKULIAH </th>
				<th> SIMBOL </th>
				<th> NILAI </th>
				<th> SKS</th>
				</tr>\n";
				$total = 0;
				$jumlah= 0;
				$t_nilai= 0;
		foreach($data as $row)
			{
				$s .= "<tr>\n";
				$s .= "		<td>".$row->IDKLS."</td>\n";
				$s .= "		<td>".$row->NAMA_MAKUL."</td>\n";
				$s .= "		<td>".$row->SIMBOL."</td>\n";
				$s .= "		<td>".$row->NILAI."</td>\n";
				$s .= "		<td>".$row->SKS_A."</td>\n";
				$s .= "</tr>\n";
				$t_nilai += ($row->NILAI);
				$total += ($row->SKS_A);
				$jumlah += 1;
			}
			$ips = ($t_nilai ==0 || $total == 0) ? 0.0 : ($t_nilai / $total);
		$s .= "<tr><td></td><td>Total </td><td></td><td>".$t_nilai."</td><td>".$total."</td></tr>";	
		$s .= "<tr><td></td><td>IPK </td><td></td><td></td><td>".$ips."</td></tr>";
		$s .= "</div>\n";
		$s .= "</table>\n";
		$s .= "<button type=\"button\" class=\"btn btn-success\">PRINT</button>\n";
		$s .= "</div>\n";
		return $s;
	}
?>