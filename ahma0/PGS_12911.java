class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int cnt = Integer.bitCount(n);
        
        while(true) {
            if(cnt == Integer.bitCount(answer))
                break;
            answer++;
        }
        
        return answer;
    }

}