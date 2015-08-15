package com.array;

public class TestString {
	public static void main(String[] args) {
		String str1 = new String("abcd");
		System.out.println(str1.charAt(2));
		String str2 = new String("abcd");
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
		
		String str3 = "def";
		String str4 = "def";
		System.out.println(str3.equals(str4));
		System.out.println(str3 == str4);
		
		System.out.println(str3.indexOf('e'));
		System.out.println(str3.substring(1));
		
		String str5 = str3.replace('e', '*');
		System.out.println(str5);
		
		String str6 = "abcd,dfe,hdjdj";
		String[] strArray = str6.split(",");
		for(int i=0; i<strArray.length; i++)
			System.out.println(strArray[i]);
		
		String str7 = "  aa  bb  ";
		String str8 = str7.trim();
		System.out.println(str8);
		
		System.out.println("Abc".equalsIgnoreCase("abc"));
		System.out.println("abcbd".indexOf('b'));
		System.out.println("abcbd".startsWith("ab"));
		System.out.println("abcbd".endsWith("bd"));
		System.out.println("AbcBd".toLowerCase());
		System.out.println("abcbd".toUpperCase());
		
		String s = "abc";
		for(int i=0; i<10; i++)
			s += i;
		System.out.println(s);
		
		
	}
	
}
