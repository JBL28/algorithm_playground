import java.util.*;

class Solution {
    int[] result = {0,0};
    
    public int[] solution(String s) {
        String temp = s;
        while(!isComplete(temp)) {
            int stepOne = zeroOut(temp);
            temp = toBin(stepOne);
            result[0]++;
        }
        
        return result;
    }
    
    // 1이 몇개인지 세서 int로 리턴쓰
    public int zeroOut(String s) {
        int counter = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '0') result[1]++;
            else counter++;
        }
        
        return counter;
    } 
    
    // 자릿수 숫자를 이진수 바이너리 문자열로 바꿔야함
    public String toBin(int num) {
        // 처음 1이 나올 때부터 Queue에 '1' 또는 '0' 넣음
        // 2^0까지 왔다면 StringBuilder에 역순으로 집어넣기
        int[] binList = new int[19];
        int temp = 1;
        for (int i=0; i<19; i++) {
            binList[i] = temp;
            temp *= 2;
        }
        
        Queue<Character> queue = new ArrayDeque<>();
        boolean isStart = false;
        temp = num;
        for (int i=18; i>=0; i--) {
            if (isStart) {
                if (temp >= binList[i]) {
                    temp -= binList[i];
                    queue.offer('1');
                } else {
                    queue.offer('0');
                }
            } else if (temp >= binList[i]) {
                temp -= binList[i];
                queue.offer('1');
                isStart = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        
        return sb.toString();
    }
    
    // toBin 한 결과가 "1"인지 검사쓰
    public boolean isComplete(String s) {
        if (s.equals("1")) return true;
        else return false;
    }
}