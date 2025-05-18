// ATM
// 정렬
// S4

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let inputCount = 0;
let n;
let arr;

rl.on("line", (line) => {
  if (inputCount === 0) {
    n = parseInt(line);
    inputCount++;
  } else {
    arr = line.split(" ").map(Number);
    arr.sort((a, b) => a - b);

    let result = 0;
    let j = 0;

    for (let i = n; i > 0; i--) {
      result += arr[j] * i;
      j++;
    }

    console.log(result);
    rl.close();
  }
});
