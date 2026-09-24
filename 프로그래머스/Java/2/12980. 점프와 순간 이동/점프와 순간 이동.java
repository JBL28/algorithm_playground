import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        int curr = n;
        while (curr != 1) {
            if (curr % 2 == 1) {
                ans++;
                curr--;
            }
            else
                curr/=2;
        }

        return ans+1;
    }
}