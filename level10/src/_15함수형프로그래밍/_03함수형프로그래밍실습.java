package _15함수형프로그래밍;

import java.util.function.BinaryOperator;

interface CalFunctional{
	int Excute(int a, int b);
}

class Calculate{
	int add(int a, int b) {return a+b;}
	int subtract(int a, int b) {return a-b;}
	int multiply(int a, int b) {return a*b;}
}

public class _03함수형프로그래밍실습 {
	public static void main(String[] args) {
		Calculate cal = new Calculate();
		System.out.println(cal.add(10, 20));
		System.out.println(cal.subtract(10, 20));
		System.out.println(cal.multiply(10, 20));
		
		// 함수형 인터페이스 CalFunction 만들어서 위와 같은 결과 실행
		// 각가 인터페이스 변수 3개 생성해서 이름 => add, subtract, multiply로 생성후 호출
		
		System.out.println("======================");
		
		CalFunctional add = (int a, int b) -> {return a+b;};
		CalFunctional subtract = (int a, int b) -> a-b;
		CalFunctional multiply = (int a, int b) -> a*b ;
		
		System.out.println(add.Excute(10, 20));
		System.out.println(subtract.Excute(10, 20));
		System.out.println(multiply.Excute(10, 20));
		
		System.out.println("======================");
		
		BinaryOperator<Integer> add2 = (a,b) -> a+b;
		BinaryOperator<Integer> subtract2 = (a,b) -> a-b;
		BinaryOperator<Integer> multiply2 = (a,b) -> a*b;
		System.out.println(add2.apply(10, 20));
		System.out.println(subtract2.apply(10, 20));
		System.out.println(multiply2.apply(10, 20));
	}

}
