package 추상_개념;

public class PineApplePizza extends Pizza {
	
	PineApplePizza(int price, String brand) {
		super(price, brand, "하와이안피자");
	}

	@Override
	void putTopping() {
		System.out.println(" 파인애플 토핑~~~!!");
	}

}
