package _14다형성게임_실습;

public class _MainGame {

	public static void main(String[] args) {
		
		// polyGame_guide 는 미완성 가이드입니다.
		// 콘솔 실행 후, 게임의 흐름을 파악한 뒤 -> 프로젝트를 완성해주세요.
		// 누락된 접근제어자 모두 추가해주세요.
		
		GameManager gameManager = new GameManager();
		boolean run = true;
		while(true) {
			run = gameManager.changeStage();
			if(!run) break;
		}
		System.out.println("게임오버");
		
	}
}