package _17쓰레드;

import java.text.SimpleDateFormat;
import java.util.Scanner;

class StopWatch implements Runnable{
	
	private int time; // 소요시간 출력

	public void run() {
		System.out.println("[q] quit [h] hold [x] return");
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		System.out.println("아무키나 누르면 시작합니다");
		while(true) {
			try {
				if(InputMachine.input == 'h' || InputMachine.input == 0 ) {
					Thread.sleep(1);
					continue;
				}
				Thread.sleep(1000);
				time +=1;
				if(InputMachine.input == 'x') {
					System.out.printf("소요시간 : %d분 %d초\n",time/60,time%60);
					return;
				}
				if(InputMachine.input == 'q') {
					System.out.println("종료");
					return;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(sdf.format(System.currentTimeMillis())+" ["+time+" sec]");
		}
	}
}

class InputMachine implements Runnable{
	
	private Scanner sc = new Scanner(System.in);
	public static char input;
	
	
	public void run() {
		System.out.println(">>>>");
		while(true) {
			String s = sc.nextLine();
			if(s.length() == 1) {
				input = s.charAt(0);
			}
			if(input == 'h') System.out.println("일시정지");
			if(input == 'q' || input == 'x') {
				sc.close();
				return;
			}
		}
	}
	
	
}



public class _05쓰레드실습 {

	public static void main(String[] args) {
		/*
		long preTime = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		System.out.println(sdf.format(preTime));
		*/
		
		Thread input = new Thread(new InputMachine());
		Thread stopWatch = new Thread(new StopWatch());
		
		System.out.println("input");
		System.out.println("stopWatch");
		input.start();
		stopWatch.start();
	
	}

}
