/**
 * 
 */
package soultion.ooa_twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hsj
 *
 */
public class TwoSum_2 {
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = {1,2};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int cur=0; cur<nums.length; cur++) {
			int value = nums[cur];
			int sub = target - value;
			if(map.containsKey(sub)) {
				result[0] = map.get(sub);
				result[1] = cur;
				return result;
			} else {
				map.put(value, cur);
			}
		}
		throw new IllegalArgumentException();
	}

}
