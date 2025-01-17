package Zombie;

import java.util.Scanner;

public class _gameMain {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		Hero hero = new Hero("히어로", 1, 200, 30, 2);
		Zombie zombie = new Zombie("좀비", 5, 100, 10);
		Boss boss = new Boss("대장좀비", 9, 300, 20, 100);
		
		while(true) {
			System.out.println("현재 위치 = "+hero.getPos());
			
			System.out.println("[1] 앞으로 이동 [2] 종료");
			int move = 0;
			try {
				move = s.nextInt();
			}catch(Exception e) {
				System.out.println("숫자 1, 2 만 입력 가능!");
				s.nextLine();
			}
			
			if(move == 2) {
				System.out.println("게임을 종료합니다");
				break;
			}else if(move == 1) {
				hero.setPos(hero.getPos()+1);
				int p = hero.getPos();
				if(p == zombie.getPos()) {
					System.out.println("좀비를 만났습니다. 공격을 준비합니다!");
					int recovery = 0;
					while(true) {
						if(recovery != 0) zombie.Recover(recovery);
						zombie.setDamage(zombie.getRd().nextInt(zombie.getPower())+1);
						recovery = zombie.getDamage()/2;
						zombie.attack(hero);
						if(hero.getHp() <= 0) {
							break;
						}
						int sel = 0;
						while(true) {
							System.out.println("[1] 공격하기 [2] 포션 마시기");
							try {
								sel = s.nextInt();
								break;
							}catch(Exception e) {
								System.out.println("숫자 1, 2 만 입력 가능!");
								s.nextLine();
							}
						}
						if(sel == 1) {
							hero.setDamage(hero.getRd().nextInt(hero.getPower())+1);
							hero.attack(zombie);
						}else if(sel == 2) {
							if(hero.getPotion()>0) {
								hero.potion();
							}else {
								System.out.println("포션이 없어 공격으로 대체합니다");
								hero.setDamage(hero.getRd().nextInt(hero.getPower())+1);
								hero.attack(zombie);
							}
						}
						if(zombie.getHp()<=0) {
							System.out.println("몹을 처치했습니다!");
							break;
						}
					} 
				} // 일반몹 
				
				if(p == boss.getPos()) {
					System.out.println("보스좀비를 만났습니다. 공격을 준비합니다!");
					
					while(true) {
						boss.setDamage(boss.getRd().nextInt(boss.getPower())+1);
						boss.attack(hero);
						if(hero.getHp() <= 0) {
							break;
						}
						int sel = 0;
						while(true) {
							System.out.println("[1] 공격하기 [2] 포션 마시기");
							try {
								sel = s.nextInt();
								break;
							}catch(Exception e) {
								System.out.println("숫자 1, 2 만 입력 가능!");
								s.nextLine();
							}
						}
						if(sel == 1) {
							hero.setDamage(hero.getRd().nextInt(hero.getPower())+1);
							hero.attack(boss);
						}else if(sel == 2) {
							if(hero.getPotion()>0) {
								hero.potion();
							}else {
								System.out.println("포션이 없어 공격으로 대체합니다");
								hero.setDamage(hero.getRd().nextInt(hero.getPower())+1);
								hero.attack(boss);
							}
						}
						if(boss.getHp()<=0) {
							System.out.println("보스몹을 처치했습니다!");
							break;
						}
					}
				}
				
				if(hero.getHp() <= 0 ) {
					System.out.println("패배....");
					break;
				}
				if(hero.getPos() == 10) {
					System.out.println("승리!!!!!");
					break;
				}
				
			}
			
			
			
		}

	}

}
