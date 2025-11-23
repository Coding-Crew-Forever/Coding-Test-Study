const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const arr = [];
for (let i = 1; i <= n; i++) {
  arr.push(Number(input[i]));
}

arr.sort((a, b) => b - a);

let answer = 0;
for (let i = 0; i < n; i++) {
  answer = Math.max(answer, (i + 1) * arr[i]);
}

console.log(answer);
