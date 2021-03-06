Spring IoC/DI 컨테이너
==
<br>

### 컨테이너(Container)

> 컨테이너는 인스턴스의 생명주기를 관리하며, 생성된 인스턴스에게 추가적인 기능을 제공합니다.
> 예를 들어, Servlet을 실행해주는 WAS는 Servlet 컨테이너를 가지고 있다고 말합니다.

- WAS는 웹 브라우저로부터 서블릿 URL에 해당하는 요청을 받으면, 서블릿을 메모리에 올린 후 실행합니다.
- 개발자가 서블릿 클래스를 작성했지만, 실제로 메모리에 올리고 실행하는 것은 WAS가 가지고 있는 Servlet 컨테이너입니다.
- Servlet컨테이너는 동일한 서블릿에 해당하는 요청을 받으면, 또 메모리에 올리지 않고 기존에 메모리에 올라간 서블릿을 실행하여 그 결과를 웹 브라우저에게 전달합니다.
- 컨테이너는 보통 인스턴스의 생명주기를 관리하며, 생성된 인스턴스들에게 추가적인 기능을 제공하는 것을 말합니다

### IoC(Inversion of Control) 
> 컨테이너가 코드 대신 오브젝트의 제어권을 갖고 있어 IoC(제어의 역전)이라 합니다.
> 예를 들어, 서블릿 클래스는 개발자가 만들지만, 그 서블릿의 메소드를 알맞게 호출하는 것은 WAS입니다.
- 이렇게 개발자가 만든 어떤 클래스나 메소드를 다른 프로그램이 대신 실행해주는 것을 제어의 역전이라고 합니다.

### DI(Dependency Injection)
> DI는 의존성 주입이란 뜻을 가지고 있다.
- 클래스 사이의 의존 관계를 빈(Bean) 설정 정보를 바탕으로 컨테이너가 자동으로 연결해주는 것을 말합니다.

- DI가 적용 안된 예
- - 개발자가 직접 인스턴스를 생성합니다.
```jdc
class 엔진 {

}

class 자동차 {
     엔진 v5 = new 엔진();
}
```

![image](https://cphinf.pstatic.net/mooc/20181218_284/1545136782491NSgAa_JPEG/3.7.2-1.jpg)

- Spring에서 DI가 적용된 예
- - 엔진 type의 v5변수에 아직 인스턴스가 할당되지 않았습니다.
- - 컨테이너가 v5변수에 인스턴스를 할당해주게 됩니다.

```jdc
@Component
class 엔진 {

}

@Component
class 자동차 {
     @Autowired
     엔진 v5;
}
```
![image](https://cphinf.pstatic.net/mooc/20181218_190/1545137156742y8WiS_JPEG/3.7.2-2.jpg)

### Spring에서 제공하는 IoC/DI 컨테이너

- `BeanFactory` : IoC/DI에 대한 기본 기능을 가지고 있습니다.
- `ApplicationContext` : BeanFactory의 모든 기능을 포함하며, 일반적으로 BeanFactory보다 추천됩니다. 트랜잭션처리, AOP등에 대한 처리를 할 수 있습니다. BeanPostProcessor, BeanFactoryPostProcessor등을 자동으로 등록하고, 국제화 처리, 어플리케이션 이벤트 등을 처리할 수 습니다.
- BeanPostProcessor : 컨테이너의 기본로직을 오버라이딩하여 인스턴스화 와 의존성 처리 로직 등을 개발자가 원하는 대로 구현 할 수 있도록 합니다.
- BeanFactoryPostProcessor : 설정된 메타 데이터를 커스터마이징 할 수 있습니다.

<br>

xml setting
==
### Bean class란?

> 예전에는 Visual 한 컴포넌트를 Bean이라고 불렀지만, 근래 들어서는 일반적인 Java클래스를 Bean클래스라고 보통 말합니다.

- 기본생성자를 가지고 있습니다.
- 필드는 private하게 선언합니다.
- getter, setter 메소드를 가집니다.
- *getName() setName()* 메소드를 *name 프로퍼티(property)* 라고 합니다. (용어 중요)

