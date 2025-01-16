package 추상_개념2;

public class MyChicken extends MyBrand {
	
	private static int myNum = 0;
	
	public static String getSlogan() {
		return String.format(SLOGAN, "연미치킨");
	}

	public MyChicken(String name) {
		super(++myNum, name);
	}

	@Override
	public void takeOrder() {
		
		System.out.printf("연미치킨 %s 치킨을 주문했습니다\n", super.info());
		
	}

}
