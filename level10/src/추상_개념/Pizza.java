package 추상_개념;

public abstract class Pizza {
	
	int price;
	String brand;
	String name;
	
	Pizza(int price, String brand, String name) {
		super();
		this.price = price;
		this.brand = brand;
		this.name = name;
	}

	void makingPizza() {
		makeDough();
		putTopping();
		bakePizza();
		cutPizza();
		putInBox();
		System.out.println(this + "완성!!!");
	}
	
	void makeDough() {
		System.out.println("피자 도우 만들기!!");
	}
	abstract void putTopping();
	
	void bakePizza() {
		System.out.println(name +" 피자를 굽기!!!");
	}
	
	void cutPizza() {
		System.out.println("피자 커팅하기 !!!!");
	}
	
	void putInBox() {
		System.out.println("피자 포장하기");
	}
	
	@Override
	public String toString() {
		return String.format("%s %s(%d)", brand, name , price);
		
	}

}
