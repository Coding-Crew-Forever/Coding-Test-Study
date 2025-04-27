// 유기농 배추
// S2
// 그래프, DFS

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
rl.on("line", (line) => {
  input.push(line.trim());
}).on("close", () => {
  let index = 0;
  const T = parseInt(input[index++]);

  for (let t = 0; t < T; t++) {
    const [W, H, K] = input[index++].split(" ").map(Number);
    let graph = Array.from({ length: W }, () => Array(H).fill(0));
    let visited = Array.from({ length: W }, () => Array(H).fill(0));
    let answer = 0;

    // 배추 위치 설정
    for (let i = 0; i < K; i++) {
      const [x, y] = input[index++].split(" ").map(Number);
      graph[x][y] = 1;
    }

    // DFS 수행
    const dfs = (nowX, nowY) => {
      visited[nowX][nowY] = 1;
      const directions = [
        [-1, 0],
        [1, 0],
        [0, -1],
        [0, 1],
      ]; // 상하좌우

      for (const [dx, dy] of directions) {
        const nextX = nowX + dx;
        const nextY = nowY + dy;

        if (nextX >= 0 && nextX < W && nextY >= 0 && nextY < H) {
          if (graph[nextX][nextY] === 1 && visited[nextX][nextY] === 0) {
            dfs(nextX, nextY);
          }
        }
      }
    };

    // 모든 좌표 순회
    for (let x = 0; x < W; x++) {
      for (let y = 0; y < H; y++) {
        if (graph[x][y] === 1 && !visited[x][y]) {
          dfs(x, y);
          answer++;
        }
      }
    }
    console.log(answer);
  }
});
