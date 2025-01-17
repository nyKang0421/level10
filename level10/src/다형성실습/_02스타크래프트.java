package 다형성실습;

import java.util.ArrayList;
import java.util.Random;


//damage() 메서드를 가진
//Interface Damageable을 정의하고
//최하위 유닛들	(모든) 에게 Damageable 상속
//main에서 각각의 유닛들을 손상시킨 후 -> repair() 돌려보기

interface Damageable{ }
interface Repairable{ }
interface Healable{ }

class Unit{
	final int MAX_HP;
	int hp;
	int damage;
	
	Unit(int MAX_HP,int damage){
		this.MAX_HP = MAX_HP;
		hp = MAX_HP;
		this.damage = damage;
	}
	
	void attack(Unit def) {
		try {
			Damageable unit = (Damageable) this;
			def.hp -= damage;
		}catch(Exception e) {
			System.out.println("공격불가");
			//e.printStackTrace();
		}
	}
	
}

class GroundUnit extends Unit{

	GroundUnit(int MAX_HP,int damage) {
		super(MAX_HP, damage);
	}
	
}

class AirUnit extends Unit{
	
	AirUnit(int MAX_HP,int damage) {
		super(MAX_HP,damage);
	}
	
}

class Marin extends GroundUnit implements Damageable,Healable{

	Marin() {
		super(150,10);
	}
	
	
	@Override
	public String toString() {
		return String.format(" Marin (%d/%d)",hp,MAX_HP);
	}
	
}
class SCV extends GroundUnit implements Damageable,Repairable,Healable{
	
	SCV() {
		super(120,5);
	}
	
	void RepairUnit(Repairable repairable) {
		Unit unit = (Unit) repairable;
		
		while(unit.hp != unit.MAX_HP) {
			unit.hp++;
		}
		System.out.println(unit+" 수리완료");
	}
	
	@Override
	public String toString() {
		return String.format(" SCV (%d/%d)",hp,MAX_HP);
	}
	
}
class Tank extends GroundUnit implements Damageable,Repairable{

	Tank() {
		super(250,30);
	}
	
	@Override
	public String toString() {
		return String.format(" Tank (%d/%d)",hp,MAX_HP);
	}
	
}
class Vulture extends GroundUnit implements Damageable,Repairable{
	
	Vulture() {
		super(200,20);
	}
	
	@Override
	public String toString() {
		return String.format(" Vulture (%d/%d)",hp,MAX_HP);
	}
	
}
class Wraith extends AirUnit implements Damageable,Repairable{

	Wraith() {
		super(200,20);
	}
	
	@Override
	public String toString() {
		return String.format(" Wraith (%d/%d)",hp,MAX_HP);
	}
	
}
class Valkyrie extends AirUnit implements Damageable,Repairable{
	
	Valkyrie() {
		super(250,30);
	}
	
	@Override
	public String toString() {
		return String.format(" Valkyrie (%d/%d)",hp,MAX_HP);
	}
	
}
class DropShip extends AirUnit implements Damageable,Repairable{

	DropShip() {
		super(250,0);
	}
	
	@Override
	public String toString() {
		return String.format(" DropShip (%d/%d)",hp,MAX_HP);
	}
}

class BattleCruiser extends AirUnit implements Damageable,Repairable{

	BattleCruiser() {
		super(500,150);
	}
	
	@Override
	public String toString() {
		return String.format(" BattleCruiser (%d/%d)",hp,MAX_HP);
	}
	
}

class FireBat extends GroundUnit implements Damageable,Healable {

	FireBat() {
		super(180,20);
	}
	
	@Override
	public String toString() {
		return String.format(" FireBat (%d/%d)",hp,MAX_HP);
	}
	
}

class Medic extends GroundUnit implements Damageable,Healable{ //

	Medic() {
		super(150,0);
	}
	
	void healUnit(Healable healable) {
		Unit unit = (Unit) healable;
		
		while(unit.hp != unit.MAX_HP) {
			unit.hp++;
		}
		System.out.println(unit+" 치료 완료");
	}

	@Override
	public String toString() {
		return String.format(" Medic (%d/%d)",hp,MAX_HP);
	}
}
class Run{
	
	Run(){
		ArrayList<Unit> unitList = new ArrayList();
		unitList = init(unitList);
		for(Unit u : unitList)
			System.out.println("[생성]"+u);
		System.out.println(Result(unitList));
		
	}

	private String  Result(ArrayList<Unit> unitList) {
		Random rd = new Random();
		while(unitList.size() > 1 ) {
			int first = rd.nextInt(unitList.size());
			int second = rd.nextInt(unitList.size());
			if(first == second) continue;
			unitList.get(first).attack(unitList.get(second));
			if(unitList.get(second).hp<0) {
				unitList.get(second).hp = 0;
				System.out.println(unitList.get(first)+" >> [ Attack ] >> "+unitList.get(second));
				if(unitList.get(second).hp<=0) unitList.remove(second);
			}
			else {
				System.out.println(unitList.get(first)+" >> [ Attack ] >> "+unitList.get(second));
				unitList.get(second).attack(unitList.get(first));
				if(unitList.get(first).hp<0) unitList.get(first).hp = 0;
				System.out.println(unitList.get(second)+" >> [ Attack ] >> "+unitList.get(first));
				if(unitList.get(first).hp<=0) unitList.remove(first);
			}
						
			System.out.println("---------------------------");
		}
		return String.format("최종 생존 : "+unitList.get(0));
	}

	private ArrayList init(ArrayList unitList) {
		unitList.add(new Marin());
		unitList.add(new SCV());
		unitList.add(new Wraith());
		unitList.add(new Tank());
		unitList.add(new DropShip());
		unitList.add(new BattleCruiser());
		unitList.add(new Medic());
		unitList.add(new FireBat());
		unitList.add(new Valkyrie());
		unitList.add(new Vulture());
		
		return unitList;
	}
	
}


public class _02스타크래프트 {

	public static void main(String[] args) {
		
		Run run = new Run();

	}

}
