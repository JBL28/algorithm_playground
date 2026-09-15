class Solution {
    // (짝수 : n/2, 홀수 : n/2+1)부터 1까지 내려가면서 검사
    // 6 -> 3까지 검사 7 -> 4까지 검사
    public int solution(int n) {
        int result = 0;
        int curr;
        
        if (n == 1) return 1;
        if (n%2 == 0)   curr = n/2;
        else            curr = n/2 + 1;
        
        while (curr > 0) {
            int temp = curr;
            int sum = 0;
            while (! (temp<0 || sum>n)) {
                sum += temp;
                if (sum == n) {
                    result++;
                    break;
                }
                temp--;
            }
            curr--;
        }
        
        // 숫자 본인도 포함되어야 하기 때문에 1 덧셈
        return result+1;
    }
}