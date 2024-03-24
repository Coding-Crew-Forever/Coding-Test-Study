public class PGS_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = 0;
        int y1 = (int)((-4 + brown + Math.sqrt((4-brown)*(4-brown)-16 * yellow)) / 4);
        int y2 = (int)((-4 + brown - Math.sqrt((4-brown)*(4-brown)-16 * yellow)) / 4);
        if(y1 > 0 && y1 <= yellow){
            x = yellow / y1;
            answer[0] = x + 2;
            answer[1] = y1 + 2;
        }

        if(y2 > 0 && y2 <= yellow){
            x = yellow / y2;
            answer[0] = x + 2;
            answer[1] = y2 + 2;
        }
        return answer;
    }
}
