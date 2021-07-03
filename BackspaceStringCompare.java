Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

// Note that after backspacing an empty text, the text will continue empty.
// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Example 2:
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".

// Example 3:
// Input: s = "a##c", t = "#a#c"
// Output: true
// Explanation: Both s and t become "c".

// Example 4:
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

// Constraints:
//     1 <= s.length, t.length <= 200
//     s and t only contain lowercase letters and '#' characters.

// Using Stack Data Structure built in Java (Alternatively, we can do it with two pointers)
import java.util.Stack;
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> first = findActualString(s);
        Stack<Character> second = findActualString(t);
        while(first.empty()!=true && second.empty()!=true){
            if(first.pop()!=second.pop()){
                return false;
            }
        }
        if(first.empty() && second.empty())
            return true;
        return false;
    }
    public static Stack<Character> findActualString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i)!='#'){
                stack.push(s.charAt(i));
            }
            else{
                if(!stack.empty()){
                    stack.pop();
                }
            }
        }
        return stack;
    }
}

// Time Complexity: O(n) and Space Complexity: O(a + b)
// Runtime: 1 ms, faster than 68.21% of Java online submissions for Backspace String Compare.
// Memory Usage: 37.2 MB, less than 56.82% of Java online submissions for Backspace String Compare.
