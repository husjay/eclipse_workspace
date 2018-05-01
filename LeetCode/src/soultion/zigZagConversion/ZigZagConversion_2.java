/**
 * 
 */
package soultion.zigZagConversion;

/**
 * @author hsj
 *
 */
public class ZigZagConversion_2 {
	
	public static void main(String[] args) {
		System.out.println(convert("ABCD", 2));
	}
	
	public static String convert(String s, int numRows) {
		int len = s.length();
		if(len==0 || numRows<=1) {
			return s;
		}
		
		StringBuffer result = new StringBuffer();
		int cyc = 2 * numRows - 2;
		for(int cur=0; cur<numRows; cur++) {
			for(int curC=cur; curC<len; curC+=cyc) {
				result.append(s.charAt(curC));
				if(cur>0 && cur<numRows-1) {
					int t = curC + cyc - 2 * cur;
					if(t < len) {
						result.append(s.charAt(t));
					}
				}
			}
		}
		return result.toString();
	}

}
