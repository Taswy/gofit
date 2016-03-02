<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="css/nav.css">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/main_page_style.css">
	<style>
		#mask_2 {
			background-color: rgba(0,0,0,0.1);
		}
		#log_frame_2 {
			margin-top: -5%;
		}
	</style>
</head>
<body>
	
	<div id="mask_2">
		<div id="log_frame_2">
			<div id="logo_div"><img src="images/logo.png" alt=""></div>
			<form action="update" method="get">
				<input name="username" type="text" id="username" class="Account_number" value="" placeholder="�û���*����Ӣ�ĺ����ֹ���">
				<input name="email" type="text" id="Account_number_2" class="Account_number" value="" placeholder="����">
				<input name="pwd" type="password" id="Password_2" class="Password" value="" placeholder="����">
				<div name="cars" id="select">
					����
				</div>
				<ul class="hide">
					<li>����</li>
					<li>�Ϻ�</li>
					<li>����</li>
					<li>����</li>
					<li>����</li>
				</ul>
				<input type="submit" id="submit_2" value="�� ��" disabled="true">
			</form>
		</div>
	</div>

</body>
<script src="js/jquery.js"></script>
<script src="js/gofit.js"></script>
<script src="js/common.js"></script>
<script>

    $('#mask_2').unbind("click");

</script>
</html>