
package com.rodriguez;

public class Twosum
{
	public int[] twoSum(int[] nums, int target)
	{
		int[] ans = new int[2];
		int max = nums.length;
		for(int posA = 0; posA < max; posA++ ) {
			for(int posB = 0; posB < max - 1; posB++ ) {
				if( nums[posA] + nums[posB] == target ) {
					ans[0] = posA;
					ans[1] = posB;
					break;
				}
			} // for2
		} // for1
		return ans;
	}
}
