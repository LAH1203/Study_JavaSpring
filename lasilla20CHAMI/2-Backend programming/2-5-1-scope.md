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
