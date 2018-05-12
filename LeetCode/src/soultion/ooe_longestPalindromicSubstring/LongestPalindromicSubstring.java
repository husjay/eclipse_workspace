package soultion.ooe_longestPalindromicSubstring;
/**
 * 问题：查找一个字符串中最长回文子序列
 * 思路1:遍历该字符串，以每个字符为中心找出最长回文序列
 * 		该算法的时间复杂度是O(n^2)
 * 思路2:将该字符串反转，求反转后字符串和原字符串的最长公共子序列，即为最长回文子序列
 * 		这里有一问题，例如字符串abbafhkdhfabbauk，反转后的字符串为kuabbafhdkhfabba，
 * 		它们的最长子串为abbafh，但这并不是一个回文串，要解决这个问题，就要在找出最长
 * 		字串后判断是不是回文字符串
 * 		时间复杂度是O(n)
 * @author hsj
 *
 */
public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		
		String s = "ccc";
		System.out.println(longestPalindrome_1(s));
		
	}
	
	public static String longestPalindrome_1(String s) {
        
		if(s.length() <= 0) {
			return s;
		}
		
		String longestPalindrome = "";
		for(int i=0; i<s.length(); i++) {
			int left = i-1;
			int right = i+1;
			while(left>-1 && right<s.length() && s.charAt(left)==s.charAt(right)) {
				left--;
				right++;
			}
			left++;
			right--;
			if(right-left+1 > longestPalindrome.length()) {
				longestPalindrome = s.substring(left, right+1);
			}
		}
		
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i) != s.charAt(i+1)) {
				continue;
			}
			int left = i;
			int right = i+1;
			while(left>-1 && right<s.length() && s.charAt(left)==s.charAt(right)) {
				left--;
				right++;
			}
			left++;
			right--;
			if(right-left+1 > longestPalindrome.length()) {
				longestPalindrome = s.substring(left, right+1);
			}
		}
		
		return longestPalindrome;
    }
	
	private static String LCS(String s1, String s2) {
		
		int[][] matrix = new int[s1.length()][s2.length()];
		
		int max_i = 0,max_j = 0;
		int max_length = 0;
		
		for(int i=0; i<s1.length(); i++) {
			char c1 = s1.charAt(i);
			for(int j=0; j<s2.length(); j++) {
				char c2 = s2.charAt(j);
				if(c1 == c2) {
					int p = 0;
					if(i-1<s1.length() && i-1>=0 && j-1<s2.length() && j-1>=0) {
						p = matrix[i-1][j-1];
					}
					matrix[i][j] = p + 1;
					if(matrix[i][j] > max_length) {
						max_length = matrix[i][j];
						max_i = i;
						max_j = j;
					}
				} else {
					matrix[i][j] = 0;
				}
			}
		}
		
		return s1.substring(max_i-max_length+1, max_i+1);
	}
	
	
	
	private String reverse(String s) {
		StringBuffer res = new StringBuffer();
		for(int i=s.length(); i>=0; i--) {
			res.append(s.charAt(i));
		}
		return res.toString();
	}
	
	private boolean isPalindrom(String s) {
		if(s == null || s.length() <= 0) {
			return false;
		}
		
		for(int i=0,j=s.length(); i<j; i++,j--) {
			char c = s.charAt(i);
			char d = s.charAt(j);
			if(c != d) {
				return false;
			}
		}
		return true;
	}

}
