package org.login.tester;

public class A {
	public enum Data{
		MON,TUE,WED,THUR,FRI,SAT,SUN,HHH
	}
	
	public static void main(String[] args) {
	
		Data[] aa = Data.values();
		
		System.out.println(aa[5]);
		
		

	}

}
