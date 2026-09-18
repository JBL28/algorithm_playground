import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int a : people)
            list.add(a);
        list.sort((Integer a, Integer b) -> Integer.compare(a, b));
        
        int frontPointer = 0;
        int backPointer = people.length - 1;
        int result = 0;
        System.out.println(list.toString());
        
        while (frontPointer <= backPointer) {
            if (frontPointer == backPointer) {
                result++;
                frontPointer++;
            }
            else if (list.get(frontPointer) + list.get(backPointer) <= limit) {
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