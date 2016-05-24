package com.ztest;

public class MyVector {
	
	protected Object[] data = null;
	protected int cap =0;
	protected int size =0;
	
	
	public  MyVector(int cap){
		if(cap < 0){
			System.out.println("유효하지않다.");
		}
		this.cap = cap;
		this.data = new Object[cap];
	}
	
	public  MyVector() {
		
		this.data = new Object[10];
		// 크기를 지정하지 않으면 크기를 10으로 한다.
		/* 다음의 코드를 완성하세요.
		1. 매개변수가 없는 생성자를 통해 MyVector를 생성한다면, 용량(capacity)가 10이 되도록 한
		다. 매개변수가 있는 생성자 MyVector(int capacity)를 사용하세요.
		 */
		}
		public boolean isEmpty() {
			
			if(this.data != null){
				return true;
			}
			return false;
		// MyVector가 비어있는지 확인한다.
		/* 코드를 완성하세요. */
		}
		public int capacity() {

			return this.data.length;
		// MyVector의 용량(크기)를 반환한다.
		/* 코드를 완성하세요. */
		}
		public int size() {
			
			return this.size;
		// MyVector에 저장된 객체의 개수를 반환한다.
		/* 코드를 완성하세요. */
		}
	
		
		public static void main(String args[]) {

			}

		
}
