const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const N = Number(input[0]);
const map = [];
for (let i = 1; i <= N; i++) {
  map.push(input[i].trim().split("").map(Number));
}

const visited = Array.from({ length: N }, () => Array(N).fill(false));
const dx = [-1, 1, 0, 0]; // 상하좌우
const dy = [0, 0, -1, 1];

function bfs(sx, sy) {
  const queue = [[sx, sy]];
  visited[sx][sy] = true;
  let count = 1;

  while (queue.length) {
    const [x, y] = queue.shift();
    for (let dir = 0; dir < 4; dir++) {
      const nx = x + dx[dir];
      const ny = y + dy[dir];

      if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
      if (visited[nx][ny]) continue;
      if (map[nx][ny] === 0) continue;

      visited[nx][ny] = true;
      queue.push([nx, ny]);
      count++;
    }
  }
  return count;
}

const complexes = [];

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (map[i][j] === 1 && !visited[i][j]) {
      complexes.push(bfs(i, j));
    }
  }
}

complexes.sort((a, b) => a - b);

let output = "";
output += complexes.length + "\n";
output += complexes.join("\n");
console.log(output);
