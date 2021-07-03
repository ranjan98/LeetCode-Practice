// Given a string s, find the length of the longest substring without repeating characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Example 4:
// Input: s = ""
// Output: 0

// Constraints:
//     0 <= s.length <= 5 * 10^4
//     s consists of English letters, digits, symbols and spaces.

// One approach is as always, brute force approach -> Time Complexity: O(n^2) and Space Complexity: O(n)
import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        for(int i=0; i<s.length(); i++){
            HashMap<Character, Boolean> subString = new HashMap<>();
            int currentLength = 0;
            for(int j=i; j<s.length(); j++){
                if(subString.get(s.charAt(j))==null){
                    subString.put(s.charAt(j), true);
                    currentLength++;
                    longestLength = Math.max(longestLength, currentLength);
                }
                else{
                    break;
                }
            }
        }
        return longestLength;
    }
}
// Approach - Sliding Window -> O(n)
import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        int left = 0;
        HashMap<Character, Integer> subString = new HashMap<>();
        for(int right=0; right<s.length(); right++){
            if(subString.get(s.charAt(right))==null){
                subString.put(s.charAt(right), right);
            }
            else{
                int previouslySeen = subString.get(s.charAt(right));
                if(previouslySeen >= left){
                    left = previouslySeen + 1;
                }
                subString.put(s.charAt(right), right);  
            }
            longestLength = Math.max(longestLength, right-left + 1);
        }
        return longestLength;
    } 
}

// Runtime: 5 ms, faster than 78.18% of Java online submissions for Longest Substring Without Repeating Characters.
// Memory Usage: 38.9 MB, less than 77.78% of Java online submissions for Longest Substring Without Repeating Characters.
