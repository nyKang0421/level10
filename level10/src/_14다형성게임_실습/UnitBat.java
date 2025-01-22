package _14다형성게임_실습;

public class UnitBat extends Unit {
	
	UnitBat() {
		name = "박쥐";
	}

	void skill(Unit target) {
		//System.out.println("적 한명에게 침묵 시전 ");
		System.out.println("[" + name + "] 이 " + "[" + target.name + "] 를 기절 시켰습니다. ");
	}
	
}