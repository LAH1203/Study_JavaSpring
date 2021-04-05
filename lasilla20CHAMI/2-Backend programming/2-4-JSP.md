JSP
==

- JSP 자체가 동작하는 게 아니라, 모든 JSP는 servlet으로 바뀌어서 동작한다.
```jsp
//<%@ 를 지시자라고 부름
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sum10</title>
</head>
<body>

<% //안에 java 코드가 들어가있음(Scriptlet)
    int total = 0;
    for(int i = 1; i <= 10; i++){
        total = total + i;
    }
%>

1부터 10까지의 합 : <%=total %> //표현식

</body>
</html>
```

- JSP를 보면서 서블릿으로 어떻게 바뀔지 생각해야 한다
