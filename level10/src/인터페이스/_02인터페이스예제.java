package 인터페이스;

interface Dragable{
	void move(int x, int y);
	
}
interface Clickable{
	void click();
	void doubleClick();
	
}

abstract class Button implements Dragable,Clickable{
	String name;
	int size;
	abstract void actionButton() ;
}

class Title implements Clickable{

	@Override
	public void click() {
		System.out.println("타이틀을 클릭했습니다.");
		
	}

	@Override
	public void doubleClick() {
		System.out.println("타이틀을 더블클릭했습니다.");
		
	}
	
}

class NaverButton extends Button{

	@Override
	void actionButton() {
		System.out.println("네이버 창으로 이동합니다.");
		
	}

	@Override
	public void move(int x, int y) {
		System.out.printf("좌료 %d %d 이동 \n", x, y);
		
	}

	@Override
	public void click() {
		System.out.println("같은 창에서 네이버 홈으로 이동합니다");
		
	}

	@Override
	public void doubleClick() {
		System.out.println("같은 창에서 네이버 홈으로 이동합니다");
		
	}
	
}

class GoogleButton extends Button{
	
	@Override
	void actionButton() {
		System.out.println("구글 창으로 이동합니다.");
		
	}

	@Override
	public void move(int x, int y) {
		System.out.printf("좌료 %d %d 이동 \n", x, y);
		
	}

	@Override
	public void click() {
		System.out.println("같은 창에서 구글 홈으로 이동합니다");
		
	}

	@Override
	public void doubleClick() {
		System.out.println("같은 창에서 구글 홈으로 이동합니다");
		
	}
	
}

public class _02인터페이스예제 {

	public static void main(String[] args) {
		
		Button btn1 = new NaverButton();
		Button btn2 = new GoogleButton();
		
		Title title = new Title();
		
		title.doubleClick();
		title.click();
		btn2.doubleClick();
		btn2.move(10, 20);

	}

}
