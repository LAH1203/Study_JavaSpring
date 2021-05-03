JSTL (JSP Standara Tag Library)
==
*들어가기에 앞서…*
> 프론트 개발자가 JSP를 수정하는데, JSP 안에 자바코드와 HTML코드가 섞여 있다면 수정할 때 굉장히 어려움을 느끼게 될 가능성이 크다.

### JSTL이란?
JSTL(JSP Standard Tag Library)은 JSP 페이지에서 조건문 처리, 반복문 처리 등을 html `tag`형태로 작성할 수 있게 도와줍니다.
- 예시

![image](https://cphinf.pstatic.net/mooc/20180130_149/1517289583487Ac0YJ_PNG/2_6_2_jstl.PNG)

### JSTL을 사용하려면?
- [사이트](http://tomcat.apache.org/download-taglibs.cgi)에서 3가지 jar파일을 다운로드 한 후 WEB-INF/lib/ 폴더에 복사를 한다.

![image](https://cphinf.pstatic.net/mooc/20180130_248/1517289861733CmzUv_PNG/2_6_2_jstl_.PNG)

- JSTL이 제공하는 태그의 종류
![image](https://cphinf.pstatic.net/mooc/20180130_273/1517290494334HrB7S_PNG/2_6_2_jstl___.PNG)

<br>
<br>

- 중요 태그들
![image](https://user-images.githubusercontent.com/22065527/116867818-ae7d4480-ac48-11eb-8581-0e97950aa9a3.png)
![image](https://user-images.githubusercontent.com/22065527/116867909-c9e84f80-ac48-11eb-805c-d426bb88e63d.png)

### set, remove의 활용
: jstl01.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="value1" scope="request" value="kang"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

성 : ${value1} <br>

<c:remove var="value1" scope="request"/>

성 : ${value1 }
</body>
</html>
```
<br>
<br>

### 코어태그: 변수 지원 태그 - 프로퍼티, 맵의 처리

![image](https://cphinf.pstatic.net/mooc/20180226_103/1519633640114VKW2d_PNG/2.png)

### 코어 태그: 흐름제어 태그 - if

![image](https://cphinf.pstatic.net/mooc/20180226_83/1519633710402BlJ2W_PNG/3.png)

### 코어 태그: 흐름제어 태그 - choose

![image](https://user-images.githubusercontent.com/22065527/116869478-c73b2980-ac4b-11eb-8466-838513dbd095.png)

