class Solution {
    
    public int[] solution(int brown, int yellow) {
        
        int sum = brown + yellow;
        int cnt = 1;
        
        while(true) {
            int t = (brown / 2) - cnt + 2;
            
            if(t * cnt == sum) {
                return new int[]{t, cnt};
            }
            
            cnt++;
        }
        
    }
}