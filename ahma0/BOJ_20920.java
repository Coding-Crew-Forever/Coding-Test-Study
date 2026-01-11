import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String word = br.readLine();
            if (word.length() < m) {
                continue;
            }
            map.merge(word, 1, Integer::sum);
        }

        Set<Word> set = map.entrySet().stream().map(entry ->
            new Word(entry.getKey(), entry.getValue())
        ).collect(Collectors.toCollection(TreeSet::new));

        StringBuilder sb = new StringBuilder();
        set.forEach(word -> sb.append(word.word).append("\n"));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Word implements Comparable<Word> {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt != o.cnt) {
                return Integer.compare(o.cnt, this.cnt);
            }
            if (this.word.length() != o.word.length()) {
                return Integer.compare(o.word.length(), this.word.length());
            }
            return this.word.compareTo(o.word);
        }

        @Override
        public String toString() {
            return this.word;
        }
    }

}

