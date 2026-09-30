import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque queue = new ArrayDeque<>();
        int answer = 0;
        
        if (cacheSize == 0)
            return cities.length * 5;
        
        for (int i=0; i<cities.length; i++) {
            if (queue.size() < cacheSize && !queue.contains(cities[i].toUpperCase())){
                queue.offer(cities[i].toUpperCase());
                answer += 5;
            } else if (queue.size() < cacheSize && queue.contains(cities[i].toUpperCase())) {
                answer += 1;
                queue.remove(cities[i].toUpperCase());
                queue.offer(cities[i].toUpperCase());
            } else if (queue.size() == cacheSize && !queue.contains(cities[i].toUpperCase())) {
                answer += 5;
                queue.poll();
                queue.offer(cities[i].toUpperCase());
            } else {
                answer += 1;
                queue.remove(cities[i].toUpperCase());
                queue.offer(cities[i].toUpperCase());
            }
        }
        
        return answer;
    }
}