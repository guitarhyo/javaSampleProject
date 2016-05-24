package com.ztest;

public class test {

public static void main(String[] args) {
	Goods goods1 = new Goods("콜라", 1000);
	Goods goods2 = new Goods("맥콜", 2000);
	Goods goods3 = new Goods("사이다", 3000);
	
	System.out.println("Goods company : "+Goods.company);
	System.out.println("goods1 : "+goods1.name);
	System.out.println("goods2 : "+goods2.name);
	System.out.println("goods3 : "+goods3.name);
	
	Goods.company="L";
	System.out.println("Goods company : "+Goods.company);
	
	MyVector v = new MyVector();
	System.out.println("size:"+v.size());
	 System.out.println("capacity:"+v.capacity());
	System.out.println("isEmpty:"+v.isEmpty());
//	Shop shop = new Shop(goods1, goods2, goods3);
//	System.out.println(shop.total);
}
	


}
