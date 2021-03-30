📧 HTTP (Hypertext Transfer Protocol)
===
HTTP는 서버와 클라이언트가 인터넷상에서 데이터를 주고받기 위한 프로토콜(protocol)
  
  <br>
  
### HTTP 작동방식
  > HTTP는 서버/클라이언트 모델을 따릅니다.

🙋🏻‍♂️ 장점
- 불특정 다수를 대상으로 하는 서비스에는 적합하다.
- 클라이언트와 서버가 계속 연결된 형태가 아니기 때문에 클라이언트와 서버 간의 최대 연결 수보다 훨씬 많은 요청과 응답을 처리할 수 있다.

🙅🏻‍♂️ 단점
- 연결을 끊어버리기 때문에, 클라이언트의 이전 상황을 알 수가 없다.
- 이러한 특징을 무상태(Stateless)라고 말한다.
- 이러한 특징 때문에 정보를 유지하기 위해서 `Cookie`와 같은 기술이 등장하게 되었다.

<br>

### URL (Uniform Resource Locator)
  > 인터넷 상의 자원의 위치, 특정 웹 서버의 특정 파일에 접근하기 위한 경로 혹은 주소

![image](https://cphinf.pstatic.net/mooc/20180119_25/1516354290022wUY3x_PNG/http_-_.png)

- 요청 메서드 : GET(요청 body가 없음), PUT, POST, PUSH, OPTIONS 등의 요청 방식이 온다.

<br>
<br>

🌎 웹 프론트엔드
===

### 역할
* 웹콘텐츠를 잘 보여주기 위해 구조를 만들어야 합니다.(신문,책등과 같이) - `HTML`
* 적절한 배치와 일관된 디자인 등을 제공해야 합니다.(보기 좋게) - `CSS`
* 사용자 요청을 잘 반영해야 합니다.(소통하듯이) - `Javascript`

### 백 엔드(Back-End)란?

`backend`는 정보를 처리하고 저장하며, 요청에 따라 정보를 내려주는 역할을 한다. 다른 말로 `Sever side`라고도 한다.

- Rendering engne : 구글, 사파리, 인터넷
- main flow
1. Html 코드를 DOM Tree로 구성
2. Render tree construction
3. Layout of the render tree
4. Painting the render tree

![image](https://cphinf.pstatic.net/mooc/20171231_32/1514692895834EoHUo_PNG/webkitflow.png)
* 브라우저에는 서버에서 받은 문서(HTML, CSS, Javascript)를 해석하고 실행하여 화면에 표현하기 위한 해석기(Parser)들을 가지고 있습니다.
* 브라우저마다 서로 다른 엔진을 포함하고 있습니다.

<br>

### 웹 코딩 구조
* site: www.jsbin.com
```html
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>저를소개해요</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/start.js"></script>
  </head>
  <body>
    <h1>안녕하세요</h1>
    <div>코드스쿼드 크롱이라고 합니다</div>
    <script src="js/library.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>
```
* javascript 파일과 css 파일의 위치가 중요하다. java 소스 코드의 위치가 브라우저의 렌더링을 방해할 수도 있음.

### 웹 서버란?

- 웹 서버는 소프트웨어(Software)를 보통 말하지만, 웹 서버 소프트웨어가 동작하는 컴퓨터를 말합니다.
- 웹 서버의 가장 중요한 기능은 클라이언트(Client)가 요청하는 HTML 문서나 각종 리소스(Resource)를 전달하는 것입니다.
- 웹 브라우저나 웹 크롤러가 요청하는 리소스는 컴퓨터에 저장된 정적(static)인 데이터이거나 동적인 결과가 될 수 있습니다.

### 클라이언트/서버 구조

  > 클라이언트(Client)는 서비스(Service)를 제공하는 서버(Server)에게 정보를 요청하여 응답 받은 결과를 사용합니다.

### DBMS (DataBase Management System)

  > 다수의 사용자가 데이터베이스 내의 데이터에 접근할 수 있도록 해주는 소프트웨어입니다.

### 미들웨어 (MiddleWare)

  > 비즈니스 로직을 클라이언트와 DBMS사이의 미들웨어 서버에서 동작하도록 함으로써 클라이언트는 입력과 출력만 담당하도록 합니다.
  > 

### WAS (Web Application Server)

  > 일종의 미들웨어로 웹 클라이언트(보통 웹 브라우저)의 요청 중 웹 애플리케이션이 동작하도록 지원하는 목적을 가집니다.




