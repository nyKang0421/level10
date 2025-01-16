package 추상_개념;

// 부모클래스 == 상위 클래스 == 슈퍼클래스
class Parent{
	int a=10;
	int b=20;
	
}

// 자식클래스 == 하위클래스 == 서브클래스
class Child extends Parent{
	int c=30;
	int d=40;
	
}

public class _02추상클래스2 {
	public static void main(String[] args) {
		// casting : 형변환
		
		// 강제형변환
		System.out.println((int)10.2345);
		
		Parent p = new Parent();
		Child c = new Child();
		
		
		// upcasting : 하위클래스가 상위타입 전환 : 자식클래스 객체가 부모 클래스 객체 전환
		
		Parent parent = new Child(); // 업캐스팅
		
		//downcasting : 상위클래스를 하위타입 변환?
		
		//Child child = new Parent();
		Child child = (Child)parent;
	}

}
