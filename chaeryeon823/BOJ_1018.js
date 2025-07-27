const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", (line) => {
  input.push(line.trim());
}).on("close", () => {
  const [N, M] = input[0].split(" ").map(Number);
  const chess = [];
  for (let i = 1; i <= N; i++) {
    chess.push(input[i].split(""));
  }

  let ans = 1000000;

  for (let i = 0; i <= N - 8; i++) {
    for (let j = 0; j <= M - 8; j++) {
      ans = Math.min(ans, countRepaint(chess, i, j));
    }
  }
  console.log(ans);
});

function countRepaint(chess, x, y) {
  let B = 0;
  let W = 0;

  for (let i = x; i < x + 8; i++) {
    for (let j = y; j < y + 8; j++) {
      if ((i + j) % 2 === 0) {
        if (chess[i][j] !== "B") B++;
        if (chess[i][j] !== "W") W++;
      } else {
        if (chess[i][j] !== "W") B++;
        if (chess[i][j] !== "B") W++;
      }
    }
  }
  return Math.min(B, W);
}
