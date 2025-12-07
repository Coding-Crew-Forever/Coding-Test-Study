const fs = require('fs');

const n = BigInt(fs.readFileSync(0, 'utf8').toString().trim());

let sum = 0n;
let i = 1n;
let cnt = 0n;

while (true) {
  if (sum > n) {
    break;
  } else {
    sum += i;
    i += 1n;
    cnt += 1n;
  }
}
console.log(String(cnt - 1n));
