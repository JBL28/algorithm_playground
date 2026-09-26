class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int)right - (int)left + 1];
        int LENGTH = (int)(right - left + 1);
        
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