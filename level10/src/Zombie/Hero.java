package Zombie;

public class Hero extends Unit {
	
	private int potion;

	public Hero(String name, int pos, int hp, int power,int potion) {
		super(name, pos, hp, power);
		this.potion = potion;
	}

	public int getPotion() {
		return potion;
	}

	public void setPotion(int potion) {
		this.potion = potion;
	}
	
	public void potion() {
		potion -= 1;
		int recovery = 100;
		if(getHp()>100) {
			recovery = getMAX_HP()-getHp();
		}
		System.out.printf("체력 %d 회복\n", recovery);
		this.setHp(this.getHp()+recovery);
	}
	
	public void attack(Boss boss) {
		if(boss.getShield()>0) {
			boss.setShield(boss.getShield()-this.getDamage());
			if(boss.getShield()<0) {
				boss.setShield(0);
			}
		}else {
			boss.setHp(boss.getHp()-this.getDamage());
			if(boss.getHp()<0) {
				boss.setHp(0);
			}
		}
		System.out.printf("%s 가 %d 대미지 공격 { %s %s+(shield %d) }\n",getName(), getDamage(), boss,this,boss.getShield());
	}
	
	

}
