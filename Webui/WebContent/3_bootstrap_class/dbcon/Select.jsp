<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="zetc.*" %>   
<%@ page import="java.util.List" %>
 
<%
	// 전체 레코드 검색  
	List<EmpVO> mList = EmpDAO.getInstance().selectList();

%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 사원 전체 목록 </title>
</head>
<body>

	<table border="1">
		<tr>
			<td>번호</td><td>이름</td><td>상품</td><td>상품평</td><td>별점</td>
		</tr>
		<% for( EmpVO  e : mList ) { %>
		<tr>	
			<td> <%= e.getNo() %> </td> 
			<td> <%= e.getName() %> </td> 
			<td> <%= e.getItem() %> </td> 
			<td> <%= e.getContent() %> </td> 
			<td> <%= e.getStars() %> </td>		
		</tr>
		<% } // end of for %>
	
	</table>
	
	
	<br/><a href="../Ex05_form.html">상품평 등록</a>
<!-- 	<a href="/WebContent/3_bootstrap_class/Ex05_form.html">상품평 등록</a> -->
</body>
</html>