
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// Example 1:Input: s = "anagram", t = "nagaram"
//         Output: true

// Example 2: Input: s = "rat", t = "car"
//             Output: false

public class ValidAnagram {

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "abb";
        System.out.println(isAnagram(s1, s2));
    }

    // brute force TC:(N square (N^2))
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;
        boolean[] used = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean found = false;

            for (int j = 0; j < s.length(); j++) {
                if (!used[j] && ch == t.charAt(j)) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }

        return true;
    }

    // otpimize solution( TC:O(n) space:(1)(as 26 character are constant))

    public static boolean isAnagramOptimize(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int i : charCounts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}