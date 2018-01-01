<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require ('site.php');
echo set_header(); ?>

	<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">LOGIN SIASAT UKSW</h3>
                    </div>
                    <div class="panel-body">
                        <?php echo "<p class=\"bg-warning\">".$login ."</p>"; ?>
                        <form role="form" method="post" action="">
                            <fieldset>
                                <div class="form-group">
									<input type="text" class="form-control" name="txtNim" placeholder="MASUKKAN NIM" required>
									</div>
									<div class="form-group">
									<input type="password" class="form-control" name="txtPWD" placeholder="MASUKKAN PASSWORD" required>
									</div>
									<button type="submit" class="btn btn-lg btn-primary btn-block" name="login">LOGIN</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<?php
echo set_footer();
?>