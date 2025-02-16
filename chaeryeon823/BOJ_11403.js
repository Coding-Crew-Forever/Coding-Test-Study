// 경로 찾기
// s1
// 최단 경로, 플로이드 워셜

const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let N = +input.shift();
let arr = [];

for (const row of input) {
  arr.push(row.split(" ").map(Number));
}

for (let k = 0; k < N; k++) {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (arr[i][k] && arr[k][j]) {
        arr[i][j] = 1;
      }
    }
  }
}

for (let i = 0; i < N; i++) {
  console.log(arr[i].join(" "));
}
