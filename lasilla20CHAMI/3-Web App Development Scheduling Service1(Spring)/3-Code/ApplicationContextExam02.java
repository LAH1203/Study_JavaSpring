/*
1, 2 번째 줄을 Spring 컨테이너에게 맡기기 위해 설정파일에 다음과 같은 코드를 입력합니다.

<bean id="e" class="kr.or.connect.diexam01.Engine"></bean>
<bean id="car" class="kr.or.connect.diexam01.Car">
	<property name="engine" ref="e"></property>
</bean>
*/

package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext( 
				"classpath:applicationContext.xml"); 

		Car car = (Car)ac.getBean("car");
		car.run();
		
	}
}
