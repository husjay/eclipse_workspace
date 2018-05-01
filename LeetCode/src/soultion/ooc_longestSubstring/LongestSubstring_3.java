package soultion.ooc_longestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 求s的最长公公字串，并且字串不能有重复的字符
 * 思路1:从第一个字符开始找出最长字串，然后从第二个、第三个...，最后取最长的。
 * 思路2:借助hashmap，遍历字符串，hashmap中记录当前字符最新的索引index，对于当前字符:
 * 如果hashmap中没有，则cur_length+1
 * 如果hashmap中有，则cur_length=index-start+1(start记录cur_length计数开始位置)
 * @author hsj
 *
 */
public class LongestSubstring_3 {
	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0)
			return 0;
		
		int start = 0, index = 0;
		int curr_length = 0, max_length = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while(index < s.length()) {
			Character curr_char = s.charAt(index);
			int prev_index = -1;
			if(map.containsKey(curr_char)) {
				prev_index = map.get(curr_char).intValue();
			}
			if(prev_index < start) {
				map.put(curr_char, index);
				curr_length++;
				if(curr_length > max_length) {
					max_length = curr_length;
				}
			} else {
				start = prev_index;
				curr_length = index - start;
				map.put(curr_char, new Integer(index));
			}
			index++;
		}
		return max_length;    
	}
}
