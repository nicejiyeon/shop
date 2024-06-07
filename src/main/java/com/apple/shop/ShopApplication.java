package com.apple.shop;

import jdk.jfr.Frequency;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);

		final String aa = "test";
		int bb = 20;
		var cc = "spring"; //java 10버전 이후부터 var사용가능, 변수타입 자동 지정, kotlin에서 종종 사용
		System.out.println(aa);
		
		var test = new Test(); //object: class에 있는 변수, 함수 복사본
		System.out.println(test.name);
		test.hello();

		var friend = new Friend("park");
		System.out.println(friend.name);

		//굳이 class를 사용 하는 이유
		//1. java는 class사용
		//2. 관련있는 변수, 함수 한 곳에 정리할 수 있음
		//3. 중요한 변수, 함수 원본 지킬 수 있음
	}

}

class Test { //변수, 함수 보관함
	String name = "kim"; //field, attribute
	void hello() { //method
		System.out.println("hello"); //sout 입력 후 enter하면 자동완성
	}
}

class Friend {
	String name = "kim";
	int age = 20;

	Friend(String param) { // constructor: class명과 동일한 method, new Friend() 할 때 자동 실행
		this.name = param;
	}
}