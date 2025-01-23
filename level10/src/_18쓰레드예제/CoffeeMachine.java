
package _18쓰레드예제;

public class CoffeeMachine {
	final int CUP_MAX = 10;
	int cups = CUP_MAX;
	private static boolean isOff = false;

	static void turnOff() {
		isOff = true;
	}

	synchronized public void takeout(CustomerRun customer) {

		if (isOff) {
			Thread.currentThread().interrupt();
			return;
		}

		if (cups < 1) {
			System.out.printf("[%d] (ㅠ ^ ㅜ)  %s 커피 없음%n", cups, customer.name);
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("=== 영업 종료 === bye~ ");
			}

			System.out.printf("[%d] (O ^ O)a %s 테이크아웃%n", cups, customer.name);
			cups--;
		}
		
		if (isOff) {
			Thread.currentThread().interrupt();
			return;
		}
		
		
		notifyAll();
		try {
			if(!isOff)wait();
		} catch (InterruptedException e) {
		}
		
	}

	synchronized public void fill() {

		if (isOff) {
			Thread.currentThread().interrupt();
			return;
		}

		if (cups > 3) {
			System.out.printf("[%d] (^ * ^)! 재고 여유 있음...%n", cups);
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			System.out.printf("[%d] ✅ 커피 채워넣음%n", cups);
			cups = CUP_MAX;
		}
		
		notifyAll();
		try {
			if(!isOff)wait();
		} catch (InterruptedException e) {
		}
		
	}
}