package _08열거타입enum;
import _08열거타입enum.PizzaMenu;

public class PizzaStore {
	
	PizzaMenu[] menues = PizzaMenu.values();
	
	void printAllMenus() {
		for(PizzaMenu pizza : menues) {
			System.out.println(pizza);
		}
	}
	
	void takeOrder(String name) {
		PizzaMenu menu = PizzaMenu.getMenu(name);
		if(menu == null) {
			System.out.println("해당피자는 존재하지 않습니다.");
		}
		
		System.out.println(menu.getPrice()+"원입니다.");
	}

}
