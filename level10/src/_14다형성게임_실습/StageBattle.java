package _14다형성게임_실습;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	
	UnitManager unitManager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monList = null;
	Random rd = new Random();
	int monDead = 0;
	int playerDead = 0;
	boolean monsState = true;
	boolean[] plState;
	int[] monCnt;
	int[] plCnt;
	
	@Override
	public void init() {
		unitManager.mon_list.clear();
		unitManager.monster_rand_set(4);
		playerList = null;
		playerList = unitManager.player_list;
		monList = null;
		monList = unitManager.mon_list;
		monDead = monList.size();
		playerDead = playerList.size();
		plState = new boolean[playerList.size()];
		monCnt = new int[monList.size()];
		plCnt = new int[playerList.size()];
	}


	@Override
	public boolean update() {
		boolean run = true;
		int p_idx = 0;
		int m_idx = 0;
		boolean turn = true;
		
		while(run) {
			if(turn) {
				print_character();
				if(p_idx < playerList.size()) {
					if(plState[p_idx]) {
						p_idx += 1;
						plState[p_idx] = false;
						continue;
					}
					player_attack(p_idx);
					
					p_idx += 1;
					
					check_live();
				}else {
					turn = !turn;
					p_idx = 0;
				}
				if(monDead <= 0 || playerDead <= 0) break;
			}else if(!turn) {
				if(!monsState) {
					monsState = true;
					continue;
				}
				if (m_idx < monList.size()) {
					monster_attack(m_idx);
					m_idx += 1;
					check_live();
					if(monDead <= 0 || playerDead <= 0) break;
				} else {
					turn = !turn;
					m_idx = 0;
				}
			}
			
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	private void check_live() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).curhp <= 0)
				num++;
		}
		playerDead = playerList.size() + num;
		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).curhp <= 0)
				num++;
		}
		monDead = monList.size()-num;
	}


	private void monster_attack(int idx) {
		Unit m = monList.get(idx);
		if (m.curhp <= 0)
			return;
		if(monCnt[idx] < 3) {
			while (true) {
				int index = rd.nextInt(playerList.size());
				if (playerList.get(index).curhp > 0) {
					m.attack(playerList.get(index));
					monCnt[idx]++;
					break;
				}
			}
		}else {
			int index = -1;
			while(true) {
				index = rd.nextInt(playerList.size());
				if (playerList.get(index).curhp > 0) {
					break;
				}
			}
			if(m.name.equals("오크")) {
				((UnitOrc) m).skill(playerList.get(index));
				plState[index] = true;
			}
			if(m.name.equals("박쥐")) {
				((UnitBat) m).skill(playerList.get(index));
				plState[index] = true;
			}
			if(m.name.equals("늑대")) {
				((UnitWolf) m).skill(playerList);
			}
			monCnt[idx] = 0;
		}
		
	}


	private void player_attack(int idx) {
		Player p = playerList.get(idx);
		if(p.curhp <= 0) return;
		int sel = 0;
		while(true) {
			System.out.println("======[메뉴 선택]=====");
			if(plCnt[idx]>= 2) {
				System.out.println("[" + p.name + "] [1.어택] [2.스킬]");
			}else {
				System.out.println("[" + p.name + "] [1.어택]");
			}
			sel = GameManager.sc.nextInt();
			if(sel == 1) break;
			if(plCnt[idx] >= 2 && sel == 2) break;
			System.out.println("선택오류");
		}
		if(sel == 1) {
			while(true) {
				int index = rd.nextInt(monList.size());
				plCnt[idx]++;
				if(monList.get(index).curhp > 0) {
					p.attack(monList.get(index));
					break;
				}
			}
		}else if(sel == 2) {
			if(idx == 0) monsState = false; // 1턴 기절
			p.skill(idx, playerList, monList);
			plCnt[idx] = 0;
		}
	}

	private void print_character() {
		System.out.println("======[BATTLE]======");
		System.out.println("======[PLAYER]======");
		for(Unit u : playerList)
			u.printData();
		System.out.println("======[MONSTER]======");
		for(Unit u : monList)
			u.printData();
	}


}