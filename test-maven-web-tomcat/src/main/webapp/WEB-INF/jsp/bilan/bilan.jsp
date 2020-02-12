<%@ include file="../../layout/taglib.jsp"%>
<div class="content-wrapper" style="min-height: 1135.67px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Bilans de ${myModel[0].username}</h1>
	</section>

	<!-- Main content -->
	<section class="content">

		<c:forEach items="${ myModel[1] }" var="bilans" varStatus="status">
			<div class="row">
				<div class="col-md-12">
					<!-- About Me Box -->
					<div class="box box-primary collapsed-box">
						<div class="box-header with-border">
							<h3 class="box-title">Bilan ${status.count}</h3>
							<div class="box-tools pull-right">
								<button type="button" class="btn btn-box-tool"
									data-widget="collapse">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</div>

						<form>
							<div class="box-body">
								<div class="box box-default collapsed-box">
									<div class="box-header with-border">
										<h3 class="box-title"></h3>

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
													<c:forEach items="${ myModel[1] }" var="bilan"
														varStatus="status">
														<div class="form-group" data-select2-id="25">
															<label>Poids</label> ${bilan.poid}
														</div>
														<div class="form-group" data-select2-id="25">
															<label>Fréquence cardiaque au repos</label>${bilan.freqCardiaqueRepos}
														</div>
														<div class="form-group" data-select2-id="25">
															<label>Fréquence cardiaque cible</label>${bilan.freqCardiaqueCible}
														</div>
													</c:forEach>
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
										<c:forEach items="${ myModel[1] }" var="bilan"
											varStatus="status">
											<table class="table table-bordered">
												<tbody>
													<tr>
														<th></th>
														<th>Eval 1</th>
													</tr>
													<tr>
														<td>FC après 5 min allongé au calme</td>
														<td>${bilan.freqCardiaque5minAllonge}</td>
													</tr>
													<tr>
														<td>FC après 30 flexions complètes en 45 sec</td>
														<td>${bilan.freqCardiaque30Flex}</td>
													</tr>
													<tr>
														<td>FC 1 min après exercice allongé</td>
														<td>${bilan.freqCardiaque1min}</td>
													</tr>
													<tr>
														<td>Indice de Ruffier Dickson</td>
														<td>${bilan.indiceDickson}</td>
													</tr>
												</tbody>
											</table>
										</c:forEach>
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
													<th>Image</th>
													<th colspan=2>Description</th>
													<th>Eval 1</th>
												</tr>
												<tr>
													<td><img class="img-responsive" src="" alt=""></td>
													<td colspan=2>Gainage</td>
													<td><input type="number" id="replyNumber" min="0"
														max="200" data-bind="value:replyNumber" /></td>
												</tr>
												<tr>
													<td rowspan=2><img class="img-responsive" src=""
														alt=""></td>
													<td rowspan=2>Fentes avant</td>
													<td>jambe gauche devant</td>
													<td><input type="number" id="replyNumber" min="0"
														max="200" data-bind="value:replyNumber" /></td>
												</tr>
												<tr>
													<td>jambe droite devant</td>
													<td><input type="number" id="replyNumber" min="0"
														max="200" data-bind="value:replyNumber" /></td>
												</tr>
												<tr>
													<td><img class="img-responsive" src="" alt=""></td>
													<td colspan=2>Crunch</td>
													<td><input type="number" id="replyNumber" min="0"
														max="200" data-bind="value:replyNumber" /></td>
												</tr>
												<tr>
													<td><img class="img-responsive" src="" alt=""></td>
													<td colspan=2>1/2 pompes</td>
													<td><input type="number" id="replyNumber" min="0"
														max="200" data-bind="value:replyNumber" /></td>
												</tr>
												<tr>
													<td><img class="img-responsive" src="" alt=""></td>
													<td colspan=2>1/2 squat</td>
													<td><input type="number" id="replyNumber" min="0"
														max="200" data-bind="value:replyNumber" /></td>
												</tr>
												<tr>
													<td><img class="img-responsive" src="" alt=""></td>
													<td colspan=2>Dips</td>
													<td><input type="number" id="replyNumber" min="0"
														max="200" data-bind="value:replyNumber" /></td>
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
										<c:forEach items="${ myModel[1] }" var="bilan"
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
										</c:forEach>
									</div>
								</div>
							</div>-->

							<!-- <input type="submit" class="btn btn-app" value="Valider"> -->
						</form>
					</div>
				</div>
			</div>
			<!-- /.row -->
		</c:forEach>
	</section>
	<!-- /.content -->
</div>

