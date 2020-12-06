		function validation() {
			var numbers = /^[0-9]+$/;
			var cod = document.userForm.customerCode.value;
			var email = document.userForm.emailAddress.value;
			var con = document.userForm.contactNumber.value;
			var name = document.userForm.customerName.value;
			var pincode = document.userForm.customerPinCode.value;
			var add1 = document.userForm.customerAddress.value;
			var letters = /^[A-Za-z]+$/;
			var coderex = /^[A-Za-z0-9]+$/;
			var pinrex =/^[0-9]+$/;
			var Email = /^([a-z A-Z 0-9 _\.\-])+\@(([a-z A-Z 0-9\-])+\.)+([a-z A-z 0-9]{3,3})+$/;
			var flag = 0;

			if (cod == null || cod == "") {
				document.getElementById("codemsg").innerHTML = " Please Enter valid  Customer Code";
				document.userForm.customerCode.focus();
				flag++;
			}
			if (cod.match(coderex)) {
			} else {
				document.getElementById("codemsg").innerHTML = "Please Enter valid  Customer Code";
				document.userForm.customerCode.focus();
				flag++;
			}
			if (email.match(Email)) {
			} else {
				document.getElementById("emailmsg").innerHTML = "Please Enter valid  Customer Email";
				document.userForm.emailAddress.focus();
				flag++;
			}
			if (name == null || name == "") {
				document.getElementById("namemsg").innerHTML = "Please Enter valid  Customer Name";
				document.userForm.customerName.focus();
				
				flag++;
			}
			if (name.match(letters)) {

			} else {
				document.getElementById("namemsg").innerHTML = "Please Enter valid Customer Name";
				document.userForm.customerName.focus();
				flag++;
			}
			if ((con.match(numbers))) 
			{

			} 
			else 
			{
				document.getElementById("contactnumbermsg").innerHTML = "Only numeric value is allowed";
				document.userForm.contactNumber.focus();
				flag++;
			}

			if (con.length == 0) {
				document.getElementById("contactnumbermsg").innerHTML = "Please Enter Customer Mobile Number";
				document.userForm.contactNumber.focus();
			}
			if (con.length != 10) {
				document.getElementById("contactnumbermsg").innerHTML = "Please Enter valid Mobile Number";
				document.userForm.contactNumber.focus();
				return false;
			}
			if (add1.length == 0) {
				document.getElementById("addressmsg").innerHTML = "Please Enter Customer Address";
				document.userForm.customerAddress.focus();
				return false;
			}
			if (pincode == null || pincode == "") {
				document.getElementById("pincodemsg").innerHTML = " Please Enter valid pincode";
				document.userForm.customerPinCode.focus();
				flag++;
			}
			if (pincode.length != 6) {
				document.getElementById("pincodemsg").innerHTML = "Please Enter valid pincode";
				document.userForm.customerPinCode.focus();
				return false;
			}
			if ((pincode.match(pinrex))) {

			} else {
				
			document.getElementById("pincodemsg").innerHTML = "Please Enter valid pincode";
			document.userForm.customerPinCode.focus();
				flag++;
			}

			
			if (flag) {
				
				return false;
			} else
				return true;
		}
	