import java.util.*;

class Solution {
    // 얼핏 보면 queue써서 넣었다 뺐다 하는게 빠를 것 같은데 그냥 시작 index 관리하는게 빠를 듯
    public int solution(String s) {
        int STRING_SIZE = s.length();
        int result = 0;
        
        for (int i=0; i<STRING_SIZE; i++) {
            int temp_index = i;
            Deque<Character> deque = new ArrayDeque<>();
            
            for (int j=0; j<STRING_SIZE; j++) {
                char peek = '*';
                if (!deque.isEmpty()){
                    peek = deque.peekLast();
                    if (isMatch(peek, s.charAt(temp_index)))
                        deque.pollLast();
                    else
                        deque.add(s.charAt(temp_index));
                }
                else
                    deque.add(s.charAt(temp_index));
                temp_index = next(temp_index, STRING_SIZE);
            }
            
            if (deque.isEmpty()) result++;
        }
        
        return result;
    }
    
    int next(int curr, int size) {
        if (curr+1 != size)
            return curr + 1;
        else
            return 0;
    }
    
    boolean isMatch(char a, char b) {
        if (a == '[' && b == ']') return true;
        if (a == '{' && b == '}') return true;
        if (a == '(' && b == ')') return true;
        return false;
    }
}