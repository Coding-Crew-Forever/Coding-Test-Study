using System;
using System.Collections.Generic;
using System.Linq;

public class Solution
{
    public int solution(int n, int[] lost, int[] reserve)
    {
        HashSet<int> lostSet = new HashSet<int>(lost);
        HashSet<int> reserveSet = new HashSet<int>(reserve);

        HashSet<int> intersect = new HashSet<int>(lostSet);
        intersect.IntersectWith(reserveSet);

        foreach (int student in intersect)
        {
            lostSet.Remove(student);
            reserveSet.Remove(student);
        }

        List<int> sortedLost = lostSet.OrderBy(x => x).ToList();

        foreach (int student in sortedLost.ToList())
        {
            if (reserveSet.Contains(student - 1))
            {
                reserveSet.Remove(student - 1);
                lostSet.Remove(student);
            }
            else if (reserveSet.Contains(student + 1))
            {
                reserveSet.Remove(student + 1);
                lostSet.Remove(student);
            }
        }

        int answer = n - lostSet.Count;
        return answer;
    }
}