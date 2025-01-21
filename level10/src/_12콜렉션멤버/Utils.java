package _12콜렉션멤버;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Utils {
	
	private Utils() {};
	private static Utils instance;
	public static Utils getInstance() {
		if(instance == null) instance = new Utils();
		return instance;
	}
	
	private Scanner sc = new Scanner(System.in);
	private static final String CUR_PATH = System.getProperty("user.dir")+"\\src\\"+Utils.class.getPackageName()+"\\";
	private static final String filePath = CUR_PATH +"member.txt";
	
	
	public void printMsg(String string) {
		System.out.println("["+string+"]");
		
	}
	public int getIntValue(String string, int start, int end) {
		System.out.printf("%s[%d-%d] 입력 >> ",string,start,end);
		try {
			int num = sc.nextInt();
			sc.nextLine();
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
	public void printErr(String string) {
		System.err.println("["+string+"]");
		
	}
	public void closeScanner() {
		sc.close();
	}
	public String getStrValue(String string) {
		System.out.printf("%s 입력 >> ",string);
		String input = sc.nextLine();
		if(isCheckBlaEmp(input)) return null;
		return input;
	}
	public boolean isCheckBlaEmp(String input) {
		if(input.isBlank()||input.isEmpty()) {
			printErr("값이 입력 되지 않음");
			return true;
		}
		return false;
	}
	public void saveExcute(String data) {
		try(FileWriter fr = new FileWriter(filePath)){
			fr.write(data);
			printMsg("파일저장 성공");
		} catch (IOException e) {
			printErr("파일저장 실패");
			//e.printStackTrace();
		}
	}
	public String loadExcute() {
		String data = "";
		try(FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr)){
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				data += line+"\n";
			}
		} catch (FileNotFoundException e) {
			printErr("파일찾기 실패");
			//e.printStackTrace();
		} catch (IOException e) {
			printErr("파일읽기 실패");
			//e.printStackTrace();
		}
		return data;
	}
	
	

}
