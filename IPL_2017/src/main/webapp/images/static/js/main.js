function formValidation() {

	var fname = document.myform.firstname;
	var lname = document.myform.lastname;
	var em = document.myform.email;
	var pass = document.myform.password;
	var cpass = document.myform.confirmPassword;
	var mob = document.myform.mobile;
	var ct = document.myform.city;
	var ctry = document.myform.country;

	var fn_len = fname.value.length;
	var passid_len = pass.value.length;
	var numbers = /^[0-9]+$/;
	var ct_len = ct.value.length;

	var letters = /^[A-Za-z]+$/;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (fname.value.match(letters)) {
		if (lname.value.match(letters)) {
			if (em.value.match(mailformat)) {
				if (passid_len == 0) {
					alert("Password should not be empty");
					document.myform.password.focus();
					return false;
				}
				if (cpass.value !== pass.value) {
					alert("Password does not match");
					document.myform.confirmPassword.focus();
					return false;
				}
				if (mob.value.match(numbers)) {

					if (ct_len == 0) {
						alert("Please provide city name!");
						document.myform.city.focus();
						return false;
					}
					if (ctry.value == "-1") {
			            alert("Please select an option!");
			            document.myform.country.focus();
			            return false;
					}
				} else {
					alert("Please provide numeric mobile number!");
					document.myform.mobile.focus();
					return false;
				}

			} else {
				alert("You have entered an invalid email address!");
				document.myform.email.focus();
				return false;
			}

		} else {
			alert('Please provide your lastname!/Username must have alphabet characters only');
			document.myform.lastname.focus();
			return false;
		}
	} else {
		alert('Please provide your firstname!/Username must have alphabet characters only');
		document.myform.firstname.focus();
		return false;
	}

}
