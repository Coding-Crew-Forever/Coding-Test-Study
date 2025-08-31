const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(/\s+/);
const N = Number(input[0]);
const K = Number(input[1]);

const queue = [];
for (let i = 1; i <= N; i++) {
  queue.push(i);
}

const arr = [];
let count = 1;

while (queue.length) {
  const tmp = queue.shift();
  if (count === K) {
    arr.push(tmp);
    count = 1;
  } else {
    queue.push(tmp);
    count++;
  }
}

let result = "<";
for (let i = 0; i < arr.length; i++) {
  result += arr[i];
  if (i !== arr.length - 1) {
    result += ", ";
  }
}
result += ">";
console.log(result);
