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
- - [코드 링크]
