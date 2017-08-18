import java.util.*;

/**
 * Created by jordi on 8/17/2017.
 * Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 ************* Answer
 ****   Iterate through the array with "j"
 *      If the character on the string is not found on the hashmap of <char, index>:
 *          Compute the maximum between the count and the result of subtracting j-i
 *      Else:
 *          Assign "i" to the maximum between i and the index of the the character
 */
public class LongestSubstringNoRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), count = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);              // Determine where is the repeated character, and assign i to that character
            }
            count = Math.max(count, j - i + 1);                     // Maximum of the count of the string
            map.put(s.charAt(j), j + 1);                            // Placing the character on the hashmap
        }
        return count;
    }
}
