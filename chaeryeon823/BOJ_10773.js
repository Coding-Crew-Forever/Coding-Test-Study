const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const arr = [];

for (let i = 1; i <= n; i++) {
  const tmp = Number(input[i]);
  if (tmp !== 0) {
    arr.push(tmp);
  } else {
    arr.pop();
  }
}

console.log(arr.reduce((a, b) => a + b, 0));
