

// Runtime: 174 ms, faster than 6.20% of Java online submissions for Valid Palindrome.
// Memory Usage: 40.1 MB, less than 30.96% of Java online submissions for Valid Palindrome.
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for(int i=0; i<s.length();i++)
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))
                str += s.charAt(i);
        return pointersFromOutside(str);
    }
    public static boolean pointersFromOutside(String s){
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

// Runtime: 174 ms, faster than 6.20% of Java online submissions for Valid Palindrome.
// Memory Usage: 40 MB, less than 30.96% of Java online submissions for Valid Palindrome.
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for(int i=0; i<s.length();i++)
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))
                str += s.charAt(i);
        return pointersFromCenter(str);
    }
    public static boolean pointersFromCenter(String s){
        int left = s.length()/2;
        int right = left;
        if(s.length()%2 == 0)
            left--;
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left--;
            right++;
        }
        return true;
    }
}
