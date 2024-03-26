import java.util.*;
public class PGS_42747 {
    public int solution(int[] citations) {
        int[] hIdxArr = new int[citations.length];
        for(int i = 0; i < citations.length; i++){
            int h = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[i] <= citations[j]){
                    h++;
                }
                if(h > citations[i]){
                    h = 0;
                }
            }
            hIdxArr[i] = h;
        }

        Arrays.sort(hIdxArr);
        return hIdxArr[(citations.length)-1];

    }
}
