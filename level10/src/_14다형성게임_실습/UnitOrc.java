package _14다형성게임_실습;

public class UnitOrc extends Unit {
	
	UnitOrc() {
		name = "오크";
	}

	void skill(Unit target) {
		//System.out.println("한명에게 2배의 데미지 + 기절 ");
		target.curhp -= power*2;
		System.out.println("[" + name + "] 이 스킬로 " + "[" + target.name + "] 에게 " + power + "의 두배 데미지를 입힙니다. ");
		if (target.curhp <= 0) {
			System.out.println("[" + target.name + "] 을 쳐치했습니다.");
			target.curhp = 0;
		}

	}

}