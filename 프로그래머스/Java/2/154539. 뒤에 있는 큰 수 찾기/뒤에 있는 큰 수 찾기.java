class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        int[] next = new int[n];

        for (int i=n-1; i>=0; i--) {
            int j = i+1;
            while (j != -1 && j < n && numbers[j] <= numbers[i])
                j = next[j];

            if (j == -1 || j == n) {
                next[i] = -1;
                answer[i] = -1;
            } else {
                next[i] = j;
                answer[i] = numbers[j];
            }
        }

        return answer;
    }
}