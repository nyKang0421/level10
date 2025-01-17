package Zombie;

public class Zombie extends Unit {

	public Zombie(String name, int pos, int hp, int power) {
		super(name, pos, hp, power);
	}
	
	public void Recover(int recovery) {
		System.out.printf("좀비가 %d 체력을 회복합니다 [ %d / %d ]\n",recovery, getHp(),getMAX_HP());
		setHp(recovery+getHp()); 
	}

}
