package _09제네릭클래스;

import java.util.Arrays;

class MyArrayList<T>{
	private T[] arr;
	private int capacity = 10;
	private int size = 0;
	
	MyArrayList(){
		//arr = new T[capacity]; // 제네릭클래스로 배열 선언을 할 수 없다!!
		arr = (T[]) new Object[capacity];
	}
	public void print() {
		System.out.println(Arrays.toString(arr));
	}
	
	public int size() {
		return size;
	}
	public int capacity() {
		return capacity;
	}
	public void add(T d) {
		if(size == capacity) extend();
		arr[size++] = d;
	}
	@Override
	public String toString() {
		String data = "";
		for(int i = 0; i<size; i++) {
			data += arr[i]+", ";
		}
		data = data.length()==0? "": data.substring(0,data.length()-2);
		return "["+data+"]";
	}
	public String get(int i) {
		if(isIndexCheck(i)) return "";
		
		return arr[i]+"";
	}
	public void set(int i, T d) {
		arr[i] = d;
		if(isIndexCheck(i+1)) return;
	}
	
	public void remove(int i) {
		if(isIndexCheck(i)) return;
		
		for(int k = i; k<size-1; k++) {
			arr[k] = arr[k+1];
		}
		arr[--size] = null;
		if(size != 0 && size%10 == 0) reduce();
	}
	private void reduce() {
		capacity -= 10;
		T[] temp = arr;
		arr = (T[]) new Object[capacity];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = temp[i];
		}
	}
	public void clear() {
		arr = (T[]) new Object[capacity];
		size = 0;
	}
	public void add(int i, T d) {
		if(isIndexCheck(i+1)) return;
		
		if(size == capacity) extend();

		for(int k = size; k>i;k--) {
			arr[k] = arr[k-1];
		}
		arr[i] = d;
		size++;
	}
	
	private boolean isIndexCheck(int i) {
		if(i>=size) {
			System.out.print("인덱스 범위 오류!");
			return true;
		}
		return false;
	}
	private void extend() {
		capacity += 10;
		T[] temp = arr;
		arr = (T[]) new Object[capacity];
		for(int i = 0; i<temp.length; i++) {
			arr[i] = temp[i];
		}
	}
	
	
	
}

public class _02어레이리스트구현 {
	public static void main(String[] args) {
		MyArrayList<Double> list1 = new MyArrayList();
		//list1.print();
		
		MyArrayList<Double> list2 = new MyArrayList();
		//list2.print();
		
		
		MyArrayList<Double>	v1 = new MyArrayList<>();
		
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
		for(int i = 0; i<10; i+=1) {
			v1.add((i+1) * 10 *1.0);
		}
		
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1.get(1));
		
		v1.set(1,1000.0);
		System.out.println(v1);
		
		v1.add(1,20.0);
		System.out.println(v1);
		
		v1.remove(3);
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
		v1.clear();
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
	}

}
