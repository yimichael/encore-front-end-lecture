<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="zetc.*"%>    
<% 
		request.setCharacterEncoding("utf-8"); 
		EmpVO vo = new EmpVO();
		vo.setName(request.getParameter("name"));
		vo.setItem(request.getParameter("item"));
		vo.setContent(request.getParameter("content"));
		vo.setStars(request.getParameter("stars"));
		EmpDAO.getInstance().insert(vo);
		
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>디비 화면 테스트  </title>
</head>
<body>
	<font size="3" color="#bb44cc">
		사원 등록이 성공적으로 진행하였습니다. 
	</font><br/><br/><br/>
	<a href=""> [ 목록보기 ]</a><br/>

</body>
</html>