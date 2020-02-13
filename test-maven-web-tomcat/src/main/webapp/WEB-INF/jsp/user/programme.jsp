<%@ include file="../../layout/taglib.jsp"%>
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
						<li><a href="/user/profil">Profile</a></li>
						<li class="active"><a href="#timeline">Programmes</a></li>
						<li><a href="http://localhost:8080/user/profil" data-toggle="tab">Bilan</a></li>
					</ul>
					<!-- /.box -->

					<!-- About Me Box -->

					<!-- /.tab-pane -->
					<div class="tab-pane" id="timeline">
						<!-- The timeline -->
						<!-- timeline time label -->

						<div class="box-body box-profile">

							<!-- /.box-header -->
							<div class="box box-default" data-select2-id="16">
								<div class="box-header with-border">
									<h3 class="box-title">Demarrer la seance en cours</h3>

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

												<td>Séance </td>
												<td><a href="http://localhost:8080/user/inscription"
													target="_blank"> <input type="button" value="Démarrer">
												</a>
												<td>
											</tr>
										
									</table>
								</div>
								<br>
								<div class="box box-default" data-select2-id="16">
									<div class="box-header with-border">
										<h3 class="box-title">Liste des seance du programme</h3>
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
											<c:forEach items="${myModel}" var="seanceClient"
											varStatus="status">
											<tr>
												<td>Séance : ${seanceClient.ordreSeance}</td>
												<td id = "${seanceClient.id}" hidden="true"></td> 
												<td><a href="/seance/exercice/${seanceClient.id}"><input class =  id="${seanceClient.id}" type="button" value="Consulter"></</a>
												<td>
											</tr>
										</c:forEach>
										</table>
									</div>
								</div>
								
							</div>
						</div>

					</div>
				</div>
				<!-- /.tab-content -->
			</div>
			<!-- /.nav-tabs-custom -->
		</div>
		<!-- /.row -->

	</section>
	<!-- /.content -->
</div>