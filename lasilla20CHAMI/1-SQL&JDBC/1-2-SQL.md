
### Database 생성하기
``` mysql> create database DB이름;```

### Database 사용자 생성과 권한 주기
  > Database를 생성했다면, 해당 데이터베이스를 사용하는 계정을 생성해야 합니다. 또한, 해당 계정이 데이터베이스를 이용할 수 있는 권한을 줘야 합니다.
- db이름 뒤의 * 는 모든 권한.
- @’%’는 어떤 클라이언트에서든 접근 가능하다는 의미이고, @’localhost’는 해당 컴퓨터에서만 접근 가능하다는 의미입니다.
- flush privileges는 DBMS에게 적용을 하라는 의미입니다. 해당 명령을 반드시 실행해줘야 합니다.
```
grant all privileges on db이름.* to 계정이름@'%' identified by ＇암호’;
grant all privileges on db이름.* to 계정이름@'localhost' identified by ＇암호’;
flush privileges;
```

### MySQL 연결끊기
```mysql> QUIT / mysql> exit```
- Bye라고 나오면 연결끊기 성공

### MySQL 버전과 현재 날짜 구하기
``mysql> SELECT VERSION(), CURRENT_DATE;``

- 대소문자를 구별하지 않는다.
- ; (새미콜론)으로 문장의 끝을 구분한다.
- 입력하는 도중 취소하고 싶으면 ``\c``
- 존재하는 데이터 베이스 찾기 ``mysql> show databases;``
- 데이터베이스 사용 ``mysql> use databases;``

<br>
<br>




데이터를 저장하는 공간 Table
===
### Table의 구성 요소
- ``열(Column)`` : 테이블 상에서의 단일 종류의 데이터를 나타냄. 특정 데이터 타입 및 크기를 가지고 있습니다.
- ``행(Row)`` : Column들의 값의 조합. 레코드라고 불림. `기본키(PK)`에 의해 구분. 기본키는 중복을 허용하지 않으며 없어서는 안 됩니다.
- ``Field`` : Row와 Column의 교차점으로 Field는 데이터를 포함할 수 있고 없을 때는 `NULL` 값을 가지고 있습니다.
<br>

![image](https://user-images.githubusercontent.com/22065527/112100016-cf815d00-8be7-11eb-89b5-501a10348c94.png)
