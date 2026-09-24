import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        int curr = 1;
        int[] result = new int[2];
        char last = words[0].charAt(0);
        
        for (int i=0; i<words.length; i++) {
            String s = words[i];
            
            if (set.contains(s) || s.charAt(0) != last) {
                result[0] = curr;
                result[1] = ((i+1)%n == 0) ? ((i+1) / n) : (((i+1) / n) + 1);
                return result;
            }
            
            set.add(s);
            curr = next(curr, n);
            last = s.charAt(s.length() - 1);
        }
        return result;
    }
    
    int next (int curr, int n) {
        if (curr == n) return 1;
        else return curr + 1;
    }
}