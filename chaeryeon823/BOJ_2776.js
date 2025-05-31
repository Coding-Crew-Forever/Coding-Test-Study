// 암기왕
// S4

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let arr = [];

rl.on("line", (line) => {
  arr.push(line);
});

rl.on("close", () => {
  let index = 0;
  const t = parseInt(arr[index++]);

  for (let i = 0; i < t; i++) {
    const n = parseInt(arr[index++]);
    const nums1 = new Set(arr[index++].split(" ").map(Number));
    const m = parseInt(arr[index++]);
    const nums2 = arr[index++].split(" ").map(Number);

    for (const num of nums2) {
      if (nums1.has(num)) {
        console.log(1);
      } else {
        console.log(0);
      }
    }
  }
});
