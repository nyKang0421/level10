package _14다형성게임_실습;

import java.util.Vector;

public class Player extends Unit {
	
	Player(String na, int max, int pow) {
		super(na, max, pow);
	}
	
	void skill(int idx, Vector<Player> playerList, Vector<Unit> monList) {
		Player p = playerList.get(idx);
		if(idx == 0) {
			for(int i = 0; i<monList.size();i++) {
				if(monList.get(i).curhp > 0) {
					p.attack(monList.get(i));
				}
			}
		}else if(idx == 1) {
			System.out.println("[" + name + "] 이 스킬로 " + " 모두 에게 " + power + "의 두배 데미지를 입힙니다. ");
			for(int i = 0; i<monList.size();i++) {
				if(monList.get(i).curhp > 0) {
					monList.get(i).curhp -= power*2;
					if (monList.get(i).curhp <= 0) {
						System.out.println("[" + monList.get(i).name + "] 을 쳐치했습니다.");
						monList.get(i).curhp = 0;
					}
				}
			}
		}else if(idx == 2) {
			System.out.println(name+"이 치료를 합니다.");
			for(int i = 0; i<playerList.size();i++) {
				if(playerList.get(i).curhp > 0) {
					playerList.get(i).curhp += 100;
					if(playerList.get(i).curhp>playerList.get(i).maxhp) playerList.get(i).curhp=playerList.get(i).maxhp;
				}
			}
		}
	}

}