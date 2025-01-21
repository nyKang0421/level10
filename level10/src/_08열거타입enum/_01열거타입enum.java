package _08열거타입enum;

// 열거 타입 enumeration type => 상수 모음집

enum ButtonMode{
	LIGHT, DARK
}
enum ButtonSpace{
	SINGLE, DOUBLE
}

class Button{
	ButtonMode buttonMode = ButtonMode.LIGHT;
	ButtonSpace buttonSpace = ButtonSpace.SINGLE;
	
	public void changeButtonMode() {
		buttonMode = buttonMode == ButtonMode.LIGHT? ButtonMode.DARK: ButtonMode.LIGHT;
	}
	
	public ButtonMode getButtonMode() {
		return buttonMode;
	}
	
	public ButtonSpace getButtonSpace() {
		return buttonSpace;
	}
	
	public void setButtonSpace(ButtonSpace buttonSpace) {
		this.buttonSpace = buttonSpace;
	}
}

public class _01열거타입enum {
	
	static final int num = 5;
	
	public static void main(String[] args) {
		
		String day = "MON";
		if(day == "MON") {
			System.out.println("오늘은 월요일입니다");
		}
		
		/*
		if(day == Week.MON) {
			System.out.println("오늘은 월요일입니다");
		}
		*/
		
		Week day2 = Week.MON;
		
		if(day2 == Week.MON) {
			System.out.println("오늘은 월요일입니다");
		}
		
		
		System.out.println(Week.MON);
		
		Week today = null;
		
		switch(today) {
		
		case MON: System.out.println("월요일입니다."); break;
		case TUE: System.out.println("화요일입니다."); break;
		case WED: System.out.println("수요일입니다."); break;
		case THR: System.out.println("목요일입니다."); break;
		case FRI: System.out.println("금요일입니다."); break;
		case SAT: System.out.println("토요일입니다."); break;
		case SUN: System.out.println("일요일입니다."); break;
		}
		
	}

}
