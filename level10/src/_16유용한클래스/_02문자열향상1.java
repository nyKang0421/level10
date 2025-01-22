package _16유용한클래스;

public class _02문자열향상1 {

	public static void main(String[] args) {
		
		String str1 = "abc";
		String str2 = new String("abc");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		str1 +="def"; // new String("abcdef");
		System.out.println(System.identityHashCode(str1));
		
		// String => 읽기전용 배열 => 수정이 불가능하다 => 새로운 값으로 다시 할당
		
		// String Builder (싱글스레드), String Buffer (멀팃스레드)
		// 내부적으로 가변문자배열 char[]
		// 문자열 값이 자주 변경될때 용이하다.
		
		StringBuilder builder = new StringBuilder();
		System.out.println(System.identityHashCode(builder));
		builder.append("abc");
		System.out.println(System.identityHashCode(builder));
		builder.append("def");
		System.out.println(System.identityHashCode(builder));
		
		System.out.println(builder);
		
		//빌더 초기화
		builder.setLength(0);
		System.out.println("-----------------");
		System.out.println(builder);
		System.out.println("-----------------");

	}

}
