<%@page import="jdbc.Dto"%>
<%@page import="jdbc.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<script type="text/javascript">

function dele(){
	
	location.href="deleCheck.jsp";
	
	
}

</script>

</head>
<body>
<%
request.setCharacterEncoding("utf-8");

%>
<%

String id= request.getParameter("id");
String passwd = request.getParameter("passwd");

Dao dao = Dao.getInstance();

Dto dto = dao.login(id,passwd); 

if(dto.getId()==null){
	
	out.println("로그인 실패");
	
}else{
	
	session.setAttribute("id", dto.getId());
	session.setAttribute("passwd", dto.getPasswd());
	out.println(dto.getId()+"님 반갑습니다.");
	%>
<input type="button" value="회원정보수정"/>
<input type="button" value="탈퇴"/ onclick="dele()">
<% 	
}

%>

</body>
</html>