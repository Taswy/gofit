<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
		 	<form action="update">
	�޸���Ϣ��<br/><br/>
          ����<input type="password" name="pwd"><br/><br/>
   	����<input type="text" name="email"><br/><br/>
   	��ַ
   	<select name="city"> 
<option value="����">����</option> 
<option value="����">����</option> 
<option value="����">����</option> 
<option value="����">����</option> 
<option value="�Ϻ�">�Ϻ�</option> 
</select> 
   	<input type="text" name="address"><br/><br/>
   	<input type="submit" value="�޸�">
        <input type="reset" value="����">
	</form>
</center>
</body>
</html>
