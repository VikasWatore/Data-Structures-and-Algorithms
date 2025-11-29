// 49. Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Explanation:
// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // List<List<String>> result = groupAnagrams(words);
        List<List<String>> result =groupAnagramsOptimize(words);

        // Print the result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    // brute force 🔹 Time Complexity: O(N × K log K)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // optimize approach 🔹 Time Complexity:O(NK)
    public static List<List<String>> groupAnagramsOptimize(String[] strs) {

        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        int[] count = new int[26];

        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append('#').append(count[i]);
            }

            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            return new ArrayList<>(map.values());
        }

        return new ArrayList<>(map.values());
    }
}
