const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
rl.on("line", (line) => {
  input.push(line.trim());
}).on("close", () => {
  const [N, M, V] = input.split(" ").map(Number);
  const graph = Array.from({ length: N + 1 }, () => []);

  for (let i = 1; i <= M; i++) {
    const [a, b] = input.split(" ").map(Number);
    graph[a].push(b);
    graph[b].push(a);
  }

  for (let i = 1; i <= N; i++) {
    graph[i].sort((a, b) => a - b);
  }

  let visited = Array(N + 1).fill(false);
  const dfs_result = [];

  function dfs(v) {
    visited[v] = true;
    dfs_result.push(v);
    for (const next of graph[v]) {
      if (!visited[next]) dfs(next);
    }
  }

  dfs(V);

  visited.fill(false);
  const bfs_result = [];

  function bfs(v) {
    const queue = [v];
    visited[v] = true;
    while (queue.length) {
      const node = queue.shift();
      bfs_result.push(node);
      for (const next of graph[node]) {
        if (!visited[next]) {
          visited[next] = true;
          queue.push(next);
        }
      }
    }
  }

  bfs(V);

  console.log(dfs_result.join(" "));
  console.log(bfs_result.join(" "));
});
