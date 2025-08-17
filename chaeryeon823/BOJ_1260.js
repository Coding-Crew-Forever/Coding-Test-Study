const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
rl.on("line", (line) => input.push(line.trim()));
rl.on("close", () => {
  const [N, M, V] = input[0].split(" ").map(Number);
  const graph = Array.from({ length: N + 1 }, () => []);

  for (let i = 1; i <= M; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    graph[a].push(b);
    graph[b].push(a);
  }

  for (let i = 1; i <= N; i++) {
    graph[i].sort((a, b) => a - b);
  }

  // DFS
  const visitedDFS = Array(N + 1).fill(false);
  const dfsResult = [];

  function dfs(v) {
    visitedDFS[v] = true;
    dfsResult.push(v);
    for (const next of graph[v]) {
      if (!visitedDFS[next]) dfs(next);
    }
  }

  dfs(V);

  // BFS
  const visitedBFS = Array(N + 1).fill(false);
  const bfsResult = [];

  function bfs(v) {
    const queue = [v];
    visitedBFS[v] = true;
    while (queue.length) {
      const node = queue.shift();
      bfsResult.push(node);
      for (const next of graph[node]) {
        if (!visitedBFS[next]) {
          visitedBFS[next] = true;
          queue.push(next);
        }
      }
    }
  }

  bfs(V);

  console.log(dfsResult.join(" "));
  console.log(bfsResult.join(" "));
});
