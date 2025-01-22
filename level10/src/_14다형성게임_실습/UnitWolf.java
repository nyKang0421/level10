package _14다형성게임_실습;

import java.util.Vector;

public class UnitWolf extends Unit {
	
	UnitWolf() {
		name = "늑대";
	}

	void skill(Vector<Player> p) {
		//System.out.println("적 전체에게 공격력의 절반 데미지");
		System.out.println("[" + name + "] 이 스킬로 " + "모두 에게 " + power + "의 절반 데미지를 입힙니다. ");
		for(Player pl : p) {
			if(pl.curhp >0) {
				pl.curhp -= power*2;
				if (pl.curhp <= 0) {
					System.out.println("[" + pl.name + "] 을 쳐치했습니다.");
					pl.curhp = 0;
				}
			}
		}
	}
}