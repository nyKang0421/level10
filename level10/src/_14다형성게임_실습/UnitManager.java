package _14다형성게임_실습;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	
	Vector<Player> player_list = new Vector<>();
	Vector<Unit> mon_list = new Vector<>();
	String path = UnitManager.class.getPackageName()+".";
	String mons[] = {"UnitWolf","UnitBat","UnitOrc"};
	Random rd = new Random();
	
	UnitManager(){
		player_list.add(new Player("전사",1000,70));
		player_list.add(new Player("마법사",600,55));
		player_list.add(new Player("힐러",700,40));
	}
	
	void monster_rand_set(int size) {
		for(int i = 0; i<size; i++) {
			int num = rd.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance(); // clazz.newInstance();
				Unit temp = (Unit) obj; // 다운캐스팅
				int hp = rd.nextInt(100)+100;
				int pow = rd.nextInt(10)+10;
				temp.init(hp,pow);
				mon_list.add(temp);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}