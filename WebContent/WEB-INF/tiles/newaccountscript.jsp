<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	$(document).ready(onLoad);

	function onLoad() {
		$("#password").keyup(checkPasswordMatch);
		$("#confirmpass").keyup(checkPasswordMatch);
		$("#details").submit(canSubmit);

	}
	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if (password != confirmpass) {
			alert("Passwords do not mactch");
			return false;
		} else {
			return true;
		}
	}
	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if (password.length < 3) {
			return;
		}
		if (password == confirmpass) {
			$("#matchpass").text("Passwords match");
			$("#matchpass").addClass("valid");
			$("#matchpass").removeClass("error");
		} else {
			$("#matchpass").text("Passwords do not match!")
			$("#matchpass").addClass("error");
			$("#matchpass").removeClass("valid");

		}
	}
</script>