import  java.util.*;

class Solution {
    int result = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        // 점화식? -> 같은 f(x)여도 어떤 던전을 선택하냐에 따라 경우의 수가 달라진다.
        // 동시에, 행별로 최적 루트를 저장하기에도, 앞으로 나올 던전에 따라 최적이 달라질 수 있다.
        // -> 완탐인듯?? 가지치기를 잘 해보자.
        // 뭐지 그럼 냅색이랑 다른게 순서까지 중요한디...
        // 하나씩 선택하면서 해당 던전이 탐색할 수 없는 상황이라면 스킵하도록 하면 가지치기가 되지 않을까?
        // 일단 해봐
        visited = new boolean[dungeons.length];
        search(0, k, dungeons);
        
        return result;
    }
    
    void search(int depth, int valueLeft, int[][] dungeons) {
        if (result < depth) result = depth;
        
        for (int i=0; i<dungeons.length; i++) {
            if(dungeons[i][0] <= valueLeft && !visited[i]) {
                visited[i] = true;
                search(depth+1, valueLeft-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }     
}