<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>

						<form method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name"
									required="required" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email"
									required="required" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password"
									required="required" />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" required="required" />
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
		integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="js/main.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.all.min.js"></script>
	<link
		href="https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.min.css"
		rel="stylesheet">

	<script type="text/javascript">
		// Chặn reload page thì submit form
		if (window.history.replaceState) {
			window.history.replaceState(null, null, window.location.href);
		}

		var status = document.getElementById("status").value;
		if (status == "success") {

			/* swal("Congrats", "Account Created Successfully", "success"); */

			Swal.fire({
				position : "center",
				icon : "success",
				title : "Congrats",
				text : "Account Created Successfully!",
			});
		}

		if (status == "InvalidUsername") {

			Swal.fire({
				position : "center",
				icon : "error",
				title : "Sorry",
				text : "Please Enter Username!",
			});
		}

		if (status == "InvalidEmail") {

			Swal.fire({
				position : "center",
				icon : "error",
				title : "Sorry",
				text : "Please Enter Email!",
			});
		}

		if (status == "InvalidPassword") {

			Swal.fire({
				position : "center",
				icon : "error",
				title : "Sorry",
				text : "Please Enter Password!",
			});
		}

		if (status == "InvalidRePassword") {

			Swal.fire({
				position : "center",
				icon : "error",
				title : "Sorry",
				text : "Please Enter Repeat your password!",
			});
		}

		if (status == "MatchPassword") {

			Swal.fire({
				position : "center",
				icon : "error",
				title : "Sorry",
				text : "Password does not match password confirm!",
			});
		}

		if (status == "InvalidContact") {

			Swal.fire({
				position : "center",
				icon : "error",
				title : "Sorry",
				text : "Please Enter Contact!",
			});
		}

		if (status == "InvalidContactLength") {

			Swal
					.fire({
						position : "center",
						icon : "error",
						title : "Sorry",
						text : "Please enter at least 10 characters and no more than 11 characters!",
					});
		}
	</script>

</body>
</html>