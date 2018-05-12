package soultion.ood_medianOfTwoSortedArray;

public class MedianOfTwoSortedArray {
	
	public static void main(String[] args) {
		//int nums1[] = {1, 3};
		//int nums2[] = {2};
		
		int nums1[] = {};
		int nums2[] = {2, 3};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
		
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int n1_length = nums1.length,n2_length = nums2.length;
		int n_length = n1_length + n2_length;
		
		int media_index = n_length / 2;
		int per_value = 0;
		
		int n1_index=0,n2_index=0,index=0;
		
		while(n1_index < n1_length && n2_index < n2_length) {
			
			int n1_value = nums1[n1_index];
			int n2_value = nums2[n2_index];
			
			if(index == media_index) {
				if(n_length % 2 == 0) {
					return n1_value < n2_value? (double)(n1_value+per_value)/2:(double)(n2_value+per_value)/2;
				} else {
					return n1_value < n2_value? n1_value:n2_value;
				}
			}
			
			if(n1_value < n2_value) {
				n1_index++;
				per_value = n1_value;
			} else {
				n2_index++;
				per_value = n2_value;
			}
			index++;
		}
		
		while(n1_index < n1_length) {
			int value = nums1[n1_index];
			if(index == media_index) {
				if(n_length % 2 == 0) {
					return (double)(value+per_value)/2;
				} else {
					return value;
				}
			}
			
			per_value = nums1[n1_index];
			index++;
			n1_index++;
			
		}
		
		while(n2_index < n2_length) {
			int value = nums2[n2_index];
			if(index == media_index) {
				if(n_length % 2 == 0) {
					return (double)(value+per_value)/2;
				} else {
					return value;
				}
			}
			
			per_value = nums2[n2_index];
			index++;
			n2_index++;
		}
		return 0;
    }

}
