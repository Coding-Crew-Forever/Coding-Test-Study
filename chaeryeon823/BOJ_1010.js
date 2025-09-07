const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

// dp[m][n]을 위한 2차원 배열 초기화 (최대 30)
const dp = Array.from({ length: 31 }, () => Array(31).fill(0));

// 조합 nCm 계산용 함수 (메모이제이션)
function comb(n, m) {
  if (dp[n][m] > 0) {
    return dp[n][m];
  }
  if (n === m || m === 0) {
    dp[n][m] = 1;
    return 1;
  }
  dp[n][m] = comb(n - 1, m - 1) + comb(n - 1, m);
  return dp[n][m];
}

const t = Number(input[0]);
let output = "";
for (let i = 1; i <= t; i++) {
  const [n, m] = input[i].split(" ").map(Number);
  output += comb(m, n) + "\n";
}
process.stdout.write(output);
