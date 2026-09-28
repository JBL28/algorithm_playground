import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        
        Map<Integer, Integer> mapOne = new HashMap<>();
        Map<Integer, Integer> mapTwo = new HashMap<>();
        
        for (int i=0; i<topping.length; i++) {
            mapTwo.put(topping[i], mapTwo.getOrDefault(topping[i], 0)+1);
        }
        
        for (int i=0; i<topping.length; i++) {
            if (mapTwo.getOrDefault(topping[i], 0) < 2)
                mapTwo.remove(topping[i]);
            else
                mapTwo.put(topping[i], mapTwo.get(topping[i])-1);
            
            mapOne.put(topping[i], mapOne.getOrDefault(topping[i], 0)+1);
            
            if (mapOne.size() == mapTwo.size())
                result++;
        }
        
        return result;
    }
}