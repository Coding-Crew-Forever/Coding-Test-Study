const fs = require("fs");
const N = Number(fs.readFileSync(0, "utf8").trim());

let result = 0;
let digit = 1;
let start = 1;

while (true) {
  const end = start * 10 - 1;
  if (N >= end) {
    result += (end - start + 1) * digit;
  } else {
    result += (N - start + 1) * digit;
    break;
  }

  digit++;
  start *= 10;
  if (start > N) break;
}

console.log(result);
