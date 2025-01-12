import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PGS_42895 {
    public int solution(int N, int number) {
        List<HashSet<Integer>> hashSetList = new ArrayList<HashSet<Integer>>();

        // N을 1~8번 사용한 경우를 각 hashset에 저장

        // 8개의 hashset 생성
        for(int i = 0; i <= 8; i++) {
            hashSetList.add(i, new HashSet<Integer>());
        }
        // 1번 사용한 경우(N)
        hashSetList.get(1).add(N);
        if(N == number) return 1;

        // n번 사용한 경우
        for(int i = 2; i <= 8; i++) {
            HashSet<Integer> hashSet = hashSetList.get(i);
            // N을 i개 이어붙인 수 (555, 5555, ...)
            hashSet.add(Integer.parseInt(Integer.toString(N).repeat(i)));

            for(int j = 1; j < i; j++) {
                HashSet<Integer> hashSet1 = hashSetList.get(j);
                HashSet<Integer> hashSet2 = hashSetList.get(i-j);

                for(int a : hashSet1) {
                    for(int b : hashSet2) {
                        hashSet.add(a + b);
                        hashSet.add(a - b);
                        hashSet.add(a * b);
                        if(a != 0 && b != 0) {
                            hashSet.add(a / b);
                        }
                    }
                }
            }

            if(hashSet.contains(number)) return i;
        }
        // 최소값이 8보다 크면 -1 반환
        return -1;
    }
}
