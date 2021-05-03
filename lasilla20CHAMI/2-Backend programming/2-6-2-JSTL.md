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

### 1. 코어태그: 변수 지원 태그 - 프로퍼티, 맵의 처리

![image](https://cphinf.pstatic.net/mooc/20180226_103/1519633640114VKW2d_PNG/2.png)

### 2. 코어 태그: 흐름제어 태그 - if

![image](https://cphinf.pstatic.net/mooc/20180226_83/1519633710402BlJ2W_PNG/3.png)

### 3. 코어 태그: 흐름제어 태그 - choose

![image](https://user-images.githubusercontent.com/22065527/116869478-c73b2980-ac4b-11eb-8466-838513dbd095.png)

### 4. 코어 태그: 흐름제어 태그 - forEach

![image](https://cphinf.pstatic.net/mooc/20180130_218/1517292735244tmWgM_PNG/2_6_2__forEach.PNG)

### 5. 코어 태그: 흐름제어태그 - import

![image](https://cphinf.pstatic.net/mooc/20180130_93/1517293018908uGgzT_PNG/2_6_2__import.PNG)

### import의 활용
<details>
<summary>jstlValue.jsp</summary>
<div markdown="1">       


```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Kang kyungmi
```
</div>
</details>

- jstl05.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.*" %>
<c:import url="http://localhost:8080/webapp/jstlValue.jsp" var="urlValue" scope="request"></c:import>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
읽어들인 값 : ${urlValue}
</body>
</html>
```

### 6. 코어 태그: 흐름제어태그 - redirect

![image](https://cphinf.pstatic.net/mooc/20180130_170/1517293246119dFJ4F_PNG/2_6_2__redirect.PNG)

- redirect의 활용
<details>
<summary>jtl06.jsp</summary>
<div markdown="1">
    
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:redirect url="jstlRedirectPage.jsp"></c:redirect>
```
</div>
</details>

<details>
<summary>jstlRedirectPage.jsp</summary>
<div markdown="1">       

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> redirect된 화면입니다.</h1>
</body>
</html>
```
</div>
</details>

### 7. 코어 태그: 기타태그 - out
![image](https://cphinf.pstatic.net/mooc/20180130_55/1517293404340WP4J3_PNG/2_6_2__out.PNG)

