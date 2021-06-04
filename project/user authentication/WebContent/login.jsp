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

  <title>Login</title>

  <!-- Custom fonts for this template-->
  <link href="./css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="./css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-12">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <div class="text-center"><h6 style="color:red;">
                  <%
                  	String error="";
                  	if(!request.getAttribute("msg").equals(null) && request.getAttribute("msg").toString()!=""){
                  		error = request.getAttribute("msg").toString();
                  	}
                  %> <%=error%></h6>
                  
                  <h6 style="color:green;">${sucmsg}</h6>
                  <c:remove var="sucmsg" scope="session" /> 
                  
                  </div>
                  <div class="text-center">
                  <form class="user" id="loginform" method="POST" action="loginUser">                 	
                    <div class="form-group">
                      <input type="text" name="email" class="form-control form-control-user" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter Email Address...">
                    </div>
                    <div class="form-group">
                      <input type="password" name="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="Password">
                    </div>
                    <div class="text-center">
                    <input type="submit" class="btn btn-primary btn-user" value="Login"/>
                    </div>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="index.jsp">Go to Home!</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="registerUser">Create an Account!</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="./js/jquery.min.js"></script>
  <script src="./js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="./js/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="./js/sb-admin-2.min.js"></script>

  <script>
      $("#loginform").submit(function (e) {
        var validationFailed = validate();
        // do your validation here ...

        if (!validationFailed) {
            e.preventDefault();
            return false;
        }
     }); 

      function validate(){
        var email = $("input[name=email]").val();
        var pass = $("input[name=password]").val();
        if(email=="" && pass==""){
            alert("Email and Password are required..");
            return false;
        }
        if(!IsEmail(email)){
            alert("Enter valid email..");
            return false;
        }
        if(!pass){
            alert("Password is required..");
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


  </script>

</body>

</html>