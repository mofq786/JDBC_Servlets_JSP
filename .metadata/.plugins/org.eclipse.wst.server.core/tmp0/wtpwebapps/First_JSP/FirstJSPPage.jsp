<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	

</body>
</html>
<!-- 
<center style="color: Green">
<%= checkEvenOdd() %>
</center>

<%!
 int a = 10;

public String checkEvenOdd()
{
	if(a%2 == 0)
	{
		return a+" is Even Number";
	}
	else
	{
		return a+" is Odd Number";
	}
}
%>

<%
	int a = 13;
	
	if(this.a%2 == 0)
	{
		%>
		<h1><%= this.a+" is Even Number." %></h1>
		<%
	}
	else
	{
		%>
		<h1><%= this.a+" is Odd Number."%></h1>
		
		<%
	}
%>



<%!

public int countDigits(int num)
{
	int count = 0;
	while(num > 0)
	{
		count++;
		num /= 10;
	}
	return count;
}

public int power(int digit, int pow)
{
	int power = 1;
	while(pow-- > 0)
	{
		power *= digit;
	}
	return power;
}



%>
-->
<%

int num = 408;
int digits = countDigits(num);
int temp = num;
int sum = 0;

while(temp > 0)
{
	int digit = temp%10;
	
	sum += power(digit,digits);
	
	temp /= 10;
}

if(sum == num)
{
	%>
	<h1><%= num+" is an Armstrong Number." %></h1>
	<%
}
else
{
	%>
	<h1><%= num+" is not an Armstrong Number." %></h1>
	<%
}
%>








