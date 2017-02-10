<%@page import="java.sql.Timestamp"%>
<%@page import="jdbc.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="Dto" class="jdbc.Dto" scope="page">
<jsp:setProperty property="*" name="Dto"/>
</jsp:useBean>


<%
request.setCharacterEncoding("utf-8");
%>

<%
	Dao dao = Dao.getInstance();
	Dto.setReg_date(new Timestamp(System.currentTimeMillis()));
	int result = dao.insertMember(Dto);
	
	if(result ==1){
		
		out.println("회원가입성공");
		
	}else{
		out.println("회원가입실패");
	}

%>


</body>
</html>