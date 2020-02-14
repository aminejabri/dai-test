<%@ include file="../../layout/taglib.jsp"%>
<div class="content-wrapper" style="min-height: 1135.67px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Bilans de ${myModel[0].username}</h1>
	</section>

	<!-- Main content -->
	<section class="content">
			<div class="row">
				<div class="col-md-12">
					<!-- About Me Box -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Bilan ${status.count}</h3>
							<div class="box-tools pull-right">
								<button type="button" class="btn btn-box-tool"
									data-widget="collapse">
									<i class="fa fa-minus"></i>
								</button>
							</div>
						</div>

						<form>
							<div class="box-body">
								<div class="box box-default collapsed-box">
									<div class="box-header with-border">
										<h3 class="box-title">Informations complémentaires</h3>

										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
									<!-- /.box-header -->
									<div class="box-body" data-select2-id="15">
										<div class="row">
											<div class="col-md-3" data-select2-id="26">
												<div class="form-group" data-select2-id="25">
													<label>Age</label> <input type="number" id="replyNumber"
														min="0" max="200" data-bind="value:replyNumber" />
														<div class="form-group" data-select2-id="25">
															<label>Poids</label> ${myModel[1].bilan.poid}
														</div>
														<div class="form-group" data-select2-id="25">
															<label>Fréquence cardiaque au repos</label>${myModel[1].bilan.freqCardiaqueRepos}
														</div>
														<div class="form-group" data-select2-id="25">
															<label>Fréquence cardiaque cible</label>${myModel[1].bilan.freqCardiaqueCible}
														</div>
													
													<!-- /.form-group -->
												</div>

												<!-- /.col -->
											</div>
											<!-- /.row -->
										</div>
									</div>
								</div>
							</div>

							<div class="box-body">
								<div class="box box-default collapsed-box">
									<div class="box-header with-border">
										<h3 class="box-title">Condition</h3>
										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
									<!-- /.box-header -->
									<div class="box-body">
											<table class="table table-bordered">
												<tbody>
													<tr>
														<th></th>
														<th>Eval 1</th>
													</tr>
													<tr>
														<td>FC après 5 min allongé au calme</td>
														<td>${myModel[1].bilan.freqCardiaque5minAllonge}</td>
													</tr>
													<tr>
														<td>FC après 30 flexions complètes en 45 sec</td>
														<td>${myModel[1].bilan.freqCardiaque30Flex}</td>
													</tr>
													<tr>
														<td>FC 1 min après exercice allongé</td>
														<td>${myModel[1].bilan.freqCardiaque1min}</td>
													</tr>
													<tr>
														<td>Indice Dickson</td>
														<td>${myModel[1].bilan.indiceDickson}</td>
													</tr>
												</tbody>
											</table>
										
									</div>
								</div>
							</div>


							<div class="box-body">
								<div class="box box-default collapsed-box">
									<div class="box-header with-border">
										<h3 class="box-title">Performance</h3>
										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
									<!-- /.box-header -->
									<div class="box-body">
										<table class="table table-bordered">
											<tbody>
												<tr>
													<th></th>
													<th colspan=2></th>
													<th>Eval 1</th>
												</tr>
												<tr>
													<td><img class="img-responsive img-circle" src="/resources/img/exercice/gainage.png"></td>
													<td colspan=2>Gainage</td>
													<td>${myModel[1].exercicesClient[0].performance}</td>
												</tr>
												<tr>
													<td rowspan=2><img class="img-responsive" src="/resources/img/exercice/fente.gif"></td>
													<td rowspan=2>Fentes avant</td>
													<td>jambe gauche devant</td>
													<td>${myModel[1].exercicesClient[1].performance}</td>
												</tr>
												<tr>
													<td>jambe droite devant</td>
													<td>${myModel[1].exercicesClient[2].performance}</td>
												</tr>
												<tr>
													<td><img class="img-responsive" src="/resources/img/exercice/crunch.gif"></td>
													<td colspan=2>Crunch</td>
													<td>${myModel[1].exercicesClient[3].performance}</td>
												</tr>
												<tr>
													<td><img class="img-responsive" src="/resources/img/exercice/pompes.gif"></td>
													<td colspan=2>1/2 pompes</td>
													<td>${myModel[1].exercicesClient[4].performance}</td>
												</tr>
												<tr>
													<td><img class="img-responsive" src="/resources/img/exercice/squat.gif" ></td>
													<td colspan=2>1/2 squat</td>
													<td>${myModel[1].exercicesClient[5].performance}</td>
												</tr>
												<tr>
													<td><img class="img-responsive" src="/resources/img/exercice/dips.gif" ></td>
													<td colspan=2>Dips</td>
													<td>${myModel[1].exercicesClient[6].performance}</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>

						<!--  	<div class="box-body">
								<div class="box box-default collapsed-box">
									<div class="box-header with-border">
										<h3 class="box-title">Mensurations côté gauche</h3>
										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
									<!-- /.box-header --><!-- 
									<div class="box-body">
											varStatus="status">
											<table class="table table-bordered">
												<tbody>
													<tr>
														<th></th>
														<th>Eval 1</th>
													</tr>
													<tr>
														<td>Bras</td>
														<td>${bilan.freqCardiaque5minAllonge}</td>
													</tr>
													<tr>
														<td>Poitrine</td>
														<td>${bilan.freqCardiaque30Flex}</td>
													</tr>
													<tr>
														<td>Taille</td>
														<td>${bilan.freqCardiaque1min}</td>
													</tr>
													<tr>
														<td>Hanches</td>
														<td>${bilan.indiceDickson}</td>
													</tr>
													<tr>
														<td>Cuisse</td>
														<td>${bilan.indiceDickson}</td>
													</tr>
												</tbody>
											</table>
									</div>
								</div>
							</div>-->

							<!-- <input type="submit" class="btn btn-app" value="Valider"> -->
						</form>
					</div>
				</div>
			</div>
			<!-- /.row -->
	</section>
	<!-- /.content -->
</div>

