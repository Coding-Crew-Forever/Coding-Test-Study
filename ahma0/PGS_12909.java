import java.util.*;
import java.io.*;

class Solution {

    boolean solution(String s) {
        Queue<Character> q = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                q.add(s.charAt(i));
            }
            else if(s.charAt(i) == ')') {
                if(!q.isEmpty()) {
                    q.poll();
                }
                else {
                    return false;
                }
            }
        }

        if(!q.isEmpty()) {
            return false;
        }
        
        return true;
    }
}