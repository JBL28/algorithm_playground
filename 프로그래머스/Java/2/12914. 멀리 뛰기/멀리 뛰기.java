class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long[] results = new long[n+1];
        results[1] = 1;
        results[2] = 2;
        
        for (int i=3; i<=n; i++) {
            results[i] = (results[i-1] + results[i-2]) % 1234567;
        }
        
        return results[n] % 1234567;
    }
}