package soultion.ooa_twoSum;

import java.util.Arrays;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author hsj
 *
 */
public class TwoSum_1 {
	public int[] twoSum(int[] numbers, int target) {
		int[] num = (int[]) numbers.clone();
		Arrays.sort(num);
		int size = num.length;
		int[] answer = new int[2];
		for(int i=0; i<size; i++) {
			if(Arrays.binarySearch(num, target-num[i]) > 0) {
				int count=0, index1=0, index2=0;
				for(int j=0; j<size; j++) {
					if(numbers[j] == num[i] || numbers[j] == target-num[i]) {
						count++;
						if(count == 2) {
							index2 = j;
							answer[0] = (index1<index2 ? index1 : index2)+1;
							answer[1] = (index1>index2 ? index1 : index2)+1;
							break;
						}else {
							index1 = j;
						}
					}
				}
			}
		}
		return answer;
		
	}
}
