// 217. Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Example 1:

// Input: nums = [1,2,3,1]

// Output: true

// Explanation:

// The element 1 occurs at the indices 0 and 3.

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
     public static void main(String[] args) {
        int[] nums={1,2,3,4};

       System.out.println( cons_dup(nums));
       System.out.println(cons_Dupli(nums));
     }

     // bruteForce TC: O(n^2)=(n Square);
     public static boolean cons_dup(int[] arr){
       
        for (int i = 0; i < arr.length; i++) {
            int first=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(first==arr[j]){
                    return true;
                }
            }
        }
       return false;
     }


     // with hashset

     public static boolean cons_Dupli(int[] arr){
              Set<Integer> set=new HashSet<>();

              for (int i = 0; i < arr.length; i++) {
                int num=arr[i];

                if(set.contains(num)){
                    return true;
                }else{
                    set.add(arr[i]);
                }
              }
       
        return false;
     }
}
