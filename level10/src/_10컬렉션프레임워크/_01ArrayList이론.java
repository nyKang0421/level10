package _10컬렉션프레임워크;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 컬렉션 프레임워크 : 데이터 저장 알고리즘을 이미 만든 클래스모음집

class User implements Comparable<User>{
	String name;
	int age;
	User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name+"/"+age;
	}
	@Override
	public int compareTo(User o) {
		//return name.compareTo(o.name); // 이름 차순
		
		// 나이가 같으면 이름 빠른 순으로 정렬
		if(age > o.age) { // 나이가 많은 순
			return -1;
		}else {
			return 1;
		}
		/*
		if(age > o.age) { // 나이가 적은 순
			return 1;
		}else {
			return -1;
		}
		*/
	}
	
}

public class _01ArrayList이론 {
	public static void main(String[] arg) {
		ArrayList<Integer> list1 = new ArrayList();
		System.out.println(list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(list2);
		ArrayList<Integer> list3 = (ArrayList<Integer>) list2.clone(); // 깊은 복사 해주는 메서드
		System.out.println(list3);
		System.out.println(list2 == list3);
		
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("홍길동",30));
		list.add(new User("둘리",5));
		list.add(new User("스폰지밥",10));
		list.add(new User("뚱이",12));
		list.add(new User("또치",5));
		list.add(new User("김길순",25));
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		
	}

}
