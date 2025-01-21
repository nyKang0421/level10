package _09제네릭클래스;

class Box<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class Tv{
	String brand;
	int serialNo;
	Tv(String brand, int serialNo) {
		super();
		this.brand = brand;
		this.serialNo = serialNo;
	}
	
	@Override
	public String toString() {
		return "Tv [brand=" + brand + ", serialNo=" + serialNo + "]";
	}
	
	
}

class Product<T, M>{
	private T kind;
	private M model;
	public T getKind() {
		return kind;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Product [kind=" + kind + ", model=" + model + "]";
	}
	
}



public class _01제네릭클래스이론 {
	public static void main(String[] args) {
		Box<Integer> test = new Box();
		
		test.setT(10);
		System.out.println(test.getT());
		
		Box<String> test2 = new Box();
		test2.setT("개똥이");
		System.out.println(test2.getT());
		
		Box<Tv> test3 = new Box();
		test3.setT(new Tv("SAMSUNG",202501201));
		System.out.println(test3.getT());
		
		Product<Integer,String> test4 = new Product();
		test4.setKind(1000);
		test4.setModel("모델명");
		System.out.println(test4);
		
		Product<Tv, String> test5 = new Product();
		test5.setKind(new Tv("LG",22222));
		test5.setModel("스텐바이미");
		System.out.println(test5);
		
	}

}
