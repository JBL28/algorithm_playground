class Solution {
    public int solution(int n) {
        int[] list = new int[n+1];
        list[0] = 0;
        list[1] = 1;
        
        if (n == 0) return 0;
        if (n == 1) return 0;
        
        for (int i=2; i<=n; i++) {
            list[i] = (list[i-2] + list[i-1]) % 1234567;
        }
        
        return list[n];
    }
}