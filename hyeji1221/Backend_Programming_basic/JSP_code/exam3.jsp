<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- JSP 주석 입니다!!
	여러줄 사용 가능 --%>
<!--  HTML 주석 -->
<%
	// 자바 주석
	for(int i = 1; i<=5; i++) {
		
%>
<H<%=i %>>아름다운 한글</H<%=i %>>
<%
	}
%>
</body>
</html>