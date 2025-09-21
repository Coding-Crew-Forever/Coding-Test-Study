const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = Number(input[0]);
const nums = input[1].split(" ").map(Number);

const map = new Map();
for (const num of nums) {
  map.set(num, (map.get(num) || 0) + 1);
}

const M = Number(input[2]);
const queries = input[3].split(" ").map(Number);

const result = [];
for (const q of queries) {
  result.push(map.get(q) || 0);
}

console.log(result.join(" "));
