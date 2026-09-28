import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        boolean[] isCompleted = new boolean[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();
        int SIZE = progresses.length;
        int completed = 0;
        
        while (!isCompleted[SIZE-1]) {
            int completes = 0;
            for (int i=completed; i<SIZE; i++) {
                progresses[i] += speeds[i];
                if (progresses[i] >= 100) {
                    if (i == 0) {
                        completes++;
                        completed = i+1;
                        isCompleted[i] = true;
                    }
                    else if (isCompleted[i-1]) {
                        completes++;
                        completed = i+1;
                        isCompleted[i] = true;
                    }
                }
            }
            
            if (completes != 0) 
                list.add(completes);
        }
        
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}