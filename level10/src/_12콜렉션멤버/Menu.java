package _12콜렉션멤버;

public enum Menu {
	
	INSERT("insert"), DELETE("delete"), UPDATE("update"),
	PRINT("print"), SAVE("save"), LOAD("load");
	
	private String order;
	Menu(String order) {
		this.order = order;
	}
	
	public String getOrder() {
		return order;
	}
	
	static Menu getMenu(String string) {
		for(Menu menu : Menu.values())
			if(string.equals(menu.getOrder()))
				return menu;
		return null;
	}

}
