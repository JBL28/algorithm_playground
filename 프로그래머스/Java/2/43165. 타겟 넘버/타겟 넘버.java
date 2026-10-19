class Solution {
    public int solution(int[] numbers, int target) {
        int NUMBERS_LENGTH = numbers.length;
        int result = 0;
        
        for (int i=0; i<(1<<NUMBERS_LENGTH); i++) {
            int mask = 1;
            int sum = 0;
            
            for (int j=0; j<NUMBERS_LENGTH; j++) {
                if ( (i & mask) != 0 ) {
                    sum += numbers[j];
                } else {
                    sum -= numbers[j];
                }
                mask *= 2;
            }
            if (sum == target)
                result++;
        }
        return result;
    }
}