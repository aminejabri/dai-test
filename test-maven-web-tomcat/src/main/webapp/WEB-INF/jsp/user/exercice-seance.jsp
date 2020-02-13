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
						<li><a href="http://localhost:8080/user/profil" data-toggle="tab">Settings</a></li>
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
						
							
								<br>
								<div class="box box-default" data-select2-id="16">
									<div class="box-header with-border">
										<h3 class="box-title">Liste des des exercices</h3>
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
											<c:forEach items="${myModel}" var="exerciceClient"
											varStatus="status">
											<tr>
												<td>Id Exercice : ${exerciceClient.id}</td>
											
												
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