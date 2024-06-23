import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(String word) {

        Map<Character, Integer> map = new HashMap<>();
        
        map.put('A', 1);
        map.put('E', 2);
        map.put('I', 3);
        map.put('O', 4);
        map.put('U', 5);
        
        int answer = 0;
        
        for(int i = 0; i < word.length(); i++) {
            answer += (map.get(word.charAt(i)) - 1) * getPow(i) + 1;
        }

        return answer;
    }
    
    private int getPow(int index) {
        int cnt = 0;
        
        for(int i = 0; i <= 4 - index; i++) {
            cnt += Math.pow(5, i);
        }
        
        return cnt;
    }
}