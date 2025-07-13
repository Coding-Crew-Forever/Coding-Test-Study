const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
rl.on("line", (line) => {
  input.push(line.trim());
}).on("close", () => {
  const N = parseInt(input[0]);
  const xy = [];

  for (let i = 1; i <= N; i++) {
    const [x, y] = input[i].split(" ").map(Number);
    xy.push([x, y]);
  }

  xy.sort((a, b) => {
    if (a[0] === b[0]) {
      return a[1] - b[1]; // x가 같으면 y 오름차순
    } else {
      return a[0] - b[0]; // x 오름차순
    }
  });

  for (let i = 0; i < N; i++) {
    console.log(xy[i][0] + " " + xy[i][1]);
  }
});
