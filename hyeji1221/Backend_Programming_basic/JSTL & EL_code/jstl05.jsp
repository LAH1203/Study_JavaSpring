<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--<c:import url="http://localhost:8090/firstweb/jstlValue.jsp" var="urlValue" scope="request"></c:import>--%> 
<c:import url="https://google.co.kr" var="urlValue" scope="request"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${urlValue }
</body>
</html>