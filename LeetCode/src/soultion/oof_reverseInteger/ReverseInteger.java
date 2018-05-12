package soultion.oof_reverseInteger;

public class ReverseInteger {
	
	public static void main(String[] args) {
		int x = -123999990;
		
		System.out.println(reverse(x));
	}
	
	public static int reverse(int x) {
		
		String s = String.valueOf(x);
		String sign = "";
		if(s.charAt(0) == '-') {
			sign = "-";
			s = s.substring(1, s.length());
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=s.length()-1; i>=0; i--) {
			sb.append(s.charAt(i));
		}
		
		int result = 0;
		try {
			result = Integer.parseInt(sign+sb.toString());
		} catch (NumberFormatException e) {
		}
        
		return result;
    }

}
