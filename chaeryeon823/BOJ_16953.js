// A->B

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  let [a, b] = line.split(" ").map(Number);
  let answer = 1;

  while (b !== a) {
    let temp = b;
    if (b % 10 === 1) {
      b = Math.floor(b / 10);
      answer += 1;
    } else if (b % 2 === 0) {
      b = b / 2;
      answer += 1;
    }

    if (b === temp) {
      answer = -1;
      break;
    }
  }

  console.log(answer);
  rl.close();
});
