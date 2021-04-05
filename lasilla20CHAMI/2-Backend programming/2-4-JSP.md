JSP
==
> JSP 자체가 동작하는 게 아니라, 모든 JSP는 `servlet`으로 바뀌어서 동작한다.

### JSP의 실행순서
1. 브라우저가 웹서버에 JSP에 대한 요청 정보를 전달한다.
2. 브라우저가 요청한 JSP가 최초로 요청했을 경우만 JSP로 작성된 코드가 서블릿으로 코드로 변환한다. (java 파일 생성)
3. 서블릿 코드를 컴파일해서 실행가능한 bytecode로 변환한다. (class 파일 생성)
4. 서블릿 클래스를 로딩하고 인스턴스를 생성한다.
5. 서블릿이 실행되어 요청을 처리하고 응답 정보를 생성한다.

<br>

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
<br>

- JSP를 보면서 서블릿으로 어떻게 바뀔지 생각해야 한다. (자동으로 바뀌기 때문)
- `<%!` 표현식은 sevice 바깥에다가 코드(매서드)를 실행시키고 싶다는 뜻.
- 최초로 요청했을 때, 두 번째로 요청했을 때 수정한 다음에 요청했을 때를 알아보기 위해⬇
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello
<%
	System.out.println("_jspService()");
%>

<%!
public void jspInit() {
	System.out.println("jspInit()!");
}

public void jspDestroy() {
	System.out.println("jspDestroy()");
}
%>

</body>
</html>
```
