// 주유소
// 그리디

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", (line) => {
  input.push(line.trim());
}).on("close", () => {
  const city = Number(input[0]);
  const miters = input[1].split(" ").map(Number);
  const prices = input[2].split(" ").map(Number);

  let answer = 0;
  let min_price = prices[0];

  // 주유는 마지막 도시에선 하지 않으므로 prices.length-1만큼만 반복
  for (let i = 0; i < prices.length - 1; i++) {
    if (min_price > prices[i]) min_price = prices[i];
    answer += min_price * miters[i];
  }
  console.log(answer);
});
