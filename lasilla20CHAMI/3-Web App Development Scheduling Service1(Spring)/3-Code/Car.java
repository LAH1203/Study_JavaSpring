package kr.or.connect.diexam01;

public class Car {
	Engine v8;
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	public void setEngine(Engine e) {
		this.v8 = e;
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
}
/*
위의 Car 클래스가 제대로 동작하도록 하려면 보통 다음과 같은 코드가 작성되야 합니다.
Engine e = new Engine();
Car c = new Car();
c.setEngine( e );
c.run();
*/

/*
1, 2 번째 줄을 Spring 컨테이너에게 맡기기 위해 설정파일에 다음과 같은 코드를 입력합니다.

<bean id="e" class="kr.or.connect.diexam01.Engine"></bean>
<bean id="car" class="kr.or.connect.diexam01.Car">
	<property name="engine" ref="e"></property>
</bean>
*/
