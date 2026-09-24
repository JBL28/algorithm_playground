class Solution
{
    public int solution(int n, int a, int b)
    {
        int[] aRoute = new int[21];
        int[] bRoute = new int[21];
        aRoute[0] = 1;
        bRoute[0] = 1;
        
        // A 탐색
        int term = n/2;
        int index = 1;
        while (true) {
            if (term != 1) {
                aRoute[index] = 
                    (aRoute[index-1]+term <= a) ? (aRoute[index-1]+term) : aRoute[index-1];
                index++;
                term /= 2;
            }
            else {
                aRoute[index] = a;
                break;
            }
        }
        
        // B 탐색
        term = n/2;
        index = 1;
        while (true) {
            if (term != 1) {
                bRoute[index] = 
                    (bRoute[index-1]+term <= b) ? (bRoute[index-1]+term) : bRoute[index-1];
                index++;
                term /= 2;
            }
            else {
                bRoute[index] = b;
                break;
            }
        }

        int firstZero = index + 1;
        for (int i=0; i<20; i++) {
            if (aRoute[i] != bRoute[i]) {
                return firstZero - i;
            }
        }

        return -1;
    }
}