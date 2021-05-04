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

⇒ [ApplicationConfig.java]()

`ApplicationContext`중에서 `AnnotationConfigApplicationContext`는 JavaConfig 클래스를 읽어들여 IoC와 DI를 적용하게 됩니다.
이때 설정파일 중에 @Bean이 붙어 있는 메소드들을 `AnnotationConfigApplicationContext`는 자동으로 실행하여 그 결과로 리턴하는 객체들을 기본적으로 싱글턴으로 관리를 하게 됩니다.

⇒[ApplicationContextExam03.java]()

- ApplicationConfig2.java
