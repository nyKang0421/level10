package _08열거타입enum;

import java.util.ArrayList;

public class _03enum개념3 {
	public static void main(String[] args) {
		
		ArrayList<PizzaMenu> list = new ArrayList<PizzaMenu>();
		list.add(PizzaMenu.CP);
		list.add(PizzaMenu.PP);
		list.add(PizzaMenu.SP);
		list.add(PizzaMenu.MP);
		list.add(PizzaMenu.HP);
		list.add(PizzaMenu.BP);
		
		for(PizzaMenu pizza : list) {
			System.out.println(pizza.getDesc());
		}
		System.out.println("-------");
		for(PizzaMenu pizza : list) {
			System.out.println(pizza.name());
		}
		System.out.println("-------");
		for(PizzaMenu pizza : list) {
			System.out.println(pizza.ordinal());
		}
		
		PizzaStore store = new PizzaStore();
		store.printAllMenus();
		
		store.takeOrder("마라피자");
		store.takeOrder("고구마피자");
		
	}

}
