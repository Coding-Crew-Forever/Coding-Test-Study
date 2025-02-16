import java.util.*;
import java.util.stream.Collectors;

public class PGS_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        // 리스트로 변환
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        lostList.sort(Integer::compareTo);
        reserveList.sort(Integer::compareTo);

        List<Integer> newLostList = new ArrayList<>(lostList);
        List<Integer> newReserveList = new ArrayList<>(reserveList);

        // 여벌 체육복이 있는 학생이 도난당했을 때
        for (Integer student : lostList) {
            if (reserveList.contains(student)) {
                newLostList.remove(student);
                newReserveList.remove(student);
            }
        }

        for (Iterator<Integer> it = newLostList.iterator(); it.hasNext();) {
            int student = it.next();
            // 앞번호 학생에게 빌리기
            if (newReserveList.contains(student - 1)) {
                it.remove();
                newReserveList.remove(Integer.valueOf(student - 1));
            }
            // 뒷번호 학생에게 빌리기
            else if (newReserveList.contains(student + 1)) {
                it.remove();
                newReserveList.remove(Integer.valueOf(student + 1));
            }
        }

        return n - newLostList.size();
    }
}
