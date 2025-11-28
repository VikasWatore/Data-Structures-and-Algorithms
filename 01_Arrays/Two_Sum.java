// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]


import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };

        int target = 9;
        int[] ans = twoSum(nums, target);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    // brute Force Approach when array is sorted
    public static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int fi = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int se = arr[j];
                if ((fi + se) == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    // sorted array with binary Search
    public static int[] twoSumBS(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                break;
            }
            int fi = arr[i];
            int rem = target - fi;

            int sec = bs(arr, rem, 0, arr.length);
            if (sec != -1) {
                return new int[] { i, sec };
            }
        }
        return new int[] {};
    }

    // binary Search
    public static int bs(int[] arr, int target, int start, int end) {
        if (end > start) {
            return -1;
        }
        int mid = (start + (end - start)) / 2;
        if (target == mid) {
            return mid;
        } else if (target > mid) {
            bs(arr, target, mid + 1, end);
        } else {
            bs(arr, target, start, mid - 1);
        }

        return 0;
    }

    // with hashMap

    public static int[] twoSumwithHashMap(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = target - arr[i];
            if (map.containsKey(rem)) {
                return new int[] { map.get(rem), i };
            }
            map.put(arr[i], i);
        }
        return new int[] {};
    }

}
