/**
 * 
 */
package soultion.zigZagConversion;

/**
 * @author hsj
 *
 */
public class ZigZagConversion_1 {
	
	public static void main(String[] args) {
		System.out.println(convert("ABCD",2));
	}
	
	public static String convert(String s, int numRows) {
		int len = s.length();
		if(len==0 || numRows<=1) {
			return s;
		}

		String[] result = new String[numRows];
		for(int cur=0; cur<numRows; cur++) {
			result[cur]="";
		}
		int row = 0;
		int added=1;
		for(int cur=0; cur<len; cur++) {
			result[row] += s.charAt(cur);
			row += added;
			if(row >= numRows) {
				row = numRows -2;
				added = -1;
			}
			if(row < 0) {
				row = 1;
				added = 1;
			}
		}
		
		String ret = "";
		for(int cur=0; cur<numRows; cur++) {
			ret += result[cur];
		}
		return ret;
        
    }

}
