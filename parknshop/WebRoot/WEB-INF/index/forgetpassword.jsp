<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>忘记密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    忘记密码页面. <br>
    <form action="login!forgetPassword.action" method="post">
    	用户名：&nbsp;&nbsp;<input type="text" name="username" placeholder="请输入你的用户名"/><br/>
    	注册邮箱：<input type="text" name="email" placeholder="请输入你的注册邮箱地址"/><br/>
    	<input type="submit" value="找回密码" />
    </form>
  </body>
</html>
