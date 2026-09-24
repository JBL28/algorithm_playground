import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        // 모든 길이에 대해
        for (int i=1; i<=elements.length; i++) {
            // 모든 elements의 시작 지점에 대해
            for (int j=0; j<elements.length; j++) {
                //부분수열 합 구하기
                int sum = 0;
                int curr = j;
                for (int k=0; k<i; k++) {
                    sum += elements[curr];
                    curr = next(curr, elements);
                }
                set.add(sum);
            }
        }

        return set.size();
    }
    
    int next(int curr, int[] elements) {
        if (curr+1 == elements.length) return 0;
        else return curr+1;
    }
}