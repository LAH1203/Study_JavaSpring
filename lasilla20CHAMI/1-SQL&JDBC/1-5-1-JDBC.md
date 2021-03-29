### JDK 환경 설정
  > 만약 환경 변수가 없다면 우린 콘솔 창에 자바를 실행할 때마다 `C:\Program Files\Java\jdk1.8.0_151` 폴더로 이동하거나 `C:\Program Files\Java\jdk1.8.0_151\java -version` 이렇게 위치를 지정해줘야 해서 불편하기 짝이 없다. 게다가 JDK를 사용하는 개발 플랫폼에 매번 java 파일이 설치된 위치를 일일이 적어줘야 한다. 

이때 환경 변수를 지정해두면, console에서는 java만 입력해도 path 환경변수 내 저장된 디렉토리들을 탐색하며 java 파일을 찾아 실행할 것이다. JDK를 요구하는 플랫폼(톰캣 등이 있다)은 우리가 따로 말 안해줘도 JAVA_HOME을 찾아가면 된다.

<br>

🗃 JDBC
===
### 프로그래밍 방법
1. import java.sql.*;
2. 드라이버를 로드 한다.
3. Connection 객체를 생성한다.
4. Statement 객체를 생성 및 질의 수행
5. SQL문에 결과물이 있다면 ResultSet 객체를 생성한다.
6. 모든 객체를 닫는다.

![image](https://www.boostcourse.org/viewer/image?src=https%3A%2F%2Fcphinf.pstatic.net%2Fmooc%2F20180201_49%2F1517475141729UGWfv_PNG%2F2_11_1_JDBC_.PNG)
