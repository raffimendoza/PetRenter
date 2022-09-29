<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet Rent</title>
</head>
<body>
 <div align="center" style="font-family:Courier; with: 80%;">
  <h1>Create Account</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="font-family:Courier; background-color:skyblue; with: 80%;">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="fName" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lName" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Contact Number</td>
     <td><input type="text" name="contact" /></td>
    </tr>
    <tr>
   </table>
   <input type="submit" name="submit" value="Register" />
   <table style="font-family:Courier; with: 80%;">
   <tr>
   <td><a href="userlogin.jsp">Click here to Login</a></td></tr>
   </table>
  </form>
 </div>
</body>
</html>