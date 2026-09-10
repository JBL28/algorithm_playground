import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int size = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<size; i++) {
            int j = size - i - 1;
            answer += A[i]*B[j];
        }
        
        System.out.println(answer);

        return answer;
    }
}