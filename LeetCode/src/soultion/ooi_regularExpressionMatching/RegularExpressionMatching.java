package soultion.ooi_regularExpressionMatching;

/**
 * 正则表达式匹配
 * 问题：给定一个字符串s和正则表达式p，检测s是否匹配p，其中
 * 	s包含任意个a-z的字符，p包含a-z、*、.，*匹配0个或多个前面的元素，.匹配单个任意字符
 * 思路1:递归
 * 
 * 思路2:动态规划
 * 
 * @author hsj
 *
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		String s="aa";
		String p="a*";
		System.out.println(isMatchDp(s, p));
	}
	
	public static boolean isMatch(String s, String p) {
		if(p.isEmpty())
			return s.isEmpty();
		
		/*
		 * 检查第一个字符是否匹配
		 * 1 s空，false
		 * 2 s非空，当p和s的第一个字符相同或p的第一个字符为.时，true
		 */
		boolean first_match = (!s.isEmpty() &&
				(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
			
		/*
		 * 递归调用，分两种情况
		 * 
		 * 1 当p以c*(c为任意字符或.)开头时，分两种情况
		 * 	（1）first_match=true，则递归s.sub(1)和p是否匹配
		 *  （2）或者，s应该和p.sub(2)匹配
		 *  
		 * 2 否则，第一个字符应该匹配，继续递归后续字符
		 */
		if(p.length() >= 2 && p.charAt(1) == '*') {
			return (isMatch(s, p.substring(2))) ||
					(first_match && isMatch(s.substring(1), p));
		} else {
			return first_match && isMatch(s.substring(1), p.substring(1));
		}
		
    }
	
	/**
	 * 1 If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
	 * 2 If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
	 * 3 If p.charAt(j) == '*': here are two sub conditions:
           1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
           2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                  	   dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
               		or dp[i][j] = dp[i-1][j]   // in this case, a* counts as single a
                    or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatchDp(String s, String p) {
		if(s == null || p == null) {
			return false;
		}
		
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '*' && dp[0][i-1]){
				dp[0][i+1] = true;
			}
		}
		
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<p.length(); j++) {
				if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
					dp[i+1][j+1] = dp[i][j];
				} else if(p.charAt(j) == '*') {
					if(dp[i+1][j-1]) {	// a* used as null
						dp[i+1][j+1] = true;
					} else if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') {
						dp[i+1][j+1] = dp[i][j+1];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
    }
}
