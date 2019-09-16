<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectEmployeesOne.jsp</title>
</head>
<body>
<%
	int empNo= 10001;//임의의 한명을가져옴
	//1,기능 connection 가져오는 기능
	//2.select 쿼리 실행후 ResultSet 가져오는 기능 쿼리를 늘려서 결과물을 가져온다
	EmployeesDao employeesDao= new EmployeesDao();
	Employees employees =employeesDao.selectEmployeesOne(empNo);
	
%>
		<table border="1">
			<tr>
				<td>empNo</td>
				<td><%=employees.empNo%></td>
			</tr>
			<tr>
				<td>birthDate</td>
				<td><%=employees.birthDate%></td>
			</tr>
			<tr>
				<td>firstName</td>
				<td><%=employees.firstName%></td>
			</tr>
			<tr>
				<td>lastName</td>
				<td><%=employees.lastName%></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><%=employees.gender%></td>
			</tr>
			<tr>
				<td>hireDate</td>
				<td><%=employees.hireDate%></td>
			</tr>
		</table>
<%
	
%>
</body>
</html>