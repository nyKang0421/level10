package _17쓰레드;

class Thread1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 1; i<= 20; i+=1) {
			try {
				Thread.sleep(300);// 0.3초 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("1");
		}
		
	}
	
}

class myRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i<= 20; i+=1) {
			try {
				Thread.sleep(300);// 0.3초 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("2");
		}
		
	}
	
}

public class _01쓰레드이론01 {
	
	// 동기적 : 메모리 호출 순서로 순차적으로 실행 => 현재 실행하는걸 멈추고 호출된거 실행
	// 비동기적 : 호출될때 다른곳에서 실행, 현재 실행하는 것을 멈추지않는다
	
	public static void main(String[] args) {
		
		System.out.println("메인 쓰레드 영역");
		
		//쓰레드 상속받은 클래스 생성
		Thread thread1 = new Thread1();
		
		//러너블 구현해서 만든 클래스 생성
		Thread thread2 = new Thread(new myRunnable());
		
		//thread1.start(); // 쓰레드를 생성하고 실행하는 메서드 => .start()
		//thread2.start();
		/*
		for(int i = 1; i<= 20; i+=1) {
			try {
				Thread.sleep(300);// 0.3초 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("M");
		}
		*/ // 메인 안에서는 동기적으로 작용하기 때문에 아래 코드는 위 for문이 끝나야 실행된다.
		// 쓰레드 구문 아래 for문이 있어야 동시에 실행
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1; i<= 20; i+=1) {
					try {
						Thread.sleep(300);// 0.3초 멈춤
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.print("3");
				}
				
			}
		});
		
		Thread thread4 = new Thread(()->{
			for(int i = 1; i<= 20; i+=1) {
				try {
					Thread.sleep(300);// 0.3초 멈춤
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("4");
			}
		}
		);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		for(int i = 1; i<= 20; i+=1) {
			try {
				Thread.sleep(300);// 0.3초 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("M");
		}
		
	}

}
