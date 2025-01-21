package _11Object클래스;

class Bag{
	String contains;

	Bag(String contains) {
		this.contains = contains;
	}

	@Override
	public String toString() {
		return "[ " + contains + " ]";
	}
	
	
}

class Person implements Cloneable{
	String name;
	int age;
	Bag bag;
	
	Person(String name, int age, Bag bag) {
		super();
		this.name = name;
		this.age = age;
		this.bag = bag;
	}

	@Override
	public String toString() {
		return name + " : " + age + " : " + bag;
	}
	
	public Person clone() {
		try {
			Object obj = super.clone();
			return (Person) obj;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}

public class _02클론 {

	public static void main(String[] args) {
		
		Bag bag1 = new Bag("갤럭시탭");
		Bag bag2 = new Bag("맥북");
		
		bag1.contains = "아이패드";
		
		Person p1 = new Person("홍길동", 10, bag1);
		
		//Person p2 = p1; // 얕은 복사
		Person p2 = p1.clone(); // 깊은 복사
		
		//p2.bag = bag2;
		p2.name = "둘리";
		System.out.println(p1);
		System.out.println(p2);

	}

}
