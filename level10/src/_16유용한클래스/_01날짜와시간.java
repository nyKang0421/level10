package _16유용한클래스;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class _01날짜와시간 {

	public static void main(String[] args) {
		
		//1970년 1월 1일 0시 기준으로 현재까지 경과한 시간 1000분의 1(밀리세커드) 로 반환값
		System.out.println(System.currentTimeMillis());
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalTime nowTime = LocalTime.now();
		System.out.println(nowTime);
		
		System.out.println(Clock.systemDefaultZone());
		
		LocalDate tomorrow = today.plusDays(100);
		System.out.println(tomorrow);
		LocalDate tempDate = today.minusYears(10);
		System.out.println(tempDate);
		
		// 두 날짜 사이의 간격
		LocalDate test1 = LocalDate.of(2030, 5, 5);
		Period test2 = Period.between(test1,today);
		System.out.printf("%d년 %d월 %d일\n", test2.getYears(), test2.getMonths(), test2.getDays());
		
		Duration test3 = Duration.between(LocalDateTime.of(2025,01,22,13,12), LocalDateTime.of(2025,01,23,13,6));
		System.out.println(test3);
		System.out.println(test3.toDays());
		System.out.println(test3.toHours());
		System.out.println(test3.toMinutes());
		
		// 날짜 원하는 스트링 값으로 환산
		
		DateTimeFormatter sdf1 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		LocalDateTime today2 = LocalDateTime.now();
		System.out.println(today2);
		System.out.println(today2.format(sdf1));
		
		DateTimeFormatter sdf2 = DateTimeFormatter.ofPattern("yy년 MM월 dd일 E요일 a HH:mm:ss");
		System.out.println(today2.format(sdf2));
		
		// String -> 날짜객체
		String nowData = "2025-01-22";
		DateTimeFormatter sdf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate time = LocalDate.parse(nowData, sdf3);
		System.out.println(time);

	}

}
