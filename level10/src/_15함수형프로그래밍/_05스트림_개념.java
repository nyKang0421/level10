package _15함수형프로그래밍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05스트림_개념 {
	
	public static void main(String[] args) {
		
		
		List<String> names = Arrays.asList("유재석","지석진","김종국","하하","송지효","양세찬","지예은","지석진");
		
		System.out.println("== 1 ============================");
		for(int i = 0; i<names.size();i+=1) {
			System.out.println(names.get(i));
		}
		
		System.out.println("== 2 ============================");
		for(String name : names) System.out.println(name);
		
		System.out.println("== 3 ============================");
		names.forEach(System.out::println);
		
		System.out.println("== 4 ============================");
		Stream<String> nameStream = names.stream(); // 리스트 names 스트림 객체 생성
		
		nameStream.forEach(System.out::println); // forEach는 최종연산이기 때문에 연산이 끝나면 스트림 닫힌다
		//nameStream.count(); // 이미 stream이 닫혔기 때문에 실행하면 에러 발생
		//
		
		System.out.println("== 5 ============================");
		names.stream() // 스트림 객체생성
		.distinct() // 중복제거 메서드 호출 : 중간연산
		.forEach(System.out::println); // 값 호출 최종연산
		
		List<String> copyNames = names.stream().distinct().collect(Collectors.toList());
		
		System.out.println(copyNames);
		
		copyNames.set(0, "재슥이");
		
		System.out.println(names);
		System.out.println(copyNames);
		
		System.out.println("-------------------------------------");
		
		List<Integer> list = new ArrayList<>(Arrays.asList(5,2,0,8,4,1,7,9,3,6));
		
		System.out.println(list);
		
		List<Integer> odds = new ArrayList<>();
		
		for(int i = 0; i<list.size(); i+=1) 
			if(list.get(i)%2 !=0) odds.add(list.get(i));
		
		System.out.println(odds);
		
		Collections.sort(odds);
		System.out.println(odds);
		
		String data = "";
		for(Integer i : odds)
			data += i+", ";
		data = data.substring(0,data.length()-2);
		
		System.out.println(data);
		
		System.out.println("-----------------------------");
		
		String result = list.stream()
						.filter(i -> i%2!=0)
						.sorted(Integer::compare)
						.map(i -> i+"")
						.collect(Collectors.joining(", "));
		
		System.out.println();
		
	}

}
