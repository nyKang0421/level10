package _12콜렉션멤버;

import java.util.Scanner;

public class Utils {
	
	private Utils() {};
	private static Utils instance;
	public static Utils getInstance() {
		if(instance == null) instance = new Utils();
		return instance;
	}
	
	private Scanner sc = new Scanner(System.in);
	
	public void pringMsg(String string) {
		System.out.println("["+string+"]");
		
	}
	public int getIntValue(String string, int start, int end) {
		System.out.printf("%s 선택 >> ",string);
		try {
			int num = sc.nextInt();
			if(isRange(start,end,num)) return -1;
			return num;
		}catch (Exception e) {
			System.out.println("숫자만 입력하세요");
			sc.nextLine();
			//e.printStackTrace();
		}
		return -1;
	}
	private boolean isRange(int start, int end, int num) {
		if(num< start || num > end) {
			printErr("선택 범위 오류");
			return true;
		}
		return false;
	}
	private void printErr(String string) {
		System.err.println("["+string+"]");
		
	}

}
