<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/taglib.jsp" %>

<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Inscription</b></a><br>

  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
			
    <p class="login-box-msg">Veuillez Remlir le formulaire de l'inscription</p>

    <form class="" id="inscription-from" role="form" action="" method="POST">
      <div class="form-group has-feedback">
        <input type="text" name="username" class="form-control" id="username" placeholder="Username" required="true" autofocus>
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="prenom" class="form-control" id="prenom" placeholder="Nom" required="true" autofocus>
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="nom" class="form-control" id="nom" placeholder="Prenom" required=true"" autofocus>
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="age" class="form-control" id="age" placeholder="Age" required="true" autofocus>
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="email" class="form-control" id="email" placeholder="Email" required="true" autofocus>
      </div>
      <div class="form-group has-feedback">
        <input type="password"  name="password"  class="form-control" id="password" placeholder="Password" required="true" />
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <a id ="submit" class="btn btn-primary btn-block btn-flat">Envoyer</a>
        </div>
        <!-- /.col -->
      </div>
    </form>


  </div>
</div>


