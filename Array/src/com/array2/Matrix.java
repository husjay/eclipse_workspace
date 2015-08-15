package com.array2;

public class Matrix {
	public static void main(String[] args) {
		int [][] a = {
				{1,3,6},
				{2,4,9},
				{5,2,7}
		};	
		int [][] b = {
				{5,3,9},
				{0,4,3},
				{5,1,8}
		};	
		int [][] c = add(a,b);
		print(c);
		
	}
	public static int[][] add(int[][] a, int[][] b) {
		int [][] c = new int[a.length][a.length];
		for(int i=0; i<a.length; i++) {
			for(int j=0; j <a.length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	public static void print(int [][] c) {
		for(int i=0; i<c.length; i++) {
			System.out.println();
			for(int j=0; j <c.length; j++) {
				System.out.print("\t"+c[i][j]);
			}
		}
	}
}
