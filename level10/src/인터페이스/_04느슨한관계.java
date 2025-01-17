package 인터페이스;

interface I{
	
	void methodI();
}

class AAA{
	// 인터페이스로 맞췄기 때문에 
	void methodA(I i) {
		System.out.println("메서드 a 호출");
		i.methodI();
	}
}

class BBB implements I{

	@Override
	public void methodI() {
		System.out.println("BBB가 메서드 I 호출");
		
	}
	
}

class CCC implements I{

	@Override
	public void methodI() {
		System.out.println("CCC가 메서드 I 호출");
		
	}
	
}



public class _04느슨한관계 {

	public static void main(String[] args) {
		AAA a = new AAA();
		a.methodA(new BBB());
		a.methodA(new CCC());

	}

}
