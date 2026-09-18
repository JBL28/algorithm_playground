class Solution {
    public String solution(String s) {
        char temp;
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<s.length(); i++) {
            temp = s.charAt(i);
            
            if (isFirst && temp != ' '){
                sb.append(Character.toUpperCase(temp));
                isFirst = false;
            }
            else if (!isFirst && temp != ' '){
                sb.append(Character.toLowerCase(temp));
            }
            else {
                sb.append (' ');
                isFirst = true;
            }
        }
        
        return sb.toString();
    }
}