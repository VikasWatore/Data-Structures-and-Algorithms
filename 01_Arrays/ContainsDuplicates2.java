// 219. Contains Duplicate II
// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Input: nums = [1,2,3,1], k = 3
// Output: true

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates2 {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        int k=3;
        System.out.println(cd(nums,k));
    }

    private static boolean cd(int[] nums, int k) {
        Set<Integer> set= new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);

            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
}
