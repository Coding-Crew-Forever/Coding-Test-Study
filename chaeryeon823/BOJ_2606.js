// 바이러스
// S3
const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

// 컴퓨터 수 (노드 수)
const N = parseInt(input[0]);
// 연결 수 (간선 수)
const M = parseInt(input[1]);

let answer = 0;
const graph = Array.from({ length: N + 1 }, () => []);
const visited = new Array(N + 1).fill(false);

// 그래프 구성 (2번 줄부터 M+1번 줄까지)
for (let i = 2; i < M + 2; i++) {
  const [a, b] = input[i].split(" ").map(Number);
  graph[a].push(b);
  graph[b].push(a); // 양방향 연결
}

// DFS 함수
function dfs(now) {
  visited[now] = true;
  answer++;

  for (const node of graph[now]) {
    if (!visited[node]) {
      dfs(node);
    }
  }
}

// 1번 컴퓨터부터 시작
dfs(1);

// 1번 컴퓨터 제외하고 출력
console.log(answer - 1);
