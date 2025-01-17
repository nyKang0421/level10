package Zombie;

public class Boss extends Unit {
	
	private int shield;

	public Boss(String name, int pos, int hp, int power,int shield) {
		super(name, pos, hp, power);
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shiled) {
		this.shield = shiled;
	}
	
	public void attack(Unit unit) {
		int r = getRd().nextInt(4);
		unit.setHp(unit.getHp()-this.getDamage());
		if(r == 3) {
			unit.setHp(unit.getHp()-this.getDamage());
		}
		if(unit.getHp()<0) {
			unit.setHp(0);
		}
		System.out.printf("%s 가 %d 대미지 공격 { %s %s }\n",getName(), getDamage(), unit,this);
	}
	


}
