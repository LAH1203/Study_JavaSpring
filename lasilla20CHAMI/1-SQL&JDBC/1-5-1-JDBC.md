### JDK 환경 설정
  > 만약 환경 변수가 없다면 우린 콘솔 창에 자바를 실행할 때마다 `C:\Program Files\Java\jdk1` 폴더로 이동하거나 `C:\Program Files\Java\jdk1\java -version` 이렇게 위치를 지정해줘야 해서 불편하기 짝이 없다. 게다가 JDK를 사용하는 개발 플랫폼에 매번 java 파일이 설치된 위치를 일일이 적어줘야 한다. 

이때 환경 변수를 지정해두면, console에서는 java만 입력해도 path 환경변수 내 저장된 디렉토리들을 탐색하며 java 파일을 찾아 실행할 것이다. JDK를 요구하는 플랫폼(톰캣 등이 있다)은 우리가 따로 말 안해줘도 JAVA_HOME을 찾아가면 된다.

<br>
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

![image](https://cphinf.pstatic.net/mooc/20180201_49/1517475141729UGWfv_PNG/2_11_1_JDBC_.png)

### JDBC 사용 - 단계별 설명
1. `import java.sql.*;`
2. `Class.forName( "com.mysql.jdbc.Driver" );`
3. `Connection con =  DriverManager.getConnection ( 드라이버주소, ID, PWD );`
4.
- Statement 생성 : `Statement stmt = con.createStatement();`
- 질의수행:
```mySQL
stmt.execute(“query”);           //any SQL
stmt.executeQuery(“query”);     //SELECT
stmt.executeUpdate(“query”);   //INSERT, UPDATE, DELETE
```
5. ResultSet 으로 결과 받기
```mySQL
ResultSet rs =  stmt.executeQuery( "select no from user" );
while ( rs.next() ){
   해당하는 쿼리 받음;  }
```
6. 닫기 : `rs.close(); stmt.close(); con.close();`
- Try 와 Catch
  > java가 sql를 못 받아 올 수 도 있기 때문에 구문은 `try` 안에다 작성.
 ```Java
 try{
 conn = DBUtil.getConnection();
 ...
 }catch(Exception e{
 e.printStackTrace();
 }finally{ //무슨 일이 있어도 반드시 실행되는 코드
 DBUtil.close(conn,ps);
 }
```
