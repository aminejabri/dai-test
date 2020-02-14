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

					<form action="" method="get">
						<div class="box-body">
							<div class="box box-default">
								<div class="box-header with-border">
									<h3 class="box-title">Informations complémentaires</h3>

									<div class="box-tools pull-right">
										<button type="button" class="btn btn-box-tool"
											data-widget="collapse">
											<i class="fa fa-minus"></i>
										</button>
									</div>
								</div>
								<!-- /.box-header -->
								<div class="box-body" data-select2-id="15">
									<div class="row">
										<div class="col-md-3" data-select2-id="26">
											<div class="form-group" data-select2-id="25">
												<label>Age</label> <input type="number" name="age"
													min="0" max="200" data-bind="value:replyNumber" />
												<div class="form-group" data-select2-id="25">
													<label>Poids</label> <input type="number" id="poids"
														min="0" max="200" data-bind="value:replyNumber" />
												</div>
												<div class="form-group" data-select2-id="25">
													<label>Fréquence cardiaque au repos</label> <input
														type="number"name="fcrepos" min="0" max="200"
														data-bind="value:replyNumber" />
												</div>
												<div class="form-group" data-select2-id="25">
													<label>Fréquence cardiaque cible</label> <input
														type="number"name="fccible" min="0" max="200"
														data-bind="value:replyNumber" />
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
							<div class="box box-default">
								<div class="box-header with-border">
									<h3 class="box-title">Condition</h3>
									<div class="box-tools pull-right">
										<button type="button" class="btn btn-box-tool"
											data-widget="collapse">
											<i class="fa fa-minus"></i>
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
												<td><input type="number"name="fc5" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td>FC après 30 flexions complètes en 45 sec</td>
												<td><input type="number"name="fc30" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td>FC 1 min après exercice allongé</td>
												<td><input type="number"name="fc1" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td>Indice Dickson</td>
												<td><input type="number"name="indicedickson" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
										</tbody>
									</table>

								</div>
							</div>
						</div>


						<div class="box-body">
							<div class="box box-default">
								<div class="box-header with-border">
									<h3 class="box-title">Performance</h3>
									<div class="box-tools pull-right">
										<button type="button" class="btn btn-box-tool"
											data-widget="collapse">
											<i class="fa fa-minus"></i>
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
												<td><img class="img-responsive img-circle"
													src="/resources/img/exercice/gainage.png"></td>
												<td colspan=2>Gainage</td>
												<td><input type="number"name="gainage" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td rowspan=2><img class="img-responsive"
													src="/resources/img/exercice/fente.gif"></td>
												<td rowspan=2>Fentes avant</td>
												<td>jambe gauche devant</td>
												<td><input type="number"name="fentejambeg" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td>jambe droite devant</td>
												<td><input type="number"name="fentejambed" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td><img class="img-responsive"
													src="/resources/img/exercice/crunch.gif"></td>
												<td colspan=2>Crunch</td>
												<td><input type="number"name="crunch" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td><img class="img-responsive"
													src="/resources/img/exercice/pompes.gif"></td>
												<td colspan=2>1/2 pompes</td>
												<td><input type="number" name="pompes" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td><img class="img-responsive"
													src="/resources/img/exercice/squat.gif"></td>
												<td colspan=2>1/2 squat</td>
												<td><input type="number"name="squat" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td><img class="img-responsive"
													src="/resources/img/exercice/dips.gif"></td>
												<td colspan=2>Dips</td>
												<td><input type="number"name="dips" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>

						<div class="box-body">
							<div class="box box-default">
								<div class="box-header with-border">
									<h3 class="box-title">Mensurations côté gauche</h3>
									<div class="box-tools pull-right">
										<button type="button" class="btn btn-box-tool"
											data-widget="collapse">
											<i class="fa fa-minus"></i>
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
												<td>Bras</td>
												<td><input type="number"name="bras" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td>Poitrine</td>
												<td><input type="number"name="poitrine" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td>Taille</td>
												<td><input type="number"name="taille" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td>Hanches</td>
												<td><input type="number"name="hanches" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
											<tr>
												<td>Cuisse</td>
												<td><input type="number"name="cuisse" min="0"
													max="200" data-bind="value:replyNumber" /></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<input type="hidden" name="messageconfirmation" value="l'utilisateur a validé le bilan">
						<input type="submit" id="submit"  class="btn btn-app" value="Valider">
						<!-- modal -->
						
						
					</form>
				</div>
			</div>
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</div>

