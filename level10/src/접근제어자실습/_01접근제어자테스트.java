package 접근제어자실습;

import 상속_개념.AccessTest;

class Child extends AccessTest{
	int f = 50;
	Child(){
		
		super.a = 100;
		System.out.println(super.c);
		// 부모 클래스에서 public으로 정의한 a와 protected로 정의한 c만 접근 가능하다
	}
}

public class _01접근제어자테스트 {

	public static void main(String[] args) {
		
		Child c = new Child();
		c.a = 100;
		c.f = 200;
		
		AccessTest acc = new AccessTest();

	}

}
