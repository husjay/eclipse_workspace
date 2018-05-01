package soultion.StringToInteger;

public class StringToInteger {
	
	public static void main(String[] args) {
		System.out.println(myAtoi("-11919730356x"));
		//2147483647
	}
	
	public static int myAtoi(String str) {
		if(str == null || str.trim() =="") {
			return 0;
		}
		StringBuffer s = new StringBuffer();
		String t = "";
		String reg = "^[0-9]";
		for(int cur=0; cur<str.length(); cur++) {
			t += str.charAt(cur);
			if(t.equals("-") || t.equals("+")) {
				s.append(t.trim());				
			} else {
				if(t.matches(reg)) {
					s.append(t.trim());	
				} else if(!t.trim().equals("")) {
					break;
				} else if(t.trim().equals("")) {
					if(s.length()>0) {
						break;
					}
				}
			}
			t="";
		}
		Long result = 0L;
		String ss = s.toString();
		if(s.length() > 12) {
			ss = s.substring(0, 13);
		}
        try {
			result = Long.parseLong(ss);
		} catch (NumberFormatException e) {
			
		}
        
        if(result<-2147483648) return -2147483648;
        if(result>2147483647) return 2147483647;
        return result.intValue();
    }
	
	public static int myAtoi1(String str) {
		long cur=0;//初始化老是忘记
	    int num=0,i=0;
	    int flag1=0,flag2=0;
	    while(i<str.length() && str.charAt(i)==' ') {
	    	i++;//开头空格舍弃
	    }
	    if(i<str.length() && str.charAt(i)=='-') {
	    	flag1++;
	    	i++;
	    } else if(i<str.length() && str.charAt(i)=='+') {
	    	flag2++;
	    	i++;
	    }
	    for(; i<str.length(); i++)
	    {
	        if(str.charAt(i)>='0' && str.charAt(i)<='9')
	        {
	            if(flag1==2)
	            {
	                cur=cur*10-(str.charAt(i)-'0');//这里是减法，因为cur符号是负号了
	                if(cur<-2147483648) return -2147483648;
	            }
	            else if(flag1==1) {
	            	cur=-str.charAt(i)+'0';
	            	flag1++;//将负数的符号记录到cur里
	            }
	            else
	            {
	                cur=cur*10+(str.charAt(i)-'0');
	                if(cur>2147483647) return 2147483647;
	            }
	        }
	        else break;
	    }
	    num=(int)cur;
	    return num;
	}

}
