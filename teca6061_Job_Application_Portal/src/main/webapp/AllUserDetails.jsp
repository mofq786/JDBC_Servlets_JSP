<%@page import="com.jsp.Model.UserInformation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All User Details</title>
<style>
th,td{
border: 1px solid black;
}
table
{
border: 4px solid black;
border-collapse: collapse;
width:100%;
}
header
{
height: 50px;
background-color: black;
color: white;
align-items:center;
}
article
{
	height:50px;
}
.search{
    width: 25%;
    height: 40px;
    float: right;
    border:none;
}
h1{
    width: fit-content;
    float: left;
}
.button
{
	background-color: #0b57d0;
	color: white;
	border-radius:2px;
	font-family: Arial;
	border:none;
	font-size:15px;
}
</style>
</head>
<body>
<%
	String name = (String) session.getAttribute("name");
%>

<header>
<h1>Welcome, <%=name%></h1>
<form action="searchuser">
    <input type="search" name="search" placeholder="search" class="search">
    <input type="submit" value="Search" class="button" style="float: left;">
</form>
<div style="width: 5%; height: 50px; float: left;">

</div>
</header>

<main>
<article>
</article>
<center>
<table>
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>MobileNumber</th>
<th>Email_Id</th>
<th>Password</th>
<th>Qualification</th>
<th>Percentage</th>
<th>Gender</th>
</tr>

<%

List <UserInformation> list = (List<UserInformation>)
		session.getAttribute("listOfUsers");

for(UserInformation information: list)
{
%>
	<tr>
	<td><%=information.getFirstName() %></td>
	<td><%=information.getLastName()%></td>
	<td><%=information.getMobileNumber()%></td>
	<td><%=information.getEmailId()%></td>
	<td><%=information.getPassword()%></td>
	<td><%=information.getQualification()%></td>
	<td><%=information.getPercentage()%></td>
	<td><%=information.getGender()%></td>
	<th style="">
		<form action="getuserid">
			<input value="<%= information.getId()%>" hidden="true" name="userId">
			<input class="button" type="submit" value="UPDATE" >
		</form>
	</th>
	<th>
		<form action="deleteuserdetails">
			<input value="<%= information.getId()%>" hidden="true" name="userId">
			<input class="button" style="background-color: lightcoral;" type="submit" value="DELETE" >
		</form>
	</th>
	</tr>
	<% 
}

%>
</table>
</center>
</main>
</body>
</html>