package soultion.oom_longestCommonPrefix;

/**
 * 问题：找出n个字符串的最长公共前缀
 * @author hsj
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		String[] strings = {"flosh","flow","flight"};
//		String[] strings = {"dog","racecar","car"};
		System.out.println("-----------"+System.currentTimeMillis());
		System.out.println(longestCommonPrefix(strings));
		System.out.println("-----------"+System.currentTimeMillis());
		
	}
	
	public static String longestCommonPrefix(String[] strs) {
		
		if(strs == null || strs.length <= 0) {
			return "";
		}
        
		int i = 0;
		StringBuffer longestCommonPrefix = new StringBuffer();
		while(true) {
			if(strs[0].length() <= i) {
				break;
			}
			char c = strs[0].charAt(i);
			boolean isEnd = false;
			for(String str: strs) {
				if(str.length() <= i) {
					isEnd = true;
					break;
				}
				char cc = str.charAt(i);
				if(cc != c) {
					isEnd = true;
					break;
				}
			}
			if(isEnd) {
				break;
			}
			longestCommonPrefix.append(c);
			i++;
		}
		
		return longestCommonPrefix.toString();
    }
	
	public static String longestCommonPrefix_2(String[] strs) {
		
		if(strs == null || strs.length <= 0) {
			return "";
		}
		
		int minLength = Integer.MAX_VALUE;
		String minString="";
		for(String string: strs) {
			if(string.length() < minLength){
				minLength = string.length();
				minString = string;
			}
		}
		
		String longestCommonPrefix = minString;
		for(String str: strs) {
			
			int i=0;
			for(i=0; i<str.length()&&i<longestCommonPrefix.length(); i++) {
				if(str.charAt(i) != longestCommonPrefix.charAt(i)){
					break;
				}
			}
			longestCommonPrefix = longestCommonPrefix.substring(0, i);
		}
        
		return longestCommonPrefix;
    }
	
	public static String longestCommonPrefix_3(String[] strs) {
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;
	}
	
}
