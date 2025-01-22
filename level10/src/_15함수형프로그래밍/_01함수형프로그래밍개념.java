package _15함수형프로그래밍;

//함수형 프로그래밍에 사용할 인터페이스 조건!! => 단 하나의 추상메서드만 존재해야한다.

@FunctionalInterface // 인터페이스 내에 한가지 추상메서드만 존재하도록 확인 하는 코드
interface Test{
	int getSum(int[] arr);
	//void printSomthing();
}


public class _01함수형프로그래밍개념 {
	
	public static int getSum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++ ) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		//명령형 프로그래밍 : how : 과정 : 10-60까지 합산
		int[] arr = {10,20,30,40,50,60};
		int sum = 0;
		for(int i = 0; i < arr.length; i++ ) {
			sum += arr[i];
		}
		System.out.println(sum);

		System.out.println("======================");
		
		// 선언형 프로그래밍 : 함수형 => 결과 집중
		System.out.println(getSum(arr));
		
		System.out.println("======================");
		
		// 내부 클래스 == 이너클래스 ==> 익명클래스 : 이름이 없는 클래스 => 일회성 클래스
		Test result = new Test() {

			@Override
			public int getSum(int[] arr) {
				int sum = 0;
				for(int i = 0; i < arr.length; i++ ) {
					sum += arr[i];
				}
				return sum;
			}
			
		};
		
		System.out.println(result.getSum(arr));
		
		System.out.println("======================");
		
		// 람다식 => 자바스크립트의 화살표 함수
		// 함수형 프로그래밍을 편하게 사용하는 방식
		
		Test result2 = (int[] array) ->{
			int hap = 0; // int sum 사용시 외부 변수와 변수 명이 겹쳐 사용 불가
			for(int i = 0; i < array.length; i++ ) {
				hap += arr[i];
			}
			return hap;
		};
		System.out.println(result2.getSum(arr));
		
		// 이미 만들어진 익명클래스 접근 할때 (매개변수) -> 안에 불러올 함수; 매개변수가 하나일때는 괄호 없이 사용 가능
		Test result3 = array -> result2.getSum(arr); // 이미 result2에서 만들어지 메서드를 사용 , 
													//매개변수가 array 하나라 ()없이 사용 있으면 ()안에 모두 적어준다.
		System.out.println(result3.getSum(arr));
		
	}

}
