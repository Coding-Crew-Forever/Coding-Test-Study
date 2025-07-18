using System;

public class Solution
{
    public long solution(int n, int[] times)
    {
        long answer = 0;
        Array.Sort(times);
        long left = times[0];
        long right = (long)times[times.Length - 1] * n;

        while (left <= right)
        {
            long mid = (left + right) / 2;
            long temp = 0;

            foreach (int time in times)
            {
                temp += mid / time;
            }

            if (temp >= n)
            {
                answer = mid;
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return answer;
    }
}
