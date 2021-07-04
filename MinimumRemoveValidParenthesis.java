// Given a string s of '(' , ')' and lowercase English characters. 
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
// Formally, a parentheses string is valid if and only if:

//     It is the empty string, contains only lowercase characters, or
//     It can be written as AB (A concatenated with B), where A and B are valid strings, or
//     It can be written as (A), where A is a valid string.

// Example 1:
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:
// Input: s = "a)b(c)d"
// Output: "ab(c)d"

// Example 3:
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.

// Example 4:
// Input: s = "(a(b(c)d)"
// Output: "a(b(c)d)"

// Constraints:
//     1 <= s.length <= 10^5
//     s[i] is one of  '(' , ')' and lowercase English letters.

// Without String Builder
class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s.length()==1)
            return "";
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);   
            else if(s.charAt(i)==')'){
                if(stack.empty()){
                    s = s.substring(0, i) + s.substring(i+1, s.length());
                    i--;
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.empty()){
            int pos = stack.pop();
            s = s.substring(0, pos) + s.substring(pos+1, s.length());
        }
        return s;
    }
}

// Runtime: 28 ms, faster than 24.39% of Java online submissions for Minimum Remove to Make Valid Parentheses.
// Memory Usage: 40 MB, less than 38.33% of Java online submissions for Minimum Remove to Make Valid Parentheses.

// Using String Builder -> Better solution
class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s.length()==1)
            return "";
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length();i++){
            if(sb.charAt(i)=='(')
                stack.push(i);   
            else if(sb.charAt(i)==')'){
                if(stack.empty()){
                    sb.deleteCharAt(i);
                    i--;
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.empty()){
            int pos = stack.pop();
            sb.deleteCharAt(pos);
        }
        return sb.toString();
    }
}

// Runtime: 14 ms, faster than 84.76% of Java online submissions for Minimum Remove to Make Valid Parentheses.
// Memory Usage: 39.6 MB, less than 72.36% of Java online submissions for Minimum Remove to Make Valid Parentheses.
