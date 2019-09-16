<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("uf-8");

	String gender= request.getParameter("gender");
	String[] searchColunm= request.getParameterValues("serchColunm");
	String word = request.getParameter("word");
	System.out.println("gender:"+gender);
	System.out.println("serchColunm");
	if(searchColunm != null){
		for(String sc:searchColunm){
			System.out.println(sc);
		}
	}
	System.out.println("word:"+word);
	//
	int currentPage=1;
	if(request.getParameter("currentPage")!=null){
		currentPage=Integer.parseInt(request.getParameter("currentpage"));
	}
	final int ROW_PER_PAGE=10;
	
	EmployeesDao employeesDao= new EmployeesDao();
%>
	<h1></h1>부서목록
	<!-- 검색폼시작 -->
	<form action="./selectEmployeesList.jsp">
		<div>
			gender:
			<select>
				<option>전체</option>
				<option>남자</option>
				<option>여자</option>
			</select>
		</div>
		
	</form>
</body>
</html>