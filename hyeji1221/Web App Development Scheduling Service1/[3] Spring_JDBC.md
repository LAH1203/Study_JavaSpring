**Spring JDBC**

- JDBC 프로그래밍을 보면 반복되는 개발 요소가 있습니다.
- 이러한 반복적인 요소는 개발자를 지루하게 만듭니다.
- 개발하기 지루한 JDBC의 모든 저수준 세부사항을 스프링 프레임워크가 처리해줍니다.
- 개발자는 필요한 부분만 개발하면 됩니다.



**Spring JDBC - 개발자가 해야 할 일은?**

[![img](https://cphinf.pstatic.net/mooc/20180205_176/1517797019977L6ygq_PNG/2_11_2_springJDBC.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/58973?isDesc=false#)

- **spring JDBC**

**Spring JDBC 패키지**

**org.springframework.jdbc.core**

- JdbcTemplate 및 관련 Helper 객체 제공

**org.springframework.jdbc.datasource**

- DataSource를 쉽게 접근하기 위한 유틸 클래스, 트랜젝션매니져 및 다양한 DataSource 구현을 제공

**org.springframework.jdbc.object**

- RDBMS 조회, 갱신, 저장등을 안전하고 재사용 가능한 객제 제공

**org.springframework.jdbc.support**

- jdbc.core 및 jdbc.object를 사용하는 JDBC 프레임워크를 지원



**JDBC Template**

- org.springframework.jdbc.core에서 가장 중요한 클래스입니다.
- 리소스 생성, 해지를 처리해서 연결을 닫는 것을 잊어 발생하는 문제 등을 피할 수 있도록 합니다.
- 스테이먼트(Statement)의 생성과 실행을 처리합니다.
- SQL 조회, 업데이트, 저장 프로시저 호출, ResultSet 반복호출 등을 실행합니다.
- JDBC 예외가 발생할 경우 org.springframework.dao패키지에 정의되어 있는 일반적인 예외로 변환시킵니다.
