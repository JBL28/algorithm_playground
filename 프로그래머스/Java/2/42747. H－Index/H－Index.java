import java.util.*;

class Solution {
    
    public int solution(int[] citations) {
        int LENGTH = citations.length;
        int result = 0;
        
        Arrays.sort(citations);
        
        // 더블 이진탐색? -> H-index를 이진탐색하며 탐색하는데, 이 때 인용 수 h 이상인 논문을 이진탐색으로 탐색
        int MIN = 0;
        int MAX = citations[LENGTH-1];
        int MID = (MIN + MAX) / 2;
        int RESULT = 0;
        
        // h값을 찾기위한 outerSearch
        while (MIN < MAX) {
            int INNER_MIN = 0;
            int INNER_MAX = LENGTH-1;
            int INNER_MID = (INNER_MIN + INNER_MAX) / 2;
            int INNER_RESULT = 0;
            
            // MID 이상인 논문 수를 구해야 한다. innerSearch
            while(INNER_MIN < INNER_MAX) {
                if (MID <= citations[INNER_MID])
                    INNER_MAX = INNER_MID;
                else 
                    INNER_MIN = INNER_MID;
                INNER_MID = (INNER_MIN + INNER_MAX) / 2;
                
                if (INNER_MAX - INNER_MIN == 1){
                    INNER_RESULT = 
                        (MID <= citations[INNER_MIN]) ? INNER_MIN : INNER_MAX;
                    break;
                }
            }
            
            int BIGGER = LENGTH - INNER_RESULT;
            
            if (MID <= BIGGER)
                MIN = MID;
            else
                MAX = MID;
            MID = (MIN + MAX) / 2;
            
            if (MAX - MIN == 1){
                // MAX로 한번 더 innerSearch
                INNER_MIN = 0;
                INNER_MAX = LENGTH-1;
                INNER_MID = (INNER_MIN + INNER_MAX) / 2;
                INNER_RESULT = 0;
                while(INNER_MIN < INNER_MAX) {
                    if (MAX <= citations[INNER_MID])
                        INNER_MAX = INNER_MID;
                    else 
                        INNER_MIN = INNER_MID;
                    INNER_MID = (INNER_MIN + INNER_MAX) / 2;

                    if (INNER_MAX - INNER_MIN == 1){
                        INNER_RESULT = 
                            (MAX <= citations[INNER_MIN]) ? INNER_MIN : INNER_MAX;
                        break;
                    }
                }
                BIGGER = LENGTH - INNER_RESULT;
                if (MAX <= BIGGER)
                    RESULT = MAX;
                else
                    RESULT = MIN;
                break;
            }
        }
        
        return RESULT;
    }
}