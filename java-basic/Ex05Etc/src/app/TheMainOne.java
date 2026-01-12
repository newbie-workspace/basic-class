package app; // 이 클래스가 소속되는 패키지 선언.

import pa.suba.TheClassTwo; // 이후에 나타나는 TheClassTwo 는 pa.suba.TheClassTwo 이다.
import java.util.Scanner;

public class TheMainOne { // public class 는 반드시 파일 이름과 같다.

	public static void main(String[] args) {
		
		// 1. 패키지에 포함된 클래스를 사용하려면 패키지 이름도 명시해야 한다.
		// TheClassOne o = new TheClassOne(); -> 오류
		pa.TheClassOne o = new pa.TheClassOne();
		
		// 2. 패키지 이름은 import 구문을 통해 생략할 수 있다.
		// pa.suba.TheClassTwo o2 = new pa.suba.TheClassTwo();
		TheClassTwo o2 = new TheClassTwo();
		
		 Scanner s = new Scanner(System.in);

		 // 3. public 이 아닌 클래스 사용
		 // pa.subb.TheClassThree o3 = new pa.subb.TheClassThee(); -> 오류
		 // -> pa.subb 에서만 가능. pa 에서도 사용 불가.
	}

}


class OtherClass {
	// 같은 파일에 여러 개의 class를 만들 수는 있지만,  
	// public class 는 한개만 만들 수 있음.
	// public class 는 반드시 파일 이름과 같아야 하기 때문.	
}