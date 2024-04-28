import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        
        if(s.length() == 1) {
            return s.toUpperCase();
        }
        
        while(st.hasMoreElements()) {
            String temp = (String) st.nextElement();
            
            if(temp.length() > 1) {
                sb.append(temp.substring(0, 1).toUpperCase())
                    .append(temp.substring(1).toLowerCase());
            }
            else {
                sb.append(temp.toUpperCase());
            }
        }
        return sb.toString();
    }
}