객체의 범위 Scope
===

> 변수를 어떤 범위 내에서 사용하기 위해서는 스코프(scope)라는 것에 대해서 알아야 합니다.

![image](https://cphinf.pstatic.net/mooc/20180129_297/1517205425406SvaC6_JPEG/2_5_1_scope_.jpg)
- Application : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용
- Session : 웹 브라우저 별로 변수가 관리되는 경우 사용
- Request : http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용. 하나의 요청이 들어와서 응답이 나갈 때까지.
- Page : 페이지 내에서 지역변수처럼 사용. 실제 서블릿이 됐든 JSP가 됐든 선언한 한 페이지 내에서만 사용가능.

#

### Page Scope

> PageContext 추상 클래스를 사용한다.
- JSP 페이지에서 `pageContext`라는 내장 객체로 사용 가능 하다.
- `forward`가 될 경우 해당 `Page scope`에 지정된 변수는 사용할 수 없다.
- 사용방법은 `Application scope`나 `Session scope`, `request scope`와 같다.
- 마치 지역변수처럼 사용된다는 것이 다른 Scope들과 다르다.
- JSP 에서 `pageScope`에 값을 저장한 후 해당 값을 EL표기법 등에서 사용할 때 사용.
- 지역 변수처럼 해당 JSP나 서블릿이 실행되는 동안에만 정보를 유지하고자 할 때 사용.
 
 
 ### Request Scope

> http 요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수값을 유지하고자 할 경우 사용한다.
- `HttpServletRequest` 객체를, `forward` 시 값을 유지하고자 사용한다.
- JSP에서는 `request` 내장 변수를 사용한다.
- 서블릿에서는 `HttpServletRequest` 객체를 사용한다.
- 앞에서 forward에 대하여 배울 때 forward 하기 전에 request 객체의 setAttribute() 메소드로 값을 설정한 후, 서블릿이나 jsp에게 결과를 전달하여 값을 출력하도록 하였는데 이렇게 포워드 되는 동안 값이 유지되는 것이 Request scope를 이용했다고 합니다.

### Session Scope

> 웹 브라우저별로 변수를 관리하고자 할 경우 사용한다. 웹 브라우저간의 탭 간에는 세션정보가 공유되기 때문에, 각각의 탭에서는 같은 세션정보를 사용할 수 있다.
- `HttpSession` 인터페이스를 구현한 객체를 사용한다.
- JSP에서는 `session` 내장 변수를 사용한다.
- 서블릿에서는 `HttpServletReques`t의 `getSession()`메소드를 이용하여 `session` 객체를 얻는다.
- 장바구니처럼 사용자별로 유지가 되어야 할 정보가 있을 때 사용한다.

### Application Scope

> 웹 어플리케이션이 시작되고 종료될 때까지 변수를 사용할 수 있다.
- `ServletContext` 인터페이스를 구현한 객체를 사용한다.
- jsp에서는 `application` 내장 객체를, 서블릿의 경우는 `getServletContext()`메소드를 이용하여 `application`객체를 이용한다.
- 웹 어플리케이션 하나당 하나의 `application`객체가 사용된다.
- 모든 클라이언트가 공통으로 사용해야 할 값들이 있을 때 사용한다.

- - 공통적으로 값을 저장할 때는 해당 객체의 `setAttribute()`메소드를, 읽어 들일 때는 해당 객체의 `getAttribute()`메소드를 사용한다.

<br>

📢 실습
===

- ApplicationScope01 서블릿에서는 Application scope으로 `value`에 1값을 저장한다.
- ApplicationScope02는 Application scope로 저장된 `value`의 값에 2를 더한 후 그 결과를 출력한다.
- Application scope 웹 어플리케이션을 사용하는 모든 브라우저에서 같은 값을 사용하게 한다. 테스트를 위해서 크롬과 인터넷 익스플로어를 사용해 결과를 확인한다.
<details>
<summary>코드 본문</summary>
<div markdown="1">

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
<%
    try{
        int value = (int)application.getAttribute("value");
        value = value + 2;
        application.setAttribute("value", value);
%>
        <h1><%=value %></h1>
<%        
    }catch(NullPointerException ex){
%>
        <h1>설정된 값이 없습니다.</h1>
<%        
    }
%>

</body>
</html>
```

</div>
</details>
