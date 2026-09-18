class Solution {
    int[] list = new int[21];
    
    public int solution(int n) {
        // 2의 배수 배열 초기화
        list[0] = 1;
        for (int i=1; i<=20; i++) {
            list[i] = list[i-1]*2;
        }
        
        // n부터 1씩 증가시키며 2의 배수 문자열의 1의 개수를 계산하며 n과 비교해나감
        int curr = n+1;
        int target = getOnes(n);
        while(true) {
            if (target == getOnes(curr)) return curr;
            else curr++;
        }
    }
    
    int getOnes(int n) {
        int temp = n;
        int counter = 0;
        for (int i=20; i>=0; i--) {
            if (temp >= list[i]) {
                temp -= list[i];
                counter++;
            }
        }
        
        return counter;
    }
}