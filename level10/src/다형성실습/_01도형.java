package 다형성실습;

import java.util.Random;

abstract class Shape {
	String name;
	String color;
	double size;

	Shape(String name, String color, int size) {
		this.name = name;
		this.color = color;
		//this.size = size;
	}

	abstract void draw();

	@Override
	public String toString() {
		draw();
		return String.format("%s %s (%.2f)", color, name, size);
	}
	
}

class Line extends Shape {

	Line(String name, String color, int size) {
		super(name, color,size);
		super.size = size;
	}

	@Override
	void draw() {
		System.out.println("선을 긋는다 ");
	}

}

class Point extends Shape {

	Point(String name, String color, int size) {
		super(name, color,size);
	}

	@Override
	void draw() {
		System.out.println("점을 찍는다");
	}

}

class Circle extends Shape {

	int radius;

	Circle(String name, String color, int radius) {
		super(name, color,0);
		this.radius = radius;
		size = 3.14*this.radius*this.radius;
	}

	@Override
	void draw() {
		System.out.println("원을 그린다");

	}

}

class Rect extends Shape {

	int height;
	int width;

	Rect(String name, String color, int height, int width){
		super(name, color, height*width);
		size = height*width;
	}

	@Override
	void draw() {
		System.out.println("네모를 그린다");

	}

}

class Triangle extends Shape {

	int height;
	int width;
	
	Triangle(String name, String color, int height, int width ) {
		super(name, color, 0);
		this.height = height;
		this.width = width;
		size = this.height * this.width * 0.5;
	}

	@Override
	void draw() {
		System.out.println("세모를 그린다");

	}
}

public class _01도형 {
	public static void main(String[] args) {
		
		// 모양도 랜덤하게 색깔 사이즈 랜덤해게 도형 10개를 출력하세요
		// 점 , 선 기존 size 출력
		// 원, 네모, 세모 => size 넓이를 계산해서 출력
		
		Random rd = new Random();

		String[] colors = { "파란색", "빨간색", "보라색", "분홍색", "노란색" };

		Shape[] list = new Shape[10];
		for(int i = 0; i<list.length; i++) {
			int sel = rd.nextInt(5);
			int color = rd.nextInt(5);
			if(sel == 0) {
				list[i] = new Line("선",colors[color],rd.nextInt(9)+1);
				
			}else if(sel == 1) {
				list[i] = new Point("점",colors[color],0);
				
			}else if(sel == 2) {
				list[i] = new Circle("원",colors[color],rd.nextInt(9)+1);
				
			}else if(sel == 3) {
				list[i] = new Rect("네모",colors[color],rd.nextInt(9)+1,rd.nextInt(9)+1);
				
			}else if(sel == 4) {
				list[i] = new Triangle("세모",colors[color],rd.nextInt(9)+1,rd.nextInt(9)+1);
				
			}
			
		}
		System.out.println("=== 랜덤 출력 =====");
		for(Shape s : list)
			System.out.println(s);
		System.out.println();
		
		int idx = 0;
		for(Shape s : list) {
			int color = rd.nextInt(5);
			list[idx++] = new Circle("원",colors[color],rd.nextInt(9)+1);
		}
		
		System.out.println("=== 원만 출력 =====");
		for(Shape s : list)
			System.out.println(s);
	}

}
