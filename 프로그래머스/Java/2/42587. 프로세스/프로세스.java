import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int maxPriority = 0;
        
        for (int i=0; i<priorities.length; i++) {
            // 프로세스 번호, 우선순위 순서
            int[] temp = {i, priorities[i]};
            queue.offer(temp);
            map.put(priorities[i], map.getOrDefault(priorities[i], 0)+1);
            if (maxPriority < priorities[i])
                maxPriority = priorities[i];
        }
        
        int polled = 0;
        while(true) {
            int[] temp = queue.poll();
            int currProcess = temp[0];
            int currPriority = temp[1];
            boolean isHigherExist = false;
            for (int i=currPriority+1; i<=maxPriority; i++) {
                if (map.containsKey(i)){
                    isHigherExist = true;
                    break;
                }
            }
            if (!isHigherExist) {
                System.out.println(currProcess+"("+currPriority+") : 우선순위가 더 큰 노드가 없음");
                if (map.get(currPriority) == 1) {
                    System.out.println("\t우선순위 큐에서 삭제");
                    map.remove(currPriority);
                }
                else{
                    System.out.println("\t우선순위 큐에서 카운트 -1");
                    map.put(currPriority, map.get(currPriority)-1);
                }
                polled++;
                if (currProcess == location) return polled;
            } else {
                System.out.println(currProcess+"("+currPriority+") : 우선순위가 더 큰 노드가 존재하여 offer");
                queue.offer(temp);
            }
        }
    }
}