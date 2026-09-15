import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == temp)
                stack.pop();
            else
                stack.push(temp);
        }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}