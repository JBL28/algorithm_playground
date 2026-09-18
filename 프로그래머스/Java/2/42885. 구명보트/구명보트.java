import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int frontPointer = 0;
        int backPointer = people.length - 1;
        int result = 0;
        
        Arrays.sort(people);
        
        while (frontPointer <= backPointer) {
            if (frontPointer == backPointer) {
                result++;
                frontPointer++;
            }
            else if (people[frontPointer] + people[backPointer] <= limit) {
                result++;
                frontPointer++;
                backPointer--;
            }
            else {
                result++;
                backPointer--;
            }
        }

        return result;
    }
}
