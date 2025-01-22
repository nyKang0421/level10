package _14다형성게임_실습;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("==== TEXT RPG ====");
		System.out.println("[Enter]를 눌러주세요");
		String start = GameManager.sc.nextLine();
		//if (start.equals("시작"));
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}