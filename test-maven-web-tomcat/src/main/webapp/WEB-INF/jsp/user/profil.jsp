<div class="content-wrapper" style="min-height: 1135.67px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Profile</h1>
	</section>

	<!-- Main content -->
	<section class="content">

		<div class="row">
			<div class="col-md-12">
				<div class="nav-tabs-custom">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#activity" data-toggle="tab">Profile</a></li>
						<li><a href="/programme/list" >Programmes</a></li>
						<li><a href="/programme/list" >Settings</a></li>
					</ul>
						<div class="active tab-pane" id="activity">

							<!-- Profile Image -->
							<div class="box-body box-profile">
								<img class="profile-user-img img-responsive img-circle"
									src="../../dist/img/user4-128x128.jpg"
									alt="User profile picture">

								<h3 class="profile-username text-center">
									${utilisateur.username}</h3>

								<p class="text-muted text-center">Software Engineer</p>
								<div class="box box-primary">
									<div class="box-header with-border">
										<h3 class="box-title">Mes informations</h3>
									</div>
								</div>
								<div class="box box-default" data-select2-id="16">
									<div class="box-header with-border">
										<h3 class="box-title">Profil</h3>

										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-minus"></i>
											</button>
										</div>
									</div>
									<div class="box-body">
										<table class="table table-bordered">
											<tr>
											</tr>
											<tr>
												<td>Nom :</td>
												<td>${utilisateur.lastname}</td>
											</tr>
											<tr>
												<td>Prénom :</td>
												<td>${utilisateur.firstname}</td>
											</tr>
											<tr>
												<td>Age :</td>
												<td>26 ans</td>
											</tr>
											<tr>
												<td>Email :</td>
												<td>${utilisateur.email}</td>
											</tr>
										</table>
									</div>
								</div>


								<div class="box box-default" data-select2-id="16">
									<div class="box-header with-border">
										<div class="box-title">Profil sportif</div>

										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-minus"></i>
											</button>
										</div>
									</div>
									<div class="box-body">
										<table class="table table-bordered">
											<tr>
											</tr>
											<tr>
												<td>Taille :</td>
												<td>${utilisateur.profil.taille}</td>
											</tr>
											<tr>
												<td>Poitrine :</td>
												<td>${utilisateur.profil.poitrine}</td>
											</tr>
											<tr>
												<td>Hanche :</td>
												<td>${utilisateur.profil.hanche}</td>
											</tr>
											<tr>
												<td>Cuisse :</td>
												<td>${utilisateur.profil.cuisse}</td>
											</tr>
											<tr>
												<td>Bras :</td>
												<td>${utilisateur.profil.bras}</td>
											</tr>
											<tr>
											</tr>
										</table>
									</div>
								</div>

								</div>


							<!-- /.box-body -->
						</div>

					<!-- /.tab-content -->
				</div>
				<!-- /.nav-tabs-custom -->
			</div>
		</div>
		<!-- /.row -->

	</section>
	<!-- /.content -->
</div>