using System;
using System.Collections.Generic;

public class Solution
{
    public int solution(int n, int[,] edge)
    {

        List<int>[] graph = new List<int>[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new List<int>();

        for (int i = 0; i < edge.GetLength(0); i++)
        {
            int a = edge[i, 0];
            int b = edge[i, 1];
            graph[a].Add(b);
            graph[b].Add(a);
        }

        int[] distance = new int[n + 1];
        for (int i = 0; i <= n; i++)
            distance[i] = -1;

        distance[1] = 0;

        Queue<int> queue = new Queue<int>();
        queue.Enqueue(1);

        // BFS
        while (queue.Count > 0)
        {
            int node = queue.Dequeue();

            foreach (int neighbor in graph[node])
            {
                if (distance[neighbor] == -1)
                {
                    distance[neighbor] = distance[node] + 1;
                    queue.Enqueue(neighbor);
                }
            }
        }

        // 최장 거리
        int maxDistance = -1;
        for (int i = 1; i <= n; i++)
        {
            if (distance[i] > maxDistance)
                maxDistance = distance[i];
        }

        int answer = 0;
        for (int i = 1; i <= n; i++)
        {
            if (distance[i] == maxDistance)
                answer++;
        }

        return answer;
    }
}
