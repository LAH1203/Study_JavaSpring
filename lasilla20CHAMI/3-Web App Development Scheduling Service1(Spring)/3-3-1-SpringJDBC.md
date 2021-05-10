Spring JDBC
==
> JDBC 프로그래밍을 보면 반복되는 개발 요소가 있습니다. 이러한 반복적인 요소는 개발자를 지루하게 만듭니다. 개발하기 지루한 JDBC의 모든 저수준 세부사항을 스프링 프레임워크가 처리해줍니다. 개발자는 필요한 부분만 개발하면 됩니다.
- 개발자가 해야 할 일은?

![image](https://cphinf.pstatic.net/mooc/20180205_176/1517797019977L6ygq_PNG/2_11_2_springJDBC.PNG)


### Spring JDBC 패키지

- org.springframework.jdbc.core
- - JdbcTemplate 및 관련 Helper 객체 제공
- org.springframework.jdbc.datasource
- - DataSource를 쉽게 접근하기 위한 유틸 클래스, 트랜젝션매니져 및 다양한 DataSource 구현을 제공
- org.springframework.jdbc.object
- - RDBMS 조회, 갱신, 저장등을 안전하고 재사용 가능한 객제 제공
- org.springframework.jdbc.support
- - jdbc.core 및 jdbc.object를 사용하는 JDBC 프레임워크를 지원

### JDBC Template
> org.springframework.jdbc.core에서 가장 중요한 클래스입니다.
1. 리소스 생성, 해지를 처리해서 연결을 닫는 것을 잊어 발생하는 문제 등을 피할 수 있도록 합니다.
2. 스테이먼트(Statement)의 생성과 실행을 처리합니다.
3. SQL 조회, 업데이트, 저장 프로시저 호출, ResultSet 반복호출 등을 실행합니다.
4. JDBC 예외가 발생할 경우 org.springframework.dao패키지에 정의되어 있는 일반적인 예외로 변환시킵니다.

<br>
<br>
<br>

🚩 실습 코드
==

1. 열의 수 구하기
```java
int rowCount = this.jdbcTemplate.queryForInt("select count(*) from t_actor");
```
2. 변수 바인딩 사용하기
```java
int countOfActorsNamedJoe = this.jdbcTemplate.queryForInt("select count(*) from t_actor where first_name = ?", "Joe");
```

3. String 값으로 결과 받기
```java
String lastName = this.jdbcTemplate.queryForObject("select last_name from t_actor where id = ?", new Object[]{1212L}, String.class); 
```

<details>
<summary>4. 한 건 조회하기</summary>
<div markdown="1">       

```java
Actor actor = this.jdbcTemplate.queryForObject(

  "select first_name, last_name from t_actor where id = ?",

  new Object[]{1212L},

  new RowMapper<Actor>() {

    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

      Actor actor = new Actor();

      actor.setFirstName(rs.getString("first_name"));

      actor.setLastName(rs.getString("last_name"));

      return actor;
    }
  });
```

</div>
</details>

<details>
<summary>5. 여러 건 조회하기</summary>
<div markdown="1">       

```java
List<Actor> actors = this.jdbcTemplate.query(

  "select first_name, last_name from t_actor",

  new RowMapper<Actor>() {

    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

      Actor actor = new Actor();

      actor.setFirstName(rs.getString("first_name"));

      actor.setLastName(rs.getString("last_name"));

      return actor;

    }

  });

```

</div>
</details>

6. 중복 코드 제거
```java
public List<Actor> findAllActors() {

  return this.jdbcTemplate.query( "select first_name, last_name from t_actor", new ActorMapper());

}

private static final class ActorMapper implements RowMapper<Actor> {

  public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

    Actor actor = new Actor();

    actor.setFirstName(rs.getString("first_name"));

    actor.setLastName(rs.getString("last_name"));

    return actor;
  }
}
```
7. INSERT 하기
```java
this.jdbcTemplate.update("insert into t_actor (first_name, last_name) values (?, ?)",  "Leonor", "Watling");
```
8. UPDATE 하기
```java
this.jdbcTemplate.update("update t_actor set = ? where id = ?",  "Banjo", 5276L);
```
9. DELETE 하기
```java
this.jdbcTemplate.update("delete from actor where id = ?", Long.valueOf(actorId));
```

### JdbcTemplate외의 접근방법

- **NamedParameterJdbcTemplate**

- - JdbcTemplate에서 JDBC statement 인자를 ?를 사용하는 대신 파라미터명을 사용하여 작성하는 것을 지원

- **SimpleJdbcTemplate**
- - JdbcTemplate과 NamedParameterJdbcTemplate 합쳐 놓은 템플릿 클래스
- - 이제 JdbcTemplate과 NamedParameterJdbcTemplate에 모든 기능을 제공하기 때문에 삭제 예정될 예정 (deprecated)

- **SimpleJdbcInsert**
- - 테이블에 쉽게 데이터 insert 기능을 제공

<br>
<br>
<br>

DTO
==
> DTO란 `Data Transfer Object`의 약자입니다. 계층간 데이터 교환을 위한 자바빈즈입니다.
- 여기서의 계층이란 컨트롤러 뷰, 비지니스 계층, 퍼시스턴스 계층을 의미합니다.
- 일반적으로 DTO는 로직을 가지고 있지 않고, 순수한 데이터 객체입니다.
- 필드와 getter, setter를 가진다. 추가적으로 *toString(), equals(), hashCode()* 등의 Object 메소드를 오버라이딩 할 수 있습니다.

- 예시)
```java
public class ActorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public Long getId() {
        return this.id;
    }
}
```

<br>
<br>

DAO
==

> DAO란 Data Access Object의 약자로 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 객체입니다. 보통 데이터베이스를 조작하는 기능을 전담하는 목적으로 만들어집니다.

### ConnectionPool 이란?
> DB연결은 비용이 많이 듭니다. 커넥션 풀은 미리 커넥션을 여러 개 맺어 둡니다. 커넥션이 필요하면 커넥션 풀에게 빌려서 사용한 후 반납합니다.

<br>

커넥션을 반납하지 않으면 어떻게 될까요?
![image](https://cphinf.pstatic.net/mooc/20180208_14/15180684447693OANG_JPEG/3_8_2_ConnectionPool.jpg)

### DataSource란?

> DataSource는 커넥션 풀을 관리하는 목적으로 사용되는 객체입니다. DataSource를 이용해 커넥션을 얻어오고 반납하는 등의 작업을 수행합니다.

### Spring JDBC를 이용한 DAO작성 실습

![image](https://cphinf.pstatic.net/mooc/20180208_103/1518068520531pRbvK_PNG/3_8_2_Spring_JDBC__DAO_.png)
