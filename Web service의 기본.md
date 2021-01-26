### 목차
1. [Web Service의 기본 동작 과정](#web-service의-기본-동작-과정)
2. [HTML form](#html-form)
3. [Servlet](#servlet)
4. [JSP](#jsp)
5. [Servlet과 JSP의 차이](#servlet과-jsp의-차이)
6. [관련 모델](#관련-모델)

## Web Service의 기본 동작 과정

```HTML form -> Servlet -> HTML page```

#### 예시
1. 사용자가 웹 페이지 form(HTML form)을 통해 자신의 정보를 입력한다. **(Input)**
2. Servlet의 doGet() 또는 doPost() 메서드는 입력한 form data에 맞게 DB 또는 다른 소스에서 관련된 정보를 검색한다.
3. 이 정보를 이용하여 사용자의 요청에 맞는 적절한 동적 컨텐츠(HTML page)를 만들어 제공한다. **(Output)**

## HTML form
input elements(ex: text box)가 포함된 웹 페이지의 한 부분(section)
  - 사용자가 입력한 정보(form contents)를 웹 서버로 전송하기 위한 submit element(ex: button)가 존재
  - action에는 form을 처리하는 서버 쪽 URL을 명시

### 클라이언트(browser)가 요청하는 URL 정보
- 요청을 보낼 서버의 IP 주소 : Port 번호 / App 이름 / 달라고 요청하는 HTML
  - (ex) localhost:3000/HandlingServlet/loginForm.html
- IP 주소
  - 요청을 보낼 서버의 위치를 의미
  - browser과 WAS(Tomcat)가 같은 PC에 있으면 "IP 주소 = localhost"
- Port 번호
  - (쉽게 말했을 때) 해당 위치 안의 특정 사람을 의미
  - 단말에 접속하기 위한 "논리적인 접속 위치"
    - 인터넷을 사용할 때 클라이언트는 서버에서 지정한 포트로 접속
  - 우리가 직접 만드는 프로그램은 보통 1024번 이후의 포트를 사용!
- HTML 이름
  - 과정
    1. HTML 이름에 해당하는 HTML 문서를 받아온다.
    2. browser는 받아온 HTML 문서 안의 html 태그들을 기계어로 번역(parsing)한다.
    3. 마지막으로 이 내용을 browser에서 rendering한다.

### loginForm.html 예시
```html
<form name="loginForm" method="post" action="loginServlet">
  Username: <input type="text" name="username"/> <br/>
  Password: <input type="password" name="password"/> <br/>
  <input type="submit" value="Login" />
</form>
```
- method="post"
  - 원하는 동작에 따라 HTTP 메서드를 사용
  - method="get"도 존재
    - URL에서 전달할 때 숨겨야 될 정보가 있다면 post, 아니라면 get을 사용
- action="loginServlet"
  - URL of the servlet
  - 해당 URL로 request가 감. 즉, WAS에서의 어떤 Servlet인가를 지정하는 것!
- type="submit"
  - 버튼을 누르면 사용자가 입력한 인자들이 action에서 지정한 Servlet으로 넘어감

### form tag 속성
| 이름 | 역할 |
|:---:|---|
| action | form을 전송할 서버 쪽 스크립트 파일 지정 |
| name | form을 식별하기 위한 이름 지정 |
| accept-charset | form 전송에 사용할 문자 인코딩을 지정 |
| target | action에서 지정한 스크립트 파일을 현재 창이 아닌 다른 위치에서 열리도록 지정 |
| method | form을 서버에 전송하는 방식으로, HTTP 메서드 지정(get 또는 post) |
| enctype | 넘기는 content의 type 지정(주로 파일을 넘길 때 사용. type은 multipart/form-data로 지정해서 사용) |

### form method
form을 서버에 전송하는 방식으로, 두 가지 HTTP 메서드를 지정할 수 있음
1. GET method
    - 사용자가 입력한 내용(form data)이 URL 뒤에 텍스트 문자열로 추가됨(쿼리 스트링)
      - 크기 제한 : 1024 characters
      - data는 ?를 기준으로 action URL과 분리됨
      - (ex) http://localhost:3000/addFriend?search_name=이아현
    - 브라우저에 웹 서버로 정보를 전달하는 기본 메서드(Default Method)
      - HTTP 메서드를 지정하지 않으면 GET method를 호출함
    - 서버에 전달하는 data에 암호와 같은 민감한 정보가 있는 경우는 GET method를 사용하지 않음
      - URL은 모두에게 노출되는 정보이기 때문에 보안상 적절하지 않음
      - 이런 경우에는 POST method를 사용
    - GET method의 사용
      - Query-type actions : DB에 영향을 주지 않는 단순 읽기 위주(read operation)의 작업
      - Idempotemt actions : 몇 번이고 같은 연산을 반복해도 같은 값이 나오는 작업
2. POST method
    - 사용자가 입력한 내용(form data)을 별도의 메시지로 보냄
    - Request Body에 data를 추가
      - URL에 직접적으로 data가 노출되지 않기 때문에 GET method보다 보안상으로 더 안전
    - POST method의 사용
      - actions with side-effects : DB에 영향을 주는 작업


## Servlet

### Servlet의 개념
- 웹 기반의 요청에 대한 동적인 처리가 가능한 하나의 클래스이자 Server side에서 돌아가는 Java Program
- Java 코드 안에 HTML 코드
- 웹 개발을 위해 만든 표준
- 개발자가 작성해야 하는 부분

### Servlet Program의 기본적인 동작 과정
1. Web Server는 HTTP request를 Web Container(Servlet Container)에게 위임한다.
    - web.xml 설정에서 어떤 URL과 매핑되어 있는지 확인
    - 클라이언트(browser)의 요청 URL을 보고 적절한 Servlet 실행
2. Web Container는 service() 메서드를 호출하기 전에 Servlet 객체를 메모리에 올린다.
    - Web Container는 적절한 Servlet 파일을 컴파일(.class 파일 생성)한다.
    - .class 파일을 메모리에 올려 Servlet 객체를 만든다.
    - 메모리에 로드될 때 Servlet 객체를 초기화하는 init() 메서드가 실행된다.
3. Web Container는 Request가 올 때마다 thread를 생성하여 처리한다.
    - 각 thread는 Servlet의 단일 객체에 대한 service() 메서드를 실행한다.

### Servlet Program에서 Thread의 역할
- Thread란? 운영체제로부터 시스템 자원을 할당받는 작업의 단위
- Servlet Program에서 thread가 수행할 메서드가 지정/할당되면
  - thread는 생성 후 즉시 해당 메서드만 열심히 수행함
  - 해당 메서드가 return하면 thread는 종료되고 제거됨
  - 즉, 실제로 thread의 역할은 Servlet의 doGet() 또는 doPost()를 호출하는 것!
- Web Container(Servlet Container)는 thread의 생성과 제거를 담당
  - but, thread의 생성과 제거의 반복은 큰 오버헤드를 만듦
  - 이를 위해 Tomcat(WAS)은 "Thread Pool"(미리 thread를 만들어 놓음)이라는 적절한 메커니즘을 사용해 오버헤드를 줄임
- 즉, WAS는 Servlet의 life cycle을 담당
  - 웹 브라우저 클라이언트의 요청이 들어왔을 때 Servlet 객체 생성은 WAS가 알아서 처리함
  - WAS 위에서 Servlet이 돌아다니는데, 개발자는 이 Servlet을 만들어야 함

### Servlet life cycle
![Servlet life cycle](https://user-images.githubusercontent.com/57928612/105809024-42a59300-5fec-11eb-8a6c-8f8a1bd0c71d.png)
- 클라이언트의 요청이 들어오면 WAS는 해당 요청에 맞는 Servlet이 메모리에 있는지 확인
  - 만약 메모리에 없다면, 해당 Servlet class를 메모리에 올린 후(Servlet 객체 생성) init 메서드 실행한 후 service 메서드 실행
  - 메모리에 있다면 바로 service 메서드 실행

- **init()**
  - 한 번만 수행됨
  - 클라이언트(browser)의 요청에 따라 적절한 Servlet이 생성되고 이 Servlet이 메모리에 로드될 때 init() 메서드가 호출됨
  - 역할 : Servlet 객체를 초기화
- **service(request, response)**
  - 응답에 대한 모든 내용은 service() 메서드에 구현해야 함
  - Servlet이 수신한 모든 request에 대해 service() 메서드가 호출됨
    - HttpServlet을 상속받은 Servlet 클래스(이하 하위 클래스)에서 service() 메서드를 오버라이드하지 않았다면, 그 부모인 HttpServlet의 service()가 호출됨
    - HttpServlet의 service() 메서드는 템플릿 메서드 패턴으로 구현되어 있음
    - service() 메서드는 request의 type(HTTP method: GET, POST, PUT, DELETE 등)에 따라 적절한 메서드(doGet, doPost, doPut, doDelete 등)를 호출함
    - 즉, 하위 클래스에서 doGet, doPost 등의 메서드를 오버라이드해두면 HttpServlet의 service() 메서드가 요청에 맞는 메서드(하위 클래스에서 오버라이드한 메서드)를 알아서 호출할 수 있게 되는 것
    - 메서드가 return하면 해당 thread는 제거됨
- **destroy()**
  - 한 번만 수행됨
  - Web Application이 갱신되거나 WAS가 종료될 때 호출됨
  - 역할 : Servlet 객체를 메모리에서 제거

### Servlet의 동작 과정
1. WAS는 사용자 요청에 맞는 적절한 Servlet 파일을 컴파일(.class 파일 생성)한다.
2. .class 파일을 메모리에 올려 Servlet 객체를 만든다.
3. 메모리에 로드될 때 Servlet 객체를 초기화하는 init() 메서드가 실행된다.
4. WAS는 Request가 올 때마다 thread를 생성하여 처리한다.
5. 각 thread는 Servlet의 단일 객체에 대한 service() 메서드를 실행한다.
6. service() 메서드는 요청에 맞는 적절한 메서드(doGet, doPost 등)를 호출한다.

## JSP

### JSP의 개념
- Java 언어를 기반으로 하는 Server Side 스크립트 언어
- HTML 코드에 Java 코드를 넣어 동적인 웹 페이지를 생성하는 웹 어플리케이션 도구
  - JSP를 통해 정적인 HTML과 동적으로 생성된 contents(HTTP 요청 파라미터)를 혼합하여 사용할 수 있음
  - 즉, 사용자가 입력한 contents에 맞게 동적인 웹 페이지 생성
- Servlet 기술의 확장
  - Servlet을 보완한 스크립트 방식 표준
  - Servlet의 모든 기능 + 추가 기능
  
### JSP의 동작 과정
- JSP 문서는 백그라운드에서 Servlet으로 자동 변환됨
1. JSP가 실행되면 WAS는 내부적으로 JSP 파일을 Java Servlet(.java)로 변환함
2. WAS는 이 변환한 Servlet을 동작하여 필요한 기능을 수행
    - [Servlet의 동작](#servlet의-동작-과정)
3. 수행 완료 후 생성된 데이터를 웹 페이지와 함께 클라이언트로 응답

### JSP의 특징
- 스크립트 언어이기 때문에 자바 기능을 그대로 사용할 수 있음
- Tomcat(WAS)이 이미 만들어놓은 객체([predefined values 또는 Implicit Object](#predefined-values또는-implicit-object))를 사용함
  - (ex) request, response, session 등
- 사용자 정의 태그(custom tags)를 사용하여 보다 효율적으로 웹 사이트 구성 가능
  - JSTL(JSP Standard Tag Library, JSP 표준 태그 라이브러리) 사용
- HTML 코드 안에 Java 코드가 있기 때문에 HTML 코드를 작성하기 쉬움
- Servlet과 다르게 JSP는 수정된 경우 재배포할 필요 없이 Tomcat(WAS)이 알아서 처리해줌

#### Predefined values(또는 Implicit Object)
- 미리 정의된 객체로, WAS가 제공하는 객체를 의미
  - request : the HttpServletRequest Object
  - response: the HttpServletResponse Object
  - session : the HttpSession Object
  - out : the PrintWriter Object
  - application : the ServletContext Object

## Servlet과 JSP의 차이

- Servlet
  - data processing(Controller)에 좋음
  - 즉, DB와의 통신, Business Logic 호출, 데이터를 읽고 확인하는 작업 등에 유용
  - Servlet이 수정된 경우 Java 코드를 컴파일(.class 파일 생성)한 후 동적인 페이지를 처리하기 때문에 전체 코드를 업데이트하고 다시 컴파일한 후 재배포하는 작업이 필요함(개발 생산성 저하)
- JSP
  - presentation(View)에 좋음
  - 즉, 요청 결과를 나타내는 HTML을 작성하는데 유용
  - JSP가 수정된 경우 재배포할 필요 없이 WAS가 알아서 처리(쉬운 배포)

## 관련 모델

### JSP만을 사용하는 모델
- JSP가 사용자의 요청을 받아 Java Bean(DTO, DAO)을 호출하여 적절한 동적인 페이지를 생성
- 동작 과정
  - JSP로 작성된 프로그램은 내부적으로 WAS에서 Servlet 파일로 변환
  - JSP 태그를 분해하고 추출하여 다시 순수한 HTML 웹 페이지로 변환
  - 클라이언트로 응답
- 특징
  - 개발 속도가 빠르고 배우기 쉬움
  - 프레젠테이션 로직(View)과 비즈니스 로직(Controller)이 혼재함
  - JSP 코드가 복잡해져 유지 보수가 어려워짐

### JSP와 Servlet을 모두 이용하는 모델(MVC Architecture)
- JSP와 Servlet을 모두 사용하여 프레젠테이션 로직(View)과 비즈니스 로직(Controller)을 분리
- View(보여지는 부분)는 HTML이 중심이 되는 JSP를 사용
- Controller(다른 자바 클래스에 데이터를 넘겨주는 부분)는 Java 코드가 중심이 되는 Servlet을 사용
- Model은 Java Beans로, DTO와 DAO를 통해 Mysql과 같은 Data Storage에 접근
