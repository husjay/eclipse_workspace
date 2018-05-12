package soultion.ook_integerToRoman;

public class IntegerToRoman {
	
	public static void main(String[] args) {
		
		int[] aa = {3,4,9,58,1994};
		for(int i: aa) {
			System.out.println(intToRoman(i));
		}
		
		
	}
	
	public static String intToRoman(int num) {
        
		StringBuffer roman = new StringBuffer();
		
		int t = num/1000;
		if(t > 0) {
			for(int i=0; i<t; i++)
				roman.append("M");
			num = num - t * 1000;
		}
		
		
		t = num / 100;
		if(t == 9) {
			roman.append("CM");
			num = num - 900;
		} else {
			t = num / 500;
			if(t > 0) {
				for(int i=0; i<t; i++)
					roman.append("D");
			}
			num = num - t * 500;
		}
		
		t = num / 100;
		if(t == 4) {
			roman.append("CD");
			num = num - 400;
		} else {
			t = num / 100;
			if(t > 0) {
				for(int i=0; i<t; i++)
					roman.append("C");
			}
			num = num - t * 100;
		}
		
		t = num / 10;
		if(t == 9) {
			roman.append("XC");
			num = num - 90;
		} else {
			t = num / 50;
			if(t > 0) {
				for(int i=0; i<t; i++)
					roman.append("L");
			}
			num = num - t * 50;
		}
		
		t = num / 10;
		if(t == 4) {
			roman.append("XL");
			num = num - 40;
		} else {
			t = num / 10;
			if(t > 0) {
				for(int i=0; i<t; i++)
					roman.append("X");
			}
			num = num - t * 10;
		}
		
		t = num / 1;
		if(t == 9) {
			roman.append("IX");
			num = num - 9;
		} else {
			t = num / 5;
			if(t > 0) {
				for(int i=0; i<t; i++)
					roman.append("V");
			}
			num = num - t * 5;
		}
		
		t = num / 1;
		if(t == 4) {
			roman.append("IV");
			num = num - 4;
		} else {
			t = num / 1;
			if(t > 0) {
				for(int i=0; i<t; i++)
					roman.append("I");
			}
			num = num - t * 1;
		}
		
		return roman.toString();
    }
	
	

}
