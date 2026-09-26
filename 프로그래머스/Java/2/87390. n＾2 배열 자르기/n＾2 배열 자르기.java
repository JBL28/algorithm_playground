class Solution {
    public int[] solution(int n, long left, long right) {
        int LENGTH = (int)(right - left + 1);
        int[] result = new int[LENGTH];
        
        for (int i=0; i<LENGTH; i++) {
            int row = (int)((left+i) / n);
            int col = (int)((left+i) % n);
            
            if (row >= col)
                result[i] = row + 1;
            else
                result[i] = col + 1;
        }
        
        return result;
    }
}