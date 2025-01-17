package Zombie;

import java.util.Random;

abstract public class Unit {
	private String name;
	private int pos;
	private final int MAX_HP;
	private int hp;
	private int power;
	private int damage;
	private Random rd;
	
	public Unit(String name, int pos, int hp, int power) {
		this.name = name;
		this.pos = pos;
		this.MAX_HP = hp;
		this.hp = this.MAX_HP;
		this.power = power;
		rd = new Random();
	}
	
	public String getName() {
		return name;
	}
	public int getPos() {
		return pos;
	}
	public int getMAX_HP() {
		return MAX_HP;
	}
	public int getHp() {
		return hp;
	}
	public int getPower() {
		return power;
	}
	public int getDamage() {
		return damage;
	}
	public Random getRd() {
		return rd;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return name+"_HP [ "+hp+"/"+MAX_HP+" ]";
	}
	
	void attack(Unit unit) {
		unit.setHp(unit.getHp()-damage);
		if(unit.getHp()<0) {
			unit.setHp(0);
		}
		System.out.printf("%s 가 %d 대미지 공격 { %s %s }\n",name, damage, unit,this);
	}
	
	
	

}
