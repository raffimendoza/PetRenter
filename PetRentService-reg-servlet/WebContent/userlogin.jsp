<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; chars=ISO-8859-1">
  <title>Pet Rent</title>
  </head>
  <body>
 <div align="center" style="font-family:Courier; with: 80%;">
 <h1>Login</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="font-family:Courier; background-color:skyblue; with: 80%;">
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" name="submit" value="Login" />
   <table>
   <tr>
   	<td><a href="userregister.jsp">Click here to Register</a></td></tr>
   </table>
   <table style="font-family:Courier; with: 80%;">
    <tr>
   	<td><a href="forgotpassword.jsp">Forgot Password?</a></td></tr>
   </table>
  </form>
  </div>
</body>
</html>
