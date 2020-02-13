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
						<li class="active"><a href="/user/profil">Profile</a></li>


					</ul>
					<!-- /.box -->

					<!-- About Me Box -->

					<!-- /.tab-pane -->
					<div class="tab-pane" id="timeline">
						<!-- The timeline -->
						<!-- timeline time label -->



						<!-- /.box-header -->


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
								<form>
									<input type="button" value="Retour" onclick="history.go(-1)">
								</form>
								<table class="table table-condensed">
								
								<div class="col-md-12">
						          <!-- The time line -->
						          <ul class="timeline">
						            <!-- timeline time label -->
						            <li class="time-label">
						                 
						            </li>
									
									<c:forEach items="${myModel}" var="exerciceClient" 	varStatus="status">
										<li>
					              <i class="fa fa-bicycle bg-blue"></i>
					
					              <div class="timeline-item">
					                <span class="time"></span>
					
					                <h3 class="timeline-header">Exercice : ${exerciceClient.exercice.nom}  </h3>
					
					                <div class="timeline-body">
					                  Description: ${exerciceClient.exercice.description}
					                </div>
					                <div class="timeline-body">
					                  Note: ${exerciceClient.note}
					                </div>
					               <div class="timeline-body">
					                  Commentaire: ${exerciceClient.commentaire}
					                </div>
					              </div>
					            </li>
							
															
									</c:forEach>
									   </ul>
        							</div>
								</table>
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