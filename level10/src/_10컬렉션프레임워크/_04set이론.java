package _10컬렉션프레임워크;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class User2{
	String name;
	int age;
	User2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	/*
	@Override
	public String toString() {
		return name + "/" + age ;
	}
	*/
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User2 other = (User2) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}

public class _04set이론 {

	public static void main(String[] args) {
		
		Set<Integer> list1 = new HashSet<>();
		list1.add(1);
		list1.add(1);
		list1.add(2);
		list1.add(3); //[1,1,2,3]
		
		System.out.println(list1);
		
		Set<String> list2 = new HashSet<>(Arrays.asList("test1","test2","test3","test1"));
		
		System.out.println(list2.size());
		System.out.println(list2);
		
		//Set은 인덱스가 없기 때문에 데이터에 순서에 관련해서 값을 저장하는 순서를 우리가 정할 수 없다.
		//Set은 중복값이 들어가지 않는다.
		
		Set<Integer> intHashSet = new HashSet<>();
		Set<Integer> intLinkedHashSet = new LinkedHashSet<>();
		Set<Integer> intTreeSet = new TreeSet<>();
		
		for(int i : new int[] {20,12,30,100,3,1,8,5,4,7,2,9,6}) {
			intHashSet.add(i);
			intLinkedHashSet.add(i);
			intTreeSet.add(i);
		}
		
		Set[] list3 = new Set[] {intHashSet,intLinkedHashSet,intTreeSet};
		
		for(Set s : list3) {
			System.out.println(s);
		}
		
		Set<String> strHashSet = new HashSet<>();
		Set<String> strLinkedHashSet = new LinkedHashSet<>();
		Set<String> strTreeSet = new TreeSet<>();
		
		for(String i : new String[] {"Fox","Fox","Banana","iPone","Apple","BMW","Lotto"}) {
			strHashSet.add(i);
			strLinkedHashSet.add(i);
			strTreeSet.add(i);
		}
		
		Set[] list4 = new Set[] {strHashSet,strLinkedHashSet,strTreeSet};
		
		for(Set s : list4) {
			System.out.println(s);
		}
		
		Iterator<String> iterator = strHashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		Set<User2> userList = new HashSet<>();
		userList.add(new User2("test1",10));
		userList.add(new User2("test1",10));
		userList.add(new User2("test1",10));
		userList.add(new User2("test1",10));
		userList.add(new User2("test1",10));
		
		User2 user1 = new User2("test1",10);
		User2 user2 = new User2("test1",10);
		System.out.println(user1 == user2);
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(userList);

	}

}
