const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const N = Number(input[0]);
const stair = new Array(N + 1).fill(0);
for (let i = 1; i <= N; i++) {
  stair[i] = Number(input[i]);
}

// 예외 처리
if (N === 1) {
  console.log(stair[1]);
  process.exit(0);
}
if (N === 2) {
  console.log(stair[1] + stair[2]);
  process.exit(0);
}

const dp = new Array(N + 1).fill(0);
dp[1] = stair[1];
dp[2] = stair[1] + stair[2];
dp[3] = Math.max(stair[1], stair[2]) + stair[3];

for (let i = 4; i <= N; i++) {

  dp[i] = Math.max(
    dp[i - 2] + stair[i],
    dp[i - 3] + stair[i - 1] + stair[i]
  );
}

console.log(dp[N]);
