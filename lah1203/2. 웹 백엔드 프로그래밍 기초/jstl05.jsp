<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="http://localhost:8080/firstweb/jsp/jstlValue.jsp" var="urlValue" scope="request"/>
<c:import url="https://www.naver.com/" var="naver" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${ urlValue } <br>
${ naver } <br>
</body>
</html>