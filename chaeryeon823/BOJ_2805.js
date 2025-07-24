// 나무 자르기
// S2

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
rl.on("line", (line) => {
  input.push(line.trim());
}).on("close", () => {
  const [n, target] = input[0].split(" ").map(Number);
  const arr = input[1].split(" ").map(Number);

  arr.sort((a, b) => a - b);

  let b = 1;
  let t = arr[n - 1];
  let mid = 0;

  while (b <= t) {
    mid = Math.floor((b + t) / 2);
    let tmp = 0;
    for (let i = 0; i < n; i++) {
      if (arr[i] >= mid) {
        tmp += arr[i] - mid;
      }
    }
    if (tmp >= target) {
      b = mid + 1;
    } else {
      t = mid - 1;
    }
  }
  console.log(t);
});
