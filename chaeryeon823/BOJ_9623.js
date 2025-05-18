// BABBA
// S5

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const cnt = new Array(46).fill(0);

function fn(n) {
  if (cnt[n] === 0) {
    if (n <= 2) {
      cnt[n] = 1;
    } else {
      cnt[n] = fn(n - 1) + fn(n - 2);
    }
  }
  return cnt[n];
}

rl.question("", (num) => {
  num = parseInt(num);
  let a = 0;
  let b = 0;

  if (num === 1) {
    a = 0;
    b = 1;
  } else {
    a = fn(num - 1);
    b = fn(num);
  }

  console.log(`${a} ${b}`);
  rl.close();
});
