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
* 웹콘텐츠를 잘 보여주기 위해 구조를 만들어야 합니다.(신문,책등과 같이) - HTML
* 적절한 배치와 일관된 디자인 등을 제공해야 합니다.(보기 좋게) - CSS
* 사용자 요청을 잘 반영해야 합니다.(소통하듯이) - Javascript

### 백 엔드(Back-End)란?

`backend`는 정보를 처리하고 저장하며, 요청에 따라 정보를 내려주는 역할을 한다. 다른 말로 `Sever side`라고도 한다.

- Rendering engne : 구글, 사파리, 인터넷
- main flow
1. Html 코드를 DOM Tree로 구성
2. Render tree construction
3. Layout of the render tree
4. Painting the render tree



