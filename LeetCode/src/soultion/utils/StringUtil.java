package soultion.utils;

public class StringUtil {
	
	/**
	 * 字符串是否是回文串
	 * @param s
	 * @return
	 */
	public static boolean isPalindromic(String s) {
		if(s == null || s.length() <= 0) {
			return false;
		}
		
		for(int i=0,j=s.length()-1; i<j; i++,j--) {
			char c = s.charAt(i);
			char d = s.charAt(j);
			if(c != d) {
				return false;
			}
		}
		return true;
		
	}

}
