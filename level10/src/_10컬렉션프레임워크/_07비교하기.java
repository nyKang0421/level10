package _10컬렉션프레임워크;

import java.util.Comparator;
import java.util.TreeSet;

// comparable - 자신과 다른 객체 비교
// comparator - 주어진 두 객체 ==> treeSet, treeMap : 컬렉션 정렬 기준 활용

class Person implements Comparable<Person>{
	
	private static int lastNo = 0;
	private int no;
	private String name;
	private int age;
	

	Person(String name, int age) {
		this.no = ++lastNo;
		this.name = name;
		this.age = age;
	}
	
	


	public int getNo() {
		return no;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	@Override
	public int compareTo(Person o) {
		// return name.compareTo(o.name); // 이름순 출력
		if(no > o.no) { // 번호순 출력
			return 1;
		}else {
			return -1;
		}
	}


	@Override
	public String toString() {
		return String.format("no = %d , name = %s , age = %d \n", no,name,age);
	}
	
}

class PersonComp implements Comparator<Person>{
	enum SortBy{NO,NAME,AGE}
	enum SortDir{ASC, DESC}
	
	private SortBy sortBy;
	private SortDir sortDir;
	PersonComp(SortBy sortBy, SortDir sortDir) {
		super();
		this.sortBy = sortBy;
		this.sortDir = sortDir;
	}
	@Override
	public int compare(Person o1, Person o2) {
		
		int result = 0;
		switch(sortBy) {
		case NO : result = o1.getNo() > o2.getNo()? 1:-1; break;
		case NAME : result = o1.getName().compareTo(o2.getName());break;
		case AGE : result = o1.getAge() > o2.getAge()? 1:-1;break;
		}
		return result*(sortDir == sortDir.ASC ? 1:-1);
	}
	
	
}

public class _07비교하기 {

	public static void main(String[] args) {
		
		TreeSet<Person> treeSet = new TreeSet<>();
		
		Person[] pList = {
				new Person("홍길동", 20),
				new Person("전우치", 10),
				new Person("임꺽정", 28),
				new Person("스폰지밥", 32),
				new Person("뚱이", 18),
				new Person("개똥이", 23),
		};
		
		TreeSet[] treeSets = {
				new TreeSet<>(),
				new TreeSet<>(new PersonComp(PersonComp.SortBy.NO,PersonComp.SortDir.DESC)),
				new TreeSet<>(new PersonComp(PersonComp.SortBy.AGE,PersonComp.SortDir.ASC)),
				new TreeSet<>(new PersonComp(PersonComp.SortBy.NAME,PersonComp.SortDir.DESC)),
		};
		
		for(Person p : pList) {
			for(TreeSet ts : treeSets) {
				ts.add(p);
			}
		}
		System.out.println("================");
		
		for(TreeSet ts : treeSets) {
			for(Object p : ts) {
				System.out.println(p);
			}
			System.out.println("----------------");
		}
		
		
		System.out.println(treeSet);

	}

}
