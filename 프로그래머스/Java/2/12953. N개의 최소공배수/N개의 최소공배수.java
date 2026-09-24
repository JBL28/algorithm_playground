class Solution {
    public int solution(int[] arr) {
        int result=1;
        
        for (int i=0; i<arr.length; i++) {
            result = LCM(result, arr[i]);
        }
        
        return result;
    }
    
    int GCD (int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a%b);
    }
    
    int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
}