package 상속_개념;

class D{
	int d;
	D(){
		System.out.println("D 생성!!");
	}
}

class E extends D {
	int e;
	E(){
		System.out.println("E 생성!!");
	}
}

class F extends E{
	int f;
	F(){
		System.out.println("F 생성!!");
	}
}


public class _02상속2 {
	public static void main(String[] args) {
		
		F f = new F();
		// 상속의 상속의 상속..... 이 가능하다
		// 여러번의 상속이 가능하지만 제일 최상의 조상? 부모가 제일 먼저 생성된다.
		
	}

}
