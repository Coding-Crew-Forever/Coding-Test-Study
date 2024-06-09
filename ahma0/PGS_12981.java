import java.util.*;
import java.io.*;

class Solution {
    
    public int[] solution(int n, String[] words) {
        
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for(int i = 1; i < words.length; i++) {
            if(words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return new int[] { i % n + 1, (int) Math.floor(i / n) + 1 };
            }
            
            if(list.contains(words[i])) {
                return new int[] { i % n + 1, (int) Math.floor(i / n) + 1 };
            }
            
            list.add(words[i]);
        }

        return new int[] { 0, 0 };
    }
}