function formValidation() {
	var fname = document.getElementById('firstNameInput');
	var lname = document.registration.lastNameInput;
	if (userName_validate(fname, lname)) {
		return true;
	}
	return false;

}
function userName_validate(first, last) {
	var letters = /^[A-Za-z]+$/;
	if (first.value.match(letters)||last.value.match(letters)) {
		return true;
	}
	else{
		alert('Username must have alphabet characters only');
		first.focus();
		last.focus();
		return false;
	}

}
