package 추상_개념2;

public class _Main {

	public static void main(String[] args) {
		
		
		MyBakery store1 = new MyBakery("구미", false);
		MyBakery store2 = new MyBakery("강남", true);
		
		MyChicken store3 = new MyChicken("강남");
		MyChicken store4 = new MyChicken("홍대");
		MyChicken store5 = new MyChicken("압구정");
		
		MyCafe store6 = new MyCafe("강남역", true);
		MyCafe store7 = new MyCafe("신논현역", true);
		MyCafe store8 = new MyCafe("압구정", false);
		
		MyBrand[] mystores = {store1, store2, store3, store4, store5, store6, store7, store8};
		
		for(MyBrand store : mystores) {
			//MyBakery mystore = (MyBakery) store; // 같은 자식 클래스끼리는 변환 불가
			if(store instanceof MyBakery) {
				MyBakery mystore = (MyBakery) store;// 부모클래스를 자식클래스로 형변환 MyBrand => MyBakery
				store.takeOrder();
			}
			
		}
		
		/*
		System.out.println(MyBakery.getSlogan());
		store1.takeOrder();
		store2.takeOrder();
		
		System.out.println(MyChicken.getSlogan());
		store3.takeOrder();
		store4.takeOrder();
		store5.takeOrder();
		
		System.out.println(MyCafe.getSlogan());
		store6.takeOrder();
		store7.takeOrder();
		store8.takeOrder();
		*/

	}

}
