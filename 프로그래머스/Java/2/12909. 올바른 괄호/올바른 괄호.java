import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(')
                stack.push(temp);
            else {
                if (stack.isEmpty())    return false;
                if (stack.pop() != '(') return false;
            }
        }
        
        if (stack.isEmpty())    return true;
        else                    return false;
    }
}