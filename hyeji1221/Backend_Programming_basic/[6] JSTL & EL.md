**표현 언어란?**

- 표현 언어(Expression Language)는 값을 표현하는 데 사용되는 스크립트 언어로서 JSP의 기본 문법을 보완하는 역할을 한다.



**표현 언어가 제공하는 기능**

- JSP의 스코프(scope)에 맞는 속성 사용
- 집합 객체에 대한 접근 방법 제공
- 수치 연산, 관계 연산, 논리 연산자 제공
- 자바 클래스 메소드 호출 기능 제공
- 표현언어만의 기본 객체 제공



**표현언어의 표현방법**

[![img](https://cphinf.pstatic.net/mooc/20180130_78/1517281954147RNccz_PNG/2_6_1__.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258517?isDesc=false#)

- **표현언어의 표현 방법**

**표현언어의 기본 객체**

[![img](https://cphinf.pstatic.net/mooc/20180130_153/1517281495386qOuqH_PNG/2_6_1__.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258517?isDesc=false#)

- **표현언어의 표현방법**

**표현 언어의 기본 객체 사용 예**

[![img](https://cphinf.pstatic.net/mooc/20180130_68/1517282068498tAlQM_PNG/2_6_1____.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258517?isDesc=false#)

- **표현언어의 기본객체 사용의 예**

**표현 언어의 데이터 타입**

- 불리언 타입 - true와 false
- 정수타입 - 0~9로 이루어진 정수 값 음수의 경우 '-'가 붙음
- 실수타입 - 0~9로 이루어져 있으며, 소수점('.')을 사용할 수 있고, 3.24e3과 같이 지수형으로 표현 가능하다.
- 문자열 타입 - 따옴표( ' 또는" )로 둘러싼 문자열. 만약 작은 따옴표(')를 사용해서 표현할 경우 값에 포함된 작은 따옴표는 \' 와 같이 \ 기호와 함께 사용해야 한다.
- \ 기호 자체는 \\ 로 표시한다.
- 널 타입 - null

 



[![img](https://cphinf.pstatic.net/mooc/20180130_27/1517286832617YwnDB_PNG/2_6_1_.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258517?isDesc=false#)

- **객체 접근 규칙**

**객체 접근 규칙**

- 표현 1이나 표현 2가 null이면 null을 반환한다.
- 표현1이 Map일 경우 표현2를 key로한 값을 반환한다.
- 표현1이 List나 배열이면 표현2가 정수일 경우 해당 정수 번째 index에 해당하는 값을 반환한다.
- 만약 정수가 아닐 경우에는 오류가 발생한다.
- 표현1이 객체일 경우는 표현2에 해당하는 getter메소드에 해당하는 메소드를 호출한 결과를 반환한다.

 

**표현 언어의 수치 연산자**

- \+ : 덧셈
- \- : 뺄셈
- \* : 곱셈
- / 또는 div : 나눗셈
- % 또는 mod : 나머지
- 숫자가 아닌 객체와 수치 연산자를 사용할 경우 객체를 숫자 값으로 변환 후 연산자를 수행 : ${"10"+1} → ${10+1}
- 숫자로 변환할 수 없는 객체와 수치 연산자를 함께 사용하면 에러를 발생 : ${"열"+1} → 에러
- 수치 연산자에서 사용되는 객체가 null이면 0으로 처리 : ${null + 1} → ${0+1}

 

**비교 연산자**

- == 또는 eq
- != 또는 ne
- < 또는 lt
- \> 또는 gt
- <= 또는 le
- \>= 또는 ge
- 문자열 비교: ${str == '값'} str.compareTo("값") == 0 과 동일

 

**논리 연산자**

- && 또는 and
- || 또는 or
- ! 또는 not

 

**empty 연산자, 비교선택 연산자**

[![img](https://cphinf.pstatic.net/mooc/20180130_17/1517287228502gEf9g_PNG/2_6_1_empty_%2C__.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258517?isDesc=false#)

- **연산자, 비교선택 연산자**

**연산자 우선순위**

1. [] .
2. ()
3. \- (단일) not ! empty
4. \* / div % mod
5. \+ -
6. < > <= >= lt gt le ge
7. == != eq ne
8. && and
9. || or
10. ? :

 

**표현 언어 비활성화 : JSP에 명시하기**

- <%@ page isELIgnored = "true" %>

[![img](https://cphinf.pstatic.net/mooc/20180130_20/15172876538779gHtO_PNG/2_6_1___.PNG?type=w760)
  ](https://www.boostcourse.org/web326/lecture/258517?isDesc=false#)

**JSTL이란?**

- JSTL(JSP Standard Tag Library)은 JSP 페이지에서 조건문 처리, 반복문 처리 등을 html tag형태로 작성할 수 있게 도와줍니다.

[![img](https://cphinf.pstatic.net/mooc/20180130_149/1517289583487Ac0YJ_PNG/2_6_2_jstl.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258521?isDesc=false#)

- **jstl이란**

**JSTL을 사용하려면?**

- http://tomcat.apache.org/download-taglibs.cgi
- 위의 사이트에서 3가지 jar파일을 다운로드 한 후 WEB-INF/lib/ 폴더에 복사를 한다.

[![img](https://cphinf.pstatic.net/mooc/20180130_248/1517289861733CmzUv_PNG/2_6_2_jstl_.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258521?isDesc=false#)

- **jstl을 사용하려면**

**JSTL이 제공하는 태그의 종류**

[![img](https://cphinf.pstatic.net/mooc/20180130_273/1517290494334HrB7S_PNG/2_6_2_jstl___.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258521?isDesc=false#)

- **jstl이 제공하는 태그의 종류**

**코어 태그**

[![img](https://cphinf.pstatic.net/mooc/20180130_226/1517290578353rKRbE_PNG/2_6_2_jstl_.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258521?isDesc=false#)

- **jstl 코어태그**

**코어 태그: 변수 지원 태그 - set, remove**



[![img](https://cphinf.pstatic.net/mooc/20180226_240/1519633482313pWfP8_PNG/1.png?type=w760)
  ](https://www.boostcourse.org/web326/lecture/258521?isDesc=false#)