<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--prefix를 지정하여 사용자 지정 tag를 사용할 수 있도록 함 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="value1" scope="request" value="Lee"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
성 : ${ value1 } <br>
<c:remove var="value1" scope="request"/>
성 : ${ value1 } <br>
</body>
</html>