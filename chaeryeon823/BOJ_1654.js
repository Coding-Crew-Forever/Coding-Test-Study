// 랜선 자르기
// 이분탐색
// S2

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [K, N] = input.shift().split(" ").map(Number);
  let lines = input.map(Number);

  let start = 1,
    end = Math.max(...lines);

  while (start <= end) {
    let mid = Math.floor((start + end) / 2);
    let lineCnt = 0;

    for (let line of lines) {
      lineCnt += Math.floor(line / mid);
    }

    if (lineCnt >= N) {
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }

  console.log(end);
  process.exit(0);
});
