import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int[] counter = new int[want.length];
        
        int FRUITS = 0;
        int result = 0;
        
        // String to index를 위한 Map
        for (int i=0; i<want.length; i++) {
            FRUITS += number[i];
            map.put(want[i], i);
        }
        
        // 초기 윈도우 FRUITS개
        for (int i=0; i<FRUITS; i++) {
            int index = map.getOrDefault(discount[i], -1);
            if (index != -1)
                counter[index]++;
        }
        
        if (check(number, counter)) result++;
        
        for (int i=FRUITS; i<discount.length; i++) {
            int past_index = map.getOrDefault(discount[i-FRUITS], -1);
            int curr_index = map.getOrDefault(discount[i], -1);
            if (past_index != -1)
                counter[past_index]--;
            if (curr_index != -1)
                counter[curr_index]++;
            
            if (check(number, counter)) result++;
        }
        
        return result;
    }
    
    boolean check(int[] number, int[] counter) {
        for (int i=0; i<number.length; i++) 
            if (number[i] != counter[i])
                return false;
        return true;
    }
}