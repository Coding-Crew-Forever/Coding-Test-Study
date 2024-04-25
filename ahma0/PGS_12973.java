import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        String[] split = s.split("");
        Stack<String> stack = new Stack();

        for(String str : split) {
            if(!stack.isEmpty() && stack.peek().equals(str)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}