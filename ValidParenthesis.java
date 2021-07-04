// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
//     Open brackets must be closed by the same type of brackets.
//     Open brackets must be closed in the correct order.

// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

// Example 4:
// Input: s = "([)]"
// Output: false

// Example 5:
// Input: s = "{[]}"
// Output: true

// Constraints:
//     1 <= s.length <= 10^4
//     s consists of parentheses only '()[]{}'.

// Using Stack => Time Complexity => O(n), Space Complexity => O(n)
class Solution {
    public boolean isValid(String s) {
        if(s.length()<=1)
            return false;
        HashMap<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put('{', '}');
        parenthesis.put('(', ')');
        parenthesis.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            
            if(parenthesis.get(s.charAt(i))!=null)
                stack.push(s.charAt(i));
            else if(!stack.empty())
            {
                if(s.charAt(i)!=parenthesis.get(stack.pop()))
                    return false;
            }   
            else
                return false;
        }
        if(!stack.empty())
            return false;
        return true;
    }
}

// Runtime: 1 ms, faster than 98.69% of Java online submissions for Valid Parentheses.
// Memory Usage: 37.1 MB, less than 70.58% of Java online submissions for Valid Parentheses.
