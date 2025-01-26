const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let nArr = [];
let mArr = [];
let lineCount = 0;

rl.on("line", function (line) {
  input.push(line);
  lineCount++;

  if (lineCount === 4) {
    solution();
    rl.close();
  }
}).on("close", function () {
  process.exit();
});

function solution() {
  const N = parseInt(input[0]);
  nArr = input[1].split(" ").map(Number);

  nArr.sort((a, b) => a - b);

  const M = parseInt(input[2]);
  mArr = input[3].split(" ").map(Number);

  for (let i = 0; i < M; i++) {
    console.log(binarySearch(nArr, mArr[i]));
  }
}

function binarySearch(arr, num) {
  let b = 0;
  let t = arr.length - 1;
  let m = 0;

  while (b <= t) {
    m = Math.floor((b + t) / 2);
    if (num < arr[m]) {
      t = m - 1;
    } else if (num > arr[m]) {
      b = m + 1;
    } else if (num === arr[m]) {
      return 1;
    }
  }
  return 0;
}
