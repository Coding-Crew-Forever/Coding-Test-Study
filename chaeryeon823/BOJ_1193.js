// 분수찾기
// S5
// 구현

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  let X = parseInt(line);

  // X 위치
  let diagonal = 1;
  while (X > diagonal) {
    X -= diagonal;
    diagonal++;
  }

  let numerator, denominator;

  if (diagonal % 2 === 1) {
    // 홀수 대각선
    numerator = diagonal - X + 1;
    denominator = X;
  } else {
    // 짝수 대각선
    numerator = X;
    denominator = diagonal - X + 1;
  }

  console.log(`${numerator}/${denominator}`);
  rl.close();
});
