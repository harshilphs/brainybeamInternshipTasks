<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
		
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //HTTP 1.1
		
		response.setHeader("Pragma","no-cache"); // Http 1.0
		
		response.setHeader("Expires","0");
		
	
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		}
		
		
%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Marks Entry Portal</title>

  <!-- Custom fonts for this template-->
  <link href="css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">


    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
		          
		  <h3><a href="#" style="text-decoration:none;">Student Marks Entry Portal</a></h3>
          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">
          	

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=session.getAttribute("email")%></span>
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">

                
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container bg-light">

          <!-- Page content --> 
          <div class="card mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Marks Entry</h6>
                </div>
                <div class="text-center"><h6 style="color:red;">
                  <%
                  	String error="";
                  	if(!request.getAttribute("msg").equals(null) && request.getAttribute("msg").toString()!=""){
                  		error = request.getAttribute("msg").toString();
                  	}
                  %> <%=error%></h6></div>
                <div class="card-body">
                  <form class="user" id="stentry" method="POST" action="studentMarksEntry">                 	
                    <div class="form-group">
					    <label for="name">Enter student name</label>
					    <input type="text" class="form-control  form-control-user" name="name" placeholder="Firstname Lastname">
					</div>
					<div class="form-group">
					    <label for="name">Physics Marks</label>
					    <input type="number" class="form-control  form-control-user" name="pm" >
					</div>
					<div class="form-group">
					    <label for="name">Chemistry Marks </label>
					    <input type="number" class="form-control  form-control-user" name="cm" >
					</div>
					<div class="form-group">
					    <label for="name">Maths Marks</label>
					    <input type="number" class="form-control  form-control-user" name="mm" >
					</div>
					<div class="form-group">
					    <label for="name">Computer Marks</label>
					    <input type="number" class="form-control  form-control-user" name="com">
					</div>
					<div class="form-group">
					    <label for="name">Social Science Marks</label>
					    <input type="number" class="form-control  form-control-user" name="ssm">
					</div>
					<div class="form-group">
					    <label for="name">English Marks</label>
					    <input type="number" class="form-control  form-control-user" name="em">
					</div>
					<div class="form-group">
					    <label for="name">Hindi Marks</label>
					    <input type="number" class="form-control  form-control-user" name="hm">
					</div>
                    <div class="text-center">
                    <input type="submit" class="btn btn-primary btn-user" value="Generate Result"/>
                    </div>
                  </form>
                </div>
          </div>
                   

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="logout">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="js/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>
  
    <script>
    
    $("#stentry").submit(function (e) {
        var validationFailed = validate();
        

        if (!validationFailed) {
            e.preventDefault();
            return false;
        }
     }); 
  
        function validate(){
        var name = $("input[name=name]").val();
        var phy = $("input[name=pm]").val();
        var che = $("input[name=cm]").val();
        var math = $("input[name=mm]").val();
        var com = $("input[name=com]").val();
        var social = $("input[name=ssm]").val();
        var eng = $("input[name=em]").val();
        var hindi = $("input[name=hm]").val();
        if(name=="" || phy=="" || che=="" || math=="" ||  com=="" || social==""
        		|| eng=="" || hindi=="" ){
            alert("All data are required..");
            return false;
        }

        return true;
      };


</script>
  


</body>

</html>
