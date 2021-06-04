<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Sign Up</title>

  <!-- Custom fonts for this template-->
  <link href="./css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="./css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-12">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
              </div>
              
              <div class="text-center"><h6 style="color:red;">
                  <%
                  	String error="";
                  	if(!request.getAttribute("msg").equals(null) && request.getAttribute("msg").toString()!=""){
                  		error = request.getAttribute("msg").toString();
                  	}
                  %> <%=error%></h6>
              </div>
              
              <form class="user" id="regform" method="POST" action="registerUser">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="exampleFirstName" placeholder="First Name" name="fname">
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="exampleLastName" placeholder="Last Name" name="lname">
                  </div>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="exampleInputEmail" placeholder="Email Address" name="email">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control form-control-user" id="exampleInputText" placeholder="Mobile No" name="mobile">
                  </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="Password" name="pass1">
                  </div>
                  <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user" id="exampleRepeatPassword" placeholder="Repeat Password" name="pass2">
                  </div>
                </div>
                <div class="text-center">  
                <input type="submit" class="btn btn-primary btn-user" value="Register Account"/>
                </div>
              </form>
              <hr>
              <div class="text-center">
                <a class="small" href="index.jsp">Go to Home!</a>
              </div>
              <div class="text-center">
                <a class="small" href="loginUser">Already have an account? Login!</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Angular -->
  <script src="./js/angular.js"></script>

  <!-- Bootstrap core JavaScript-->
  <script src="./js/jquery.min.js"></script>
  <script src="./js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="./js/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="./js/sb-admin-2.min.js"></script>

  <script>
    $("#regform").submit(function (e) {
      var validationFailed = validate();
      // do your validation here ...

      if (!validationFailed) {
          e.preventDefault();
          return false;
      }
   }); 

    function validate(){
      var fname = $("input[name=fname]").val();
      var lname = $("input[name=lanme]").val();  
      var email = $("input[name=email]").val();
      var mobile = $("input[name=mobile]").val();
      var pass1 = $("input[name=pass1]").val();
      var pass2 = $("input[name=pass2]").val();
      if(fname=="" || lname=="" || email=="" || mobile=="" || pass1=="" || pass2==""){
          alert("All details are required..");
          return false;
      }
      if(!IsEmail(email)){
          alert("Enter valid email..");
          return false;
      }
      if(!IsMobile(mobile)){
          alert("Enter valid mobile no..");
          return false;
      }
      if(pass1 != pass2){
          alert("Password not match..");
          return false;
      }
      return true;
    };

    function IsEmail(email) {
      var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
      if(!regex.test(email)) {
         return false;
      }else{
         return true;
      }
    };

    function IsMobile(mobile) {
      var regex = /^\d{10}$/;
      if(!regex.test(mobile)) {
         return false;
      }else{
         return true;
      }
    };
  </script>

</body>

</html>
