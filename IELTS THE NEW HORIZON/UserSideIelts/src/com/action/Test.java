package com.action;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] = new int[5];
		Set<Integer> set = new HashSet<Integer>();
		for (int j = 0; j < 5; j++)
		{
			s[j] = (int) (Math.random() * 10);
			set.add(s[j]);
		}
		System.out.println("After----");
		for (int i = 0; i < s.length; i++) {
			System.out.println("I : "+s[i]);
			
		}
		System.out.println("After Set == "+set.size());
		for (Integer integer : set) {
			System.out.println("Set : "+integer);
		}
	}

}
