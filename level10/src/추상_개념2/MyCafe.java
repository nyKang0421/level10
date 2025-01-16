package 추상_개념2;

public class MyCafe extends MyBrand {
	
	private boolean istakeout;
	
	private static int myNum = 0;
	
	public static String getSlogan() {
		return String.format(SLOGAN, "연미카페");
	}

	public MyCafe(String name, boolean isTakeOut) {
		super(++myNum, name);
		istakeout = isTakeOut;
	}

	@Override
	public void takeOrder() {
		
		System.out.printf("연미카페 %s 커피를 주문했습니다\n",super.info()+(istakeout?" (테이크아웃)":" (매장이용)"));
		
	}

}
