package 스타업그레이드;

import java.util.ArrayList;
import java.util.Random;


//damage() 메서드를 가진
//Interface Damageable을 정의하고
//최하위 유닛들	(모든) 에게 Damageable 상속
//main에서 각각의 유닛들을 손상시킨 후 -> repair() 돌려보기

interface DamageableAll{ }
interface DamageableAir{ }
interface DamageableGround{ }
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
		int damageType = checkDamageType(this);
		if(damageType == 1) {
			def.hp -= damage;
			printAtkResult(this, def);
		}else if(damageType == 2) {
			if(isDefType(def)) {
				def.hp -= damage;
				printAtkResult(this, def);
			}
			else System.out.println(this+" ==> "+def+" 공격 불가");
				
		}else if(damageType == 3) {
			if(!isDefType(def)) {
				def.hp -= damage;
				printAtkResult(this, def);
			}
			else System.out.println(this+" ==> "+def+" 공격 불가");
			
		}else {
			int unitType = checkUnit(this);
			if(unitType == 1) {
				if(isType(def)) {
					def.hp += damage;
					printHealResult(this,def);
				}else {
					System.out.println(this+" ==> "+def+" 치료 불가");
				}
			}else if(unitType == 2) {
				if(!isType(def)) {
					def.hp += damage;
					printHealResult(this,def);
				}else {
					System.out.println(this+" ==> "+def+" 수리 불가");
				}
			}else {
				System.out.println(this+" ==> "+def+" 공격 불가");
			}
		}

	}
	
	void printAtkResult(Unit atk, Unit def) {
		if(def.hp<0) {
			def.hp = 0;
		}
		System.out.println(atk+" >> [ Attack ] >> "+def);
	}
	void printHealResult(Unit heal, Unit def) {
		if(def.hp>def.MAX_HP) {
			def.hp = def.MAX_HP;
		}
		System.out.println(heal+" >> [ Heal&Repair ] >> "+def);
	}

	private int checkUnit(Unit unit) {
		try {
			Medic check = (Medic) unit; 
			
			return 1;
		}catch(Exception e) {
			//e.printStackTrace();
		}
		
		try {
			SCV check = (SCV) unit; 
			
			return 2;
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return 0;
	}

	private boolean isType(Unit def) {
		try {
			Healable check = (Healable) def; 
			
			return true;
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return false;
	}

	private boolean isMedic(Unit unit) {
		try {
			Medic check = (Medic) unit; 
			
			return true;
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return false;
	}

	private boolean isDefType(Unit def) {
		try {
			AirUnit a = (AirUnit) def;
			
			return true;
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return false;
	}

	private int checkDamageType(Unit unit) {
		try {
			DamageableAll check = (DamageableAll) unit; 
			
			return 1;
		}catch(Exception e) {
			//e.printStackTrace();
		}
		
		try {
			DamageableAir check = (DamageableAir) unit; 
			
			return 2;
		}catch(Exception e) {
			//e.printStackTrace();
		}
		
		try {
			DamageableGround check = (DamageableGround) unit; 
			
			return 3;
		}catch(Exception e) {
			//e.printStackTrace();
		}
		//System.out.println("공격 불가");
		return 0;
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

class Marin extends GroundUnit implements DamageableAll,Healable{

	Marin() {
		super(150,10);
	}
	
	void DamageAll(Unit unit) {
		unit.hp -= damage;
	}
	
	@Override
	public String toString() {
		return String.format(" Marin (%d/%d)",hp,MAX_HP);
	}
	
}
class SCV extends GroundUnit implements DamageableGround,Repairable,Healable{
	
	SCV() {
		super(120,10);
	}
	
	void DamageAll(Unit unit) {
		unit.hp -= damage;
	}
	
	@Override
	public String toString() {
		return String.format(" SCV (%d/%d)",hp,MAX_HP);
	}
	
}
class Tank extends GroundUnit implements DamageableGround,Repairable{
	
	void DamageGround(Unit unit) {
		try {
			GroundUnit unitGround = (GroundUnit) unit;
			
			unitGround.hp -= damage;
			
		}catch(Exception e) {
			System.out.println("공격불가");
			//e.printStackTrace();
		}
	}

	Tank() {
		super(250,30);
	}
	
	@Override
	public String toString() {
		return String.format(" Tank (%d/%d)",hp,MAX_HP);
	}
	
}
class Vulture extends GroundUnit implements DamageableGround,Repairable{
	
	void DamageGround(Unit unit) {
		try {
			GroundUnit unitGround = (GroundUnit) unit;
			
			unitGround.hp -= damage;
			
		}catch(Exception e) {
			System.out.println("공격불가");
			//e.printStackTrace();
		}
	}
	
	Vulture() {
		super(200,20);
	}
	
	@Override
	public String toString() {
		return String.format(" Vulture (%d/%d)",hp,MAX_HP);
	}
	
}
class Wraith extends AirUnit implements DamageableAll{
	
	void DamageAll(Unit unit) {
		unit.hp -= damage;
	}

	Wraith() {
		super(200,20);
	}
	
	@Override
	public String toString() {
		return String.format(" Wraith (%d/%d)",hp,MAX_HP);
	}
	
}
class Valkyrie extends AirUnit implements DamageableAir{
	
	Valkyrie() {
		super(250,30);
	}
	
	@Override
	public String toString() {
		return String.format(" Valkyrie (%d/%d)",hp,MAX_HP);
	}
	
}
class DropShip extends AirUnit implements Repairable{

	DropShip() {
		super(250,0);
	}
	
	@Override
	public String toString() {
		return String.format(" DropShip (%d/%d)",hp,MAX_HP);
	}
}

class BattleCruiser extends AirUnit implements DamageableAll,Repairable{
	
	void DamageAll(Unit unit) {
		unit.hp -= damage;
	}

	BattleCruiser() {
		super(500,80);
	}
	
	@Override
	public String toString() {
		return String.format(" BattleCruiser (%d/%d)",hp,MAX_HP);
	}
	
}

class FireBat extends GroundUnit implements DamageableGround,Healable {
	
	void DamageGround(Unit unit) {
		try {
			GroundUnit unitGround = (GroundUnit) unit;
			
			unitGround.hp -= damage;
			
		}catch(Exception e) {
			System.out.println("공격불가");
			//e.printStackTrace();
		}
	}

	FireBat() {
		super(180,20);
	}
	
	@Override
	public String toString() {
		return String.format(" FireBat (%d/%d)",hp,MAX_HP);
	}
	
}

class Medic extends GroundUnit implements Healable{

	Medic() {
		super(150,10);
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
		System.out.println("=== [유닛 생성] ============");
		for(Unit u : unitList)
			System.out.println("[생성]"+u);
		System.out.println("==========================");
		System.out.println(Result(unitList));
	}

	private String  Result(ArrayList<Unit> unitList) {
		Random rd = new Random();
		while(unitList.size() > 1 ) {
			int first = rd.nextInt(unitList.size());
			int second = rd.nextInt(unitList.size());
			if(first == second) continue;
			unitList.get(first).attack(unitList.get(second));
			if(unitList.get(second).hp <= 0) unitList.remove(second);
			else {
				unitList.get(second).attack(unitList.get(first));
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


public class _업그레이드_스타크래프트 {

	public static void main(String[] args) {
		
		Run run = new Run();

	}

}
