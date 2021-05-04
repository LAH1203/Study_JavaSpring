Junit
==

### 1. JUnit이란?
> 프로그래밍 언어마다 테스트를 위한 프레임워크가 존재합니다. 이러한 도구들을 보통 xUnit이라고 말합니다. 자바언어의 경우는 JUnit이라고 말합니다.

- 각 언어마다 사용되는 xUnit은 다음과 같습니다.
![image](https://cphinf.pstatic.net/mooc/20200211_139/1581397814787LQDlX_PNG/1.png)

### 2. JUnit 사용하기

JUnit을 사용하려면 JUnit 라이브러리가 클래스패스(CLASSPATH)에 존재해야 합니다.
직접 다운로드를 받는 것은 번거롭기 때문에 보통 빌드 도구인 Maven이나 Gradle을 이용해 다운로드 받아 사용합니다.

<details>
<summary>Maven을 사용할 경우 pom.xml에 다음을 추가합니다.</summary>
<div markdown="1">       

```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>버전</version>
  <scope>test</scope>
</dependency> 
```

</div>
</details>

scope가 test인 이유는 해당 라이브러리가 테스트 시에만 사용된다는 뜻입니다. 
테스트가 아닌 상황에선 해당 라이브러리가 사용되지 않습니다.

### 3. JUnit을 이용해 자바 어플리케이션 테스트 하기 실습
- 사칙연산을 구하는 CalculatorService 클래스를 작성합니다.

테스트를 할 CalculatorService 클래스를 작성해 보도록 하겠습니다.
```java
package org.edwith.webbe.calculatorcli;

public class CalculatorService {
    public int plus(int value1, int value2) {
        return value1 + value2;
    }

    public int minus(int value1, int value2) {
        return value1 - value2;
    }

    public int multiple(int value1, int value2) {
        return value1 * value2;
    }

    public int divide(int value1, int value2) throws ArithmeticException {
        return value1 / value2;
    }
}
```

CalculatorService클래스는 덧셈(plus), 뺄셈(minus), 곱셈(multiple), 나눗셈(divide)을 위한 메소드를 가집니다. 
나누기의 경우 0으로 나누게 되면 ArithmeticException이 발생하기 때문에
divide() 메소드에는 ArithmeticException을 throws 하고 있는 것을 확인할 수 있습니다.

<br>
<br>

- CalculatorService클래스를 테스트하는 CalculatorServiceTest클래스를 /src/test/java 폴더 아래에 작성합니다.
```java
package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorServiceTest {
    CalculatorService calculatorService;

    @Before
    public void init(){
        this.calculatorService = new CalculatorService();
    }

    @Test
    public void plus() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService.plus(value1, value2);

        // then
        Assert.assertEquals(15, result); // 결과와 15가 같을 경우에만 성공
    }

    @Test
    public void divide() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService. divide (value1, value2);

        // then
        Assert.assertEquals(2,result); // 결과와 2가 같을 경우에만 성공
    }

    @Test
    public void divideExceptionTest() throws Exception{
        // given
        int value1 = 10;
        int value2 = 0;

        try {
            calculatorService.divide(value1, value2);
        }catch (ArithmeticException ae){
            Assert.assertTrue(true); // 이부분이 실행되었다면 성공
            return; // 메소드를 더이상 실행하지 않는다.
        }
        Assert.assertFail(); // 이부분이 실행되면 무조건 실패다.

    }
}
```

먼저 코드를 살펴보면 @Before, @Test와 같은 어노테이션이 붙은 것을 확인할 수 있습니다.
Junit을 이용하는 테스트 클래스는 다음과 같은 어노테이션이 주로 이용됩니다.
![image](https://user-images.githubusercontent.com/22065527/116964750-344fcd00-ace7-11eb-8bf6-b9228fd40a3c.png)

- 테스트 클래스에 테스트 메소드가 3개 있다면, 각각의 메소드에는 @Test가 붙어 있어야 합니다.

1. 테스트 클래스가 실행되기 전에 @BeforeClass가 붙은 메소드가 실행됩니다.
2. 그리고 테스트 메소드가 실행되기 전에 @Before가 붙은 메소드가 실행됩니다.
3. 그다음은 @Test가 붙은 메소드가 실행되고 @After가 붙은 메소드가 실행됩니다.
4. 이렇게 3개의 메소드가 실행된 후에 @AfterClass가 붙은 메소드가 실행되고 프로그램은 종료됩니다.
![image](https://user-images.githubusercontent.com/22065527/116964843-71b45a80-ace7-11eb-9ae6-1fbe1c3f14e2.png)

JUnit테스트 클래스 실행은 이클립스를 사용할 경우 이클립스에 내장된 JUnit에 의해 실행됩니다.
이클립스에 내장된 Junit에 @Test가 붙은 메소드를 실행하는 main(String[] args)메소드가 있다고 생각하면 좋을 것 같습니다.
<br>
<br>

### 4. JUnit의 중요 assert
![image](https://cphinf.pstatic.net/mooc/20200211_44/1581398989118HbTys_PNG/3.png)

