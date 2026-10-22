import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> parsed = parse(s);
        boolean[] visited = new boolean[100001];
        parsed.sort((a, b) -> Integer.compare(a.size(), b.size()));
        
        int[] answer = new int[parsed.get(parsed.size()-1).size()];
        
        int inserted = 0;
        for (int i=0; i<parsed.size(); i++) {
            for (int temp : parsed.get(i)) {
                if (!visited[temp]) {
                    visited[temp] = true;
                    answer[inserted++] = temp;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static List<List<Integer>> parse(String s) {
        List<List<Integer>> result = new ArrayList<>();

        String[] groups = s.substring(2, s.length() - 2).split("\\},\\{");

        for (String group : groups) {
            List<Integer> list = new ArrayList<>();

            for (String num : group.split(",")) {
                list.add(Integer.parseInt(num));
            }

            result.add(list);
        }

        return result;
    }
}