package soultion.oon_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题：找出n个整数中三个和为0的所有组合
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 	满足要求的三元组集合为：
 *	[[-1, 0, 1],[-1, -1, 2]]
 *
 * 思路：
 * @author hsj
 *
 */
public class _3sum {

	public static void main(String[] args) {
		
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
		
		int[] numss = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(numss, target));
		
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i=0; i< nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i-1]){
				continue;				
			}
			int lo = i + 1, hi = nums.length-1;
			int target = -nums[i];
			while(lo < hi) {
				if(nums[lo] + nums[hi] == target) {
					result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					lo++;
					hi--;
					while(lo<hi && nums[lo]==nums[lo-1])lo++;
					while(lo<hi && nums[hi]==nums[hi+1])hi--;
				} else if(nums[lo]+nums[hi] > target){
					hi--;
				} else {
					lo++;
				}
			}
		}
		
		return result;
    }
	
	public static int threeSumClosest(int[] nums, int target) {
		int result = nums[0]+nums[1]+nums[2];
		Arrays.sort(nums);
		for(int i=0; i< nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i-1]){
				continue;				
			}
			int lo = i + 1, hi = nums.length-1;
			while(lo < hi) {
				int sum = nums[lo] + nums[hi] + nums[i];
				if(Math.abs(result - target) > Math.abs(sum - target)) {
					result = sum;
					if(result == target){
						return result;
					}
				}
				if(sum > target){
					hi--;
				} else {
					lo++;
				}
			}
		}
		
		return result;
    }
	
}
