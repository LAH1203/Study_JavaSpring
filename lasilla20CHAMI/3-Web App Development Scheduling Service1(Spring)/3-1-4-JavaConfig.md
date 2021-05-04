JAVA Config
==
### Java Config란?
> 말그대로 자바 클래스 파일을 설정 파일로 사용을 하겠다는 것입니다. xml설정과 비교해서 Java Config를 사용하는 이유는, 클래스의 경우 이클립스나 인텔리J와 같은 IDE에서 오타 등을 발견하기 쉽고, 자동완성등을 지원하기 때문에 편리하기 때문입니다.

- 스프링에서는 Java Config로 사용하는 클래스에는 @Configuration이라는 어노테이션을 붙여서 표시를 합니다. 이에 대해서 이번시간엔 알아보도록 하겠습니다.

### Java config를 이용한 설정을 위한 어노테이션
- @Configuration
- - 스프링 설정 클래스를 선언하는 어노테이션
- @Bean
- - bean을 정의하는 어노테이션
- @ComponentScan
- - @Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록
- @Component
- - 컴포넌트 스캔의 대상이 되는 애노테이션 중 하나로써 주로 유틸, 기타 지원 클래스에 붙이는 어노테이션
- @Autowired
- - 주입 대상이되는 bean을 컨테이너에 찾아 주입하는 어노테이션

### Java Config를 이용해 설정하기
> @Configuration 은 스프링 설정 클래스라는 의미를 가집니다. JavaConfig로 설정을 할 클래스 위에는 @Configuration가 붙어 있어야 합니다.

⇒ [ApplicationConfig.java](https://github.com/LAH1203/Study_JavaSpring/blob/main/lasilla20CHAMI/3-Web%20App%20Development%20Scheduling%20Service1(Spring)/3-Code/ApplicationConfig.java)

`ApplicationContext`중에서 `AnnotationConfigApplicationContext`는 JavaConfig 클래스를 읽어들여 IoC와 DI를 적용하게 됩니다.
이때 설정파일 중에 @Bean이 붙어 있는 메소드들을 `AnnotationConfigApplicationContext`는 자동으로 실행하여 그 결과로 리턴하는 객체들을 기본적으로 싱글턴으로 관리를 하게 됩니다.

⇒[ApplicationContextExam03.java](https://github.com/LAH1203/Study_JavaSpring/blob/main/lasilla20CHAMI/3-Web%20App%20Development%20Scheduling%20Service1(Spring)/3-Code/ApplicationContextExam03.java)

- ApplicationConfig2.java
```java
package kr.or.connect.diexam01;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("kr.or.connect.diexam01")
public class ApplicationConfig2 {
}
```

: 기존 JavaConfig에서 빈을 생성하는 메소드를 모두 제거했습니다.
단, @Configuration아래에 @ComponentScan이라는 어노테이션을 추가했습니다.
<br>

@ComponentScan어노테이션은 파라미터로 들어온 패키지 이하에서 @Controller, @Service, @Repository, @Component 어노테이션이 붙어 있는 클래스를 찾아 메모리에 몽땅 올려줍니다.
<br>

기존의 Car클래스와 Engine클래스 위에 @Component를 붙이도록 하겠습니다.

- PROJECT난이도   심화
웹 백엔드
임시 이미지
강경미

http://www.boostcourse.org/web326/lecture/58972/
좋아요 807 수강생 5786
공지게시판
수강생 토론 게시판
오리엔테이션
강좌 전체목록보기
1. SQL & JDBC 프로그래밍
강좌 전체목록보기
프로젝트A. 명함 관리 프로그램
강좌 전체목록보기
2. 웹 백엔드 프로그래밍 기초
강좌 전체목록보기
프로젝트B. 방명록 만들기
강좌 전체목록보기
3. 웹 앱 개발 예약 서비스 1/4
강좌 전체목록보기
1. Spring Core
1) Spring이란?
2) Spring IoC/DI 컨테이너
3) xml파일을 이용한 설정-1
3) xml파일을 이용한 설정-2
4) Java Config를 이용한 설정
2. Spring Test
1) Test 개요
2) JUnit
3) 스프링 테스트 애노테이션 사용하기
4) 로직 단위테스트 구현하기
3. Spring JDBC
1) Spring JDBC 소개
2) Spring JDBC 실습-1
2) Spring JDBC 실습-2
2) Spring JDBC 실습-3
2) Spring JDBC 실습-4
2) Spring JDBC 실습-5
4. 웹 앱 개발 예약 서비스 2/4
강좌 전체목록보기
프로젝트C. 예약 : 메인
강좌 전체목록보기
5. 웹 앱 개발 예약 서비스 3/4
강좌 전체목록보기
프로젝트D. 예약 : 로그인
강좌 전체목록보기
6. 웹 앱 개발 예약 서비스 4/4
강좌 전체목록보기
프로젝트E. 예약 : 한줄평
강좌 전체목록보기
코스를 마치며
강좌 전체목록보기
4) Java Config를 이용한 설정
들어가기 전에

이번 시간엔 Java Config와 어노테이션을 이용해 스프링에서 사용하는 빈을 정의하고 DI하는 방법에 대해 알아보도록 하겠습니다.

 

 

학습 목표

JavaConfig형태의 설정파일의 내용을 이해할 수 있습니다.
@ComponentScan, @Component, @Autowired 어노테이션의 쓰임새에 대해 이해합니다.
 

 

핵심 개념

AnnotationConfigApplicationContext
@Configuration
@ComponentScan
@Component
@Autowired
 

 

학습하기

우리는 앞에서 xml을 이용한 설정에 대해 살펴보았습니다. 이번 시간엔 xml 설정을 대체할 수 있는 Java Config에 대해 배워보도록 하겠습니다. Java Config란 말그대로 자바 클래스 파일을 설정 파일로 사용을 하겠다는 것입니다. xml설정과 비교해서 Java Config를 사용하는 이유는, 클래스의 경우 이클립스나 인텔리J와 같은 IDE에서 오타 등을 발견하기 쉽고, 자동완성등을 지원하기 때문에 편리하기 때문입니다.



스프링에서는 Java Config로 사용하는 클래스에는 @Configuration이라는 어노테이션을 붙여서 표시를 합니다. 이에 대해서 이번시간엔 알아보도록 하겠습니다.




재생하기
00:0016:10
동영상 썸네일 이미지
스크립트 
Java Config를 이용한 설정
영상 우측 하단에 자막 스크립트 ON 설정을 한 후 강의를 시청하시면 학습에 도움이 됩니다.
Java config를 이용한 설정을 위한 어노테이션

@Configuration

스프링 설정 클래스를 선언하는 어노테이션
@Bean

bean을 정의하는 어노테이션
@ComponentScan

@Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록
@Component

컴포넌트 스캔의 대상이 되는 애노테이션 중 하나로써 주로 유틸, 기타 지원 클래스에 붙이는 어노테이션
@Autowired

주입 대상이되는 bean을 컨테이너에 찾아 주입하는 어노테이션
Java Config를 이용해 설정하기

ApplicationConfig.java

package kr.or.connect.diexam01;
import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
@Configuration 은 스프링 설정 클래스라는 의미를 가집니다.

JavaConfig로 설정을 할 클래스 위에는 @Configuration가 붙어 있어야 합니다.

ApplicationContext중에서 AnnotationConfigApplicationContext는 JavaConfig클래스를 읽어들여 IoC와 DI를 적용하게 됩니다.

이때 설정파일 중에 @Bean이 붙어 있는 메소드들을 AnnotationConfigApplicationContext는 자동으로 실행하여 그 결과로 리턴하는 객체들을 기본적으로 싱글턴으로 관리를 하게 됩니다.



ApplicationContextExam03.java

package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		   
		Car car = (Car)ac.getBean("car");
		car.run();
		
	}
}
파라미터로 요청하는 class 타입으로 지정 가능합니다.

Car car = ac.getBean(Car.class);



ApplicationConfig2.java

package kr.or.connect.diexam01;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("kr.or.connect.diexam01")
public class ApplicationConfig2 {
}
기존 JavaConfig에서 빈을 생성하는 메소드를 모두 제거했습니다.

단, @Configuration아래에 @ComponentScan이라는 어노테이션을 추가했습니다.

@ComponentScan어노테이션은 파라미터로 들어온 패키지 이하에서 @Controller, @Service, @Repository, @Component 어노테이션이 붙어 있는 클래스를 찾아 메모리에 몽땅 올려줍니다.

기존의 Car클래스와 Engine클래스 위에 @Component를 붙이도록 하겠습니다.

 

Engine.java

package kr.or.connect.diexam01;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	public Engine() {
		System.out.println("Engine 생성자");
	}
	
	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}
}


Car.java

package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine v8;
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
}
수정된 JavaConfig를 읽어들이여 실행하는 클래스를 보도록 하겠습니다.
<br>

- ApplicationContextExam04.java
```java
package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam04 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		   
		Car car = ac.getBean(Car.class);
		car.run();
		
	}
}
```
Spring에서 사용하기에 알맞게 *@Controller, @Service, @Repository, @Component* 어노테이션이 붙어 있는 객체들은 `ComponentScan`을 이용해서 읽어들여 메모리에 올리고 DI를 주입하도록 하고, 이러한 어노테이션이 붙어 있지 않은 객체는 *@Bean*어노테이션을 이용하여 직접 생성해주는 방식으로 클래스들을 관리하면 편리합니다.


