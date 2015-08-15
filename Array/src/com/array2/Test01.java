package com.array2;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		int [][] a1 = {
					{1,2},
					{3,4,5},
					{6,7,8,9}
		}; 
		
		int [][] a2 = new int[3][];
		a2[0] = new int[2];
		a2[1] = new int[3];
		a2[2] = new int[4];
		a2[0][0] = 1;
		a2[0][1] = 2;
		a2[1][0] = 3;
		a2[1][1] = 4;
		a2[1][2] = 5;
		a2[2][0] = 6;
		a2[2][1] = 7;
		a2[2][2] = 8;
		a2[2][3] = 9;
		
		int [] a3 = {1,2,9,5,3,8,23,6};
		Arrays.sort(a3);
		System.out.println(Arrays.toString(a3));
		/*
		for(int i=0; i<a3.length; i++){
			System.out.println(a3[i]);
		}
		*/
		for(int n:a3) {
			System.out.println(n);
		}
		//Arrays.sort(a1);
//		System.out.println(Arrays.deepToString(a1));
		
//		System.out.println("查找元素"+Arrays.binarySearch(a3, 23));
	}
}
