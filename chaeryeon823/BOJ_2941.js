const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = "";
rl.on("line", (line) => {
  input += line.trim();
  rl.close();
}).on("close", () => {
  let croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];
  let str = input;

  for (let pattern of croatia) {
    str = str.split(pattern).join("*");
  }

  console.log(str.length);
});
