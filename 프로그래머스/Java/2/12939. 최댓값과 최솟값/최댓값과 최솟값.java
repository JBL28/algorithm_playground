import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int temp = 0;
        
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        
        while(st.hasMoreTokens()){
            temp = Integer.parseInt(st.nextToken());
            
            if (temp < min)
                min = temp;
            if (temp > max)
                max = temp;
        }
        
        sb.append(min).append(" ").append(max);

        return sb.toString();
    }
}
