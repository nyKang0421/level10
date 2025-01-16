package 추상_개념;

import java.util.ArrayList;

public class _MainPizza {

	public static void main(String[] args) {
		
		PizzaService service = new PizzaService();
		//Pizza pizza = new Pizza(1200,"피자헛","불고기피자");
		ArrayList<Pizza> orderList = new ArrayList<Pizza>();
		// Pizza로 ArrayList를 생성했지만
		// ArrayList에는 업캐스팅하여 자식 클래스로 입력
		
		// 업케스팅 
		orderList.add(new SweetPotatoPizza(12000, "피자헛"));
		orderList.add(new BulgogiPizza(10000, "일인피자"));
		orderList.add(new PineApplePizza(13000, "미스터피자"));
		orderList.add(new BulgogiPizza(20000, "도미노피자"));
		orderList.add(new SweetPotatoPizza(8000, "피자스쿨"));
		
		service.orderPizzas(orderList);
		
		//System.out.println(orderList.get(0).test);
		SweetPotatoPizza pizza2 = (SweetPotatoPizza)orderList.get(0);
		System.out.println(pizza2.test);

	}

}
