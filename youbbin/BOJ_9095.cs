using System;

class Program
{
    static void Main(string[] args)
    {
        int T = int.Parse(Console.ReadLine());
        for (int t = 0; t < T; t++)
        {
            int n = int.Parse(Console.ReadLine());
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1; i <= n; i++)
            {
                if (i - 1 >= 0)
                    dp[i] += dp[i - 1];
                if (i - 2 >= 0)
                    dp[i] += dp[i - 2];
                if (i - 3 >= 0)
                    dp[i] += dp[i - 3];
            }

            Console.WriteLine(dp[n]);
        }
    }
}
