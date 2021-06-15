<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.harshilphs.model.User" %>
    
<%

	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //HTTP 1.1
	
	response.setHeader("Pragma","no-cache"); // Http 1.0
	
	response.setHeader("Expires","0");
	User user = new User();
	if(session.getAttribute("email")==null){
		response.sendRedirect("loginUser");
	} else{
		user = (User)session.getAttribute("user");
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

  <title>Compliant Dashboard</title>

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
		          
		  <h3><a href="#" style="text-decoration:none;">Complaint Management System</a></h3>
          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">
          	
          	
          	

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link " href="#"  data-toggle="modal" data-target="#feedbackModal">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Feedback</span>
              </a>
            </li>
            
            <div class="topbar-divider d-none d-sm-block"></div>
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=user.getEmail()%></span>
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
				
				<a class="dropdown-item" href="#" data-toggle="modal" data-target="#editProfileModal">
                  Edit Profile
                </a>
				
				
				<div class="dropdown-divider"></div>
                
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
          <div class="row">
	      <div class="card mb-4 py-3 border-left-primary col-5">
               <div class="card-body">
                 <a class="btn btn-primary text-light" href="viewComplaint">View your complaint</a>
               </div>
           </div>
           <div class="card mb-4 py-3 border-left-primary offset-2 col-5">
               <div class="card-body">
                 <a class="btn btn-primary text-light" href="raiseComplaint">Raise a complaint</a>
               </div>
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
  
 <!-- edit profile modal --> 
 <div class="modal fade" id="editProfileModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Edit your profile</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form method="post" action="updateProfile" id="updateProfile">
          <input type="text" class="form-control" name="uid" style="display:none;" value="<%=user.getId() %>">
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">First name:</label>
            <input type="text" class="form-control" name="fname" value="<%=user.getFirstname()%>">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Last name:</label>
            <input type="text" class="form-control" name="lname" value="<%=user.getLastname()%>">
          </div>
                    
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Email:</label>
            <input type="text" class="form-control" name="email" value="<%= user.getEmail() %>">
          </div>
          
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Mobile:</label>
            <input type="text" class="form-control" name="mobile" value="<%= user.getMobile() %>">
          </div>
          
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Password:</label>
            <input type="text" class="form-control" name="pass" value="<%= user.getPassword() %>">
          </div>
          
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">Update</button>
	      </div>
          
        </form>
      </div>

    </div>
  </div>
</div>

<!-- feedback modal -->
 <div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Leave your feedback</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form method="post" action="feedback" id="feedbackForm">
            
            <div class="mb-3 row">
  		    <label for="exampleFormControlInput1" class="form-label col-4">Give us rating</label>
  		    
  		    	<div class="col-8">
		            <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="rating" id="1" value="1">
					  <label class="form-check-label" for="1">1</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="rating" id="2" value="2">
					  <label class="form-check-label" for="2">2</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="rating" id="3" value="3">
					  <label class="form-check-label" for="3">3</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="rating" id="4" value="4">
					  <label class="form-check-label" for="4">4</label>
					</div>
		
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="rating" id="5" value="5" checked>
					  <label class="form-check-label" for="5">5</label>
					</div>
				</div>
			</div>
			

          
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">Drop Feedback</button>
	      </div>
          
        </form>
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
  $("#updateProfile").submit(function (e) {
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
      var pass1 = $("input[name=pass]").val();
      if(fname=="" || lname=="" || email=="" || mobile=="" || pass1==""){
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
