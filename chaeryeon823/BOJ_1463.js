const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  const number = parseInt(line);
  const dp = new Array(number + 1).fill(0);

  dp[0] = 0;
  dp[1] = 0;

  for (let i = 2; i <= number; i++) {
    dp[i] = dp[i - 1] + 1;
    if (i % 2 === 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
    if (i % 3 === 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
  }

  console.log(dp[number]);
  rl.close();
});
