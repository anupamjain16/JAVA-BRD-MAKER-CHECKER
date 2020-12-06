		function validation() {
			var numbers = /^[0-9]+$/;
			var cod = document.userForm.customerCode.value;
			var email = document.userForm.emailAddress.value;
			var con = document.userForm.contactNumber.value;
			var name = document.userForm.customerName.value;
			var letters = /^[A-Za-z]+$/;
			var coderex = /^[A-Za-z0-9]+$/;
			var Email = /^([a-z A-Z 0-9 _\.\-])+\@(([a-z A-Z 0-9\-])+\.)+([a-z A-z 0-9]{3,3})+$/;
			var add1 = document.userForm.customerAddress.value;
			var flag = 0;

			if (cod == null || cod == "") {
				document.getElementById("codemsg").innerHTML = "invalid code";
				flag++;
			}
			if (cod.match(coderex)) {

			} else {

				document.getElementById("codemsg").innerHTML = "invalid code";

				flag++;
			}
			if (email.match(Email)) {

			} else {

				document.getElementById("emailmsg").innerHTML = "invalid email";

				flag++;
			}

			if (name == null || name == "") {
				document.getElementById("namemsg").innerHTML = "invalid name";
				flag++;
			}
			if (name.match(letters)) {

			} else {
				document.getElementById("namemsg").innerHTML = "invalid name";
				flag++;
			}
			if ((con.match(numbers))) {

			} else {
				document.getElementById("contactnumbermsg").innerHTML = "invalid number";

				flag++;
			}

			if (con.length == 0) {
				document.getElementById("contactnumbermsg").innerHTML = "invalid number";
			}

			if (add1.length == 0) {
				document.getElementById("addressmsg").innerHTML = "invalid address";
				return false;
			}

			if (con.length != 10) {
				document.getElementById("contactnumbermsg").innerHTML = "invalid number";
				return false;
			}
			if (flag) {
				//alert('Please Enter the Right Details for login');

				return false;
			} else
				return true;
		}
	