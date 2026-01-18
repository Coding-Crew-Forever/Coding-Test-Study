const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const N = Number(input[0]); // 지방 수
const req = input[1].split(" ").map(Number); // 각 지방의 예산 요청
const M = Number(input[2]); // 총 예산

let low = 0;
let high = Math.max(...req);
let answer = 0;

while (low <= high) {
  const mid = Math.floor((low + high) / 2);
  let total = 0;

  for (let i = 0; i < N; i++) {
    total += req[i] > mid ? mid : req[i];
  }

  if (total <= M) {
    answer = mid;
    low = mid + 1;
  } else {
    high = mid - 1;
  }
}

console.log(answer);
