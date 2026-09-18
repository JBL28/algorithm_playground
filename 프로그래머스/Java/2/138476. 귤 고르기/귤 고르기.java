import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // Map에 개수를 표시
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> Integer.compare(b, a));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e.getValue());
        }
        int sum = 0;
        int result = 0;
        while (sum < k) {
            result++;
            sum += pq.poll();
        }
        
        return result;
    }
}