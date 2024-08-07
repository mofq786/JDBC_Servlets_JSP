<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>

<body style="display: flex; justify-content: center; align-items: center;">
    <form action="adminlogin" style="background-color:cornsilk;align-content: center;">
        <fieldset>
            <legend>Admin Login</legend>
            <table>
                <tr>
                    <td>Email ID</td>
                    <td>:</td>
                    <td>
                        <input type="email" placeholder="Enter Email" name="email">
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>:</td>
                    <td>
                        <input type="password" placeholder="Enter Password" name="password">
                    </td>
                </tr>
                <tr>
           
                    <td style="display: flex;">
                        <input type="reset" style="background-color:olive; border: none; color: white; border-radius: 2px;">
                    </td>
              		<td></td>
                    <td>
                        <input type="submit" value="Login" style="display: flex; justify-content: end; background-color: blue; border: none; color: white; border-radius: 2px;">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>

</html>