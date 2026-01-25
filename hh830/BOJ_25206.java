import java.io.*;
import java.util.*;

public class BOJ_25206 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0.0;
        double cnt = 0.0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stringTokenizer.nextToken();
            double c = Double.parseDouble(stringTokenizer.nextToken());
            String g = stringTokenizer.nextToken();

            if (g.equals("P")) 
                continue;

            double s = 0.0;
            switch (g) {
                case "A+": 
                    s = 4.5; 
                    break;
                case "A0": 
                    s = 4.0; 
                    break;
                case "B+": 
                    s = 3.5; 
                    break;
                case "B0": 
                    s = 3.0; 
                    break;
                case "C+": 
                    s = 2.5; 
                    break;
                case "C0": 
                    s = 2.0; 
                    break;
                case "D+": 
                    s = 1.5; 
                    break;
                case "D0": 
                    s = 1.0; 
                    break;
                case "F":  
                    s = 0.0; 
                    break;
            }

            sum += c * s;
            cnt += c;
        }

        System.out.println(sum / cnt);
    }
}
