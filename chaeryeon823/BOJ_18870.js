const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const N = Number(input[0]);
const arr = input[1].split(" ").map(Number);

const sortedUnique = Array.from(new Set(arr)).sort((a, b) => a - b);

const coord = new Map();
sortedUnique.forEach((value, index) => {
  coord.set(value, index);
});

let result = "";
for (let i = 0; i < N; i++) {
  result += coord.get(arr[i]) + (i === N - 1 ? "" : " ");
}

console.log(result);
