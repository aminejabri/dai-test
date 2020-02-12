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
						<li><a href="#timeline" data-toggle="tab">Programmes</a></li>
						<!--li><a href="#settings" data-toggle="tab">Settings</a></li-->
					</ul>
					<div class="tab-content">
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
						<!-- /.box -->

						<!-- About Me Box -->

						<!-- /.tab-pane -->
						<div class="tab-pane" id="timeline">
							<!-- The timeline -->
							<ul class="timeline timeline-inverse">
								<!-- timeline time label -->

								<div class="box box-primary">
									<div class="box-header with-border">
										<h3 class="box-title">Mon Programme</h3>
									</div>
									<div class="box">

										<!-- /.box-header -->
										<div class="box-body no-padding">
											<div class="box box-default" data-select2-id="16">
												<div class="box-header with-border">
													<h3 class="box-title">Demarrer seance</h3>

													<div class="box-tools pull-right">
														<button type="button" class="btn btn-box-tool"
															data-widget="collapse">
															<i class="fa fa-minus"></i>
														</button>
													</div>
												</div>
												<div class="box-body">
													<table class="table table-condensed">
														<tr>

															<th>Séance</th>
															<th>Action</th>
														</tr>
														<tr>
															<td>Séance 1</td>
															<td>																
																<a href="http://localhost:8080/user/inscription" target="_blank"> <input type="button" value="Démarrer"> </a>
															<td>
														</tr>

													</table>
										</div>
												<br>
												<div class="box box-default" data-select2-id="16">
													<div class="box-header with-border">
														<h3 class="box-title">Consulter seance</h3>

														<div class="box-tools pull-right">
															<button type="button" class="btn btn-box-tool"
																data-widget="collapse">
																<i class="fa fa-minus"></i>
															</button>
														</div>
													</div>
													<div class="box-body"></div>
												</div>
											</div>

										</div>
							</ul>
						</div>
						<!-- /.tab-pane -->

						<div class="tab-pane" id="settings">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="inputName" class="col-sm-2 control-label">Name</label>

									<div class="col-sm-10">
										<input type="email" class="form-control" id="inputName"
											placeholder="Name">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail" class="col-sm-2 control-label">Email</label>

									<div class="col-sm-10">
										<input type="email" class="form-control" id="inputEmail"
											placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label for="inputName" class="col-sm-2 control-label">Name</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" id="inputName"
											placeholder="Name">
									</div>
								</div>
								<div class="form-group">
									<label for="inputExperience" class="col-sm-2 control-label">Experience</label>

									<div class="col-sm-10">
										<textarea class="form-control" id="inputExperience"
											placeholder="Experience"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="inputSkills" class="col-sm-2 control-label">Skills</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" id="inputSkills"
											placeholder="Skills">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div class="checkbox">
											<label> <input type="checkbox"> I agree to
												the <a href="#">terms and conditions</a>
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-danger">Submit</button>
									</div>
								</div>
							</form>
						</div>
						<!-- /.tab-pane -->
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