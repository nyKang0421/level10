package 인터페이스;

// 추상클래스 vs 인터페이스
// 인터페이스는 다중상속이 목적이다.
// 인터페이스는 객체를 따로 못 만든다, 추상클래스보다 더 추상적이다
// 인터페이스 자체는 객체를 생성하는 것이 목적이 아니다!

// 추상클래스 : 동물 식물 기계
// 인터페이스 : movable() flyable() eatable() swimable() aboardable()

// 자동차 : 기계 : movable, aboardable()
// 새 : 동물 : flyable(), movable(), eatable(), swimable()
// 사람 : 동물 : movable(), eatable(), swimable()
// 오리배 : 기계 : movable(), swimable(), aboardable()
// 연꽃 : 식물 : swimable()

/*
					추상클래스				|			인터페이스
개념			| 물려받는것 (혈통, 가문, 계열)	| 장착한다 (기능, 행위, 학위 , 자격증)
다중적용		| 불가능 (부모는 하나)			| 가능
생성자		| 가짐						| 갖지 않음
메서드		| 완성된 메서드, 미완성 메서드		| 추상메서드, default(완성된 메서드), static(완성된 메서드)
필드(멤버변수)	| 
			|
 */

class A{
	int num = 10;
	final int num2 = 10;
}

abstract class B{
	int num = 10;
	abstract void init();
}

// 추상클래스보다 더 추상적인 것 => 인터페이스 => 여러개를 상속하려고
// 인터페이스에서 멤버 변수는 무조건 상수 , public static final 변수 임을 의미
interface C{ 
	//int num; => 초기 값이 있어야 한다. static final 이기 때문에?
	int num = 10; // public static final int num = 10;
	void test1(); // public static final void test1();
	
	//void test2() {};
	default void test2() {};
		
}

interface D{
	void test2();
}

class F extends A implements C, D{ // 인터페이스와 클래스 간 상속에서는 implements 사용 (여러개 가능)

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}
	
}

interface G extends D{ // 인터페이스간에는 상속시 extends
	
}



public class _01인터페이스 {

	public static void main(String[] args) {
		
		// C c = new C(); // 인터페이스는 생성자가 아예 불가능

	}

}
