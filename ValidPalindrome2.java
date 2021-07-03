// Given a string s, return true if the s can be palindrome after deleting at most one character from it.
// Example 1:
// Input: s = "aba"
// Output: true

// Example 2:
// Input: s = "abca"
// Output: true
// Explanation: You could delete the character 'c'.

// Example 3:
// Input: s = "abc"
// Output: false

// Constraints:
//     1 <= s.length <= 10^5
//     s consists of lowercase English letters.


class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return subPallindrome(s.substring(left, right)) || subPallindrome(s.substring(left+1, right+1));
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean subPallindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

// Time Complexity: O(n) and Space Complexity: O(1)
// Runtime: 9 ms, faster than 26.61% of Java online submissions for Valid Palindrome II.
// Memory Usage: 51.8 MB, less than 8.95% of Java online submissions for Valid Palindrome II.
