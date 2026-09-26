class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowSize = arr1.length;
        int colSize = arr2[0].length;
        
        int[][] answer = new int[rowSize][colSize];
        
        for (int row=0; row<rowSize; row++)
            for (int col=0; col<colSize; col++)
                for (int index=0; index<arr1[0].length; index++)
                    answer[row][col] += arr1[row][index] * arr2[index][col];
        
        return answer;
    }
}