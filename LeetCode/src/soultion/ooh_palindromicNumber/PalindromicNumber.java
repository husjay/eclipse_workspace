package soultion.ooh_palindromicNumber;

import soultion.utils.StringUtil;

/**
 * 题目：判断一个整数是否是回文数
 * 例如，121是，-2不是，13不是
 * 思路1：将整数转换为字符串，然后进行判断
 * 思路2：如果这个数x是回文数，那么 x/10 = x%10 
 * @author hsj
 *
 */
public class PalindromicNumber {
	
	public static void main(String[] args) {
		int x = 121;
		System.out.println(isPalindrome(x));
	}
	
	public static boolean isPalindrome(int x) {
        return StringUtil.isPalindromic(String.valueOf(x));
    }

}
