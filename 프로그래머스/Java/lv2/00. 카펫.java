class Solution {
    public int[] solution(int brown, int yellow) {
        int brown_temp = (brown - 4) / 2;
        int[] result = new int[2];
        
        for (int i=0; i<=brown_temp/2; i++) {
            if (i * (brown_temp-i) == yellow) {
                result[0] = Math.max(i, brown_temp-i) + 2;
                result[1] = Math.min(i, brown_temp-i) + 2;
                return result;
            }
        }
        
        return result;
    }
}
