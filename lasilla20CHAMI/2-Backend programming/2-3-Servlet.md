### 자바 웹 어플리케이션(Java Web Application)
* 폴더 구조

![image](https://cphinf.pstatic.net/mooc/20180124_133/15167752967943AqfC_PNG/1_5_1_____.png)

### 서블릿이란?
  > 자바 웹 어플리케이션의 구성요소 중 동적인 처리를 하는 프로그램의 역할입니다.
* 서블릿을 정의해보면 서블릿(servlet)은 WAS에 동작하는 JAVA 클래스입니다. 
* 서블릿은 HttpServlet 클래스를 상속받아야 합니다.
* 서블릿과 JSP로부터 최상의 결과를 얻으려면, 웹 페이지를 개발할 때 이 두 가지(JSP, 서블릿)를 조화롭게 사용해야 합니다.
* 예를 들어, 웹 페이지를 구성하는 화면(HTML)은 JSP로 표현하고, 복잡한 프로그래밍은 서블릿으로 구현합니다.

### 버전에 따른 Servlet 작성 방법

1. Servlet 3.0 spec 이상에서 사용하는 방법
- web.xml 파일을 사용하지 않습니다.
- 자바 어노테이션(annotation)을 사용합니다.
- 앞에서 실습했던 first web에서 사용합니다.

2. Servlet 3.0 spec미만에서 사용하는 방법
- servlet을 등록할 때 web.xml 파일에 등록합니다.

<br>

📢 실습
===
### 서블렛 3.0 spec 이상에서 사용하는 방법
- new project → Dynamic web programming
- Servlet 3.1 spec으로 exam31이라는 프로젝트를 생성
- 1~10 출력하는 `TenServlet`을 작성
- - [코드 링크](https://github.com/LAH1203/Study_JavaSpring/blob/main/lasilla20CHAMI/2-Backend%20programming/2-Code/TenServlet.java)

### 서블렛 3.0 spec 미만에서 사용하는 방법
- 1~10까지 출력하도록 하는 `TenServlet`
- - [코드 링크](https://github.com/LAH1203/Study_JavaSpring/blob/main/lasilla20CHAMI/2-Backend%20programming/2-Code/Web.xml)

### LifecycleServlet
> HttpServlet의 3가지 메소드를 오버라이딩
* init()
* service(request, response)
* destroy()

<br>

> WAS는 서블릿 요청을 받으면 해당 서블릿이 메모리에 있는지 확인합니다.

![image](https://user-images.githubusercontent.com/22065527/113566649-1475ac80-9648-11eb-980a-44de2b9fce93.png)
- 요청이 들어왔을 때 응답해야하는 모든 메소드는 `service()` 안에 들어가면 좋다.
- `was`가 종료되거나, 웹 어플리케이션이 새롭게 갱신될 경우 `destroy()` 메소드가 실행됩니다.

```java
 if (메모리에 없음) {
 - 해당 서블릿 클래스를 메모리에 올림
 - init() 메소드를 실행
}
 - service()메소드를 실행
```

### service(request, response) 메소드
> HttpServlet의 service메소드는 템플릿 메소드 패턴으로 구현합니다.

- 클라이언트의 요청이 `GET`일 경우에는 자신이 가지고 있는 doGet(request, response)메소드를 호출
- 클라이언트의 요청이 `Post`일 경우에는 자신이 가지고 있는 doPost(request, response)를 호출

- 해당 해당 서블릿에 URL 주소를 직접 입력하거나 링크를 클릭하는 것은, GET 방식으로 서버에게 요청을 보내는 것.

