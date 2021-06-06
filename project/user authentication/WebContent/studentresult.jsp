<%@page import="com.harshilphs.weekendTasks.StudentMarks"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
		
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //HTTP 1.1
		
		response.setHeader("Pragma","no-cache"); // Http 1.0
		
		response.setHeader("Expires","0");
		
	
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		}
		StudentMarks stm=new StudentMarks();
		String res="";
		int total = 0;
		String pr = ""; 
		if(request.getAttribute("stResult") == null){
			response.sendRedirect("studentMarksEntry");
		} else{
			stm = (StudentMarks)request.getAttribute("stResult");
			if(stm.getPhysics()<35 || stm.getChemistry()<35 || stm.getMaths()<35 || stm.getComputer()<35 || stm.getSocialScience()<35 || stm.getEnglish()<35 || stm.getHindi()<35){
				res = "This student couldn't clear exam.";
			}else{
				res = "This student passed this exam.";
			}
			
			total = stm.getPhysics()+stm.getChemistry()+stm.getMaths()+stm.getComputer()+stm.getSocialScience()+stm.getEnglish()+stm.getHindi();
			float avg = total/700;
			pr = String.format("%.2f",(total*100)/700f);
			
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
  
  <style>
  	td{
  	padding-right: 5px;
  	}
  </style>

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
        <div class="container">

         

          <!-- Page content --> 
          <nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="studentMarksEntry">Mark Entry</a></li>
			    <li class="breadcrumb-item active" aria-current="page">Result</li>
			  </ol>
		  </nav>
                   
        </div>
        <!-- /.container-fluid -->
        <div class="container">
        	<div class="card mb-4 py-3 border-bottom-primary">
                <div class="card-body">
                	<div class="row mb-3">
                		<div class="col-3"><img src="images/asoit_logo.png" alt="college logo" height="60" width="70"/></div>
                		<div><h2>Aditya Silver Oak Institute Of Technology</h2></div>
                	</div>
                	
                	<h4>Student name :  <%=stm.getName() %></h4><hr>
                	<table>
                		<tr>
                			<td><h5>Physics</h5></td>
                			<td><h6> : <%= stm.getPhysics() %></h6></td>
                		</tr>
                		<tr>
                			<td><h5>Chemistry</h5></td>
                			<td><h6> : <%=stm.getChemistry() %></h6></td>
                		</tr>
                		<tr>
                			<td><h5>Maths</h5></td>
                			<td><h6> : <%=stm.getMaths() %></h6></td>
                		</tr>
                		<tr>
                			<td><h5>Computer</h5></td>
                			<td><h6> : <%=stm.getComputer() %></h6></td>
                		</tr>
                		<tr>
                			<td><h5>Social Science</h5></td>
                			<td><h6> : <%=stm.getSocialScience() %></h6></td>
                		</tr>
                		<tr>
                			<td><h5>English</h5></td>
                			<td><h6> : <%=stm.getEnglish() %></h6></td>
                		</tr>
                		<tr>
                			<td> <h5>Hindi</h5></td>
                			<td><h6> : <%=stm.getHindi() %></h6></td>
                		</tr>

                	</table> 
                	
                	<div class="text-center">
                	<h6>Total : <%=total %></h6>
                	<h6>Percentage : <%=pr %>%</h6>
                	<h5><%=res %></h5>
                	</div>               
                 
                </div>
              </div>
        </div>

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
  


</body>

</html>
