import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new LinkedList<>();
        
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        
        return sb
            .append(list.get(0))
            .append(" ")
            .append(list.get(list.size() - 1))
            .toString();
    }
}