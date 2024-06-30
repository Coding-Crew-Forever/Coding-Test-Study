import java.util.*;

public class PGS_12941 {
    public int solution(int[] A, int[] B) {
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++){
            sum += A[i] * B[A.length-i-1];
        }
        return sum;
    }
}