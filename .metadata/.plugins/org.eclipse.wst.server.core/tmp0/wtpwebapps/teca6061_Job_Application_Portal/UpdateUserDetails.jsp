<%@page import="com.jsp.Model.UserInformation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Details</title>
</head>
<body style="display: flex; justify-content: center; align-items: center;">

	<%
	UserInformation userInformation = (UserInformation) session.getAttribute("userbyid");
	%>
	
    <form action="updateuserdetails" style="background-color:cornsilk;align-content: center;">
        <fieldset>
            <legend>Update</legend>
            <table>
                <tr>
                    <td>First Name</td>
                    <td>:</td>
                    <td>
                        <input value="<%= userInformation.getFirstName()%>"  name="firstName">
                    </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td>:</td>
                    <td>
                        <input value="<%= userInformation.getLastName()%>" name="lastName">
                    </td>
                </tr>
                <tr>
                    <td>Email ID</td>
                    <td>:</td>
                    <td>
                        <input value="<%= userInformation.getEmailId()%>" name="emailId">
                    </td>
                </tr>
                <tr>
                    <td>Mobile Number</td>
                    <td>:</td>
                    <td>
                        <input value="<%= userInformation.getMobileNumber()%>" name="mobileNumber">
                    </td>
                </tr>
                <tr>
                    <td>Qualification</td>
                    <td>:</td>
                    <td>
                        <input value="<%= userInformation.getQualification()%>" name="qualification">
                    </td>
                </tr>
                <tr>
                    <td>Percentage</td>
                    <td>:</td>
                    <td>
                        <input value="<%= userInformation.getPercentage()%>" name="percentage">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="reset" value="RESET" style="background-color:olive; border: none; color: white; border-radius: 2px;">
                    </td>
                    <td>
                        <input type="submit" value="UPDATE" style="display: flex; justify-content: start; background-color: blue; border: none; color: white; border-radius: 2px;">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>