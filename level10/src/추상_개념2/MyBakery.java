package 추상_개념2;

public class MyBakery extends MyBrand {
	
	public static String getSlogan() {
		return String.format(SLOGAN, "연미빵집");
	}
	
	private static int myNum = 0;
	
	private boolean isHandmade;

	public MyBakery(String name, boolean isHandMade) {
		super(++myNum, name);
		this.isHandmade = isHandMade;
	}

	@Override
	public void takeOrder() {
		
		System.out.printf("연미 빵집 %s 빵을 주문했습니다\n", super.info()+(isHandmade?" 수제":""));
		
	}

}
