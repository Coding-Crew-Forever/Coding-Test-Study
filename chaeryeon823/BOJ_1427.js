const fs = require("fs");
const num = fs.readFileSync("/dev/stdin").toString().trim();
const arr = num.split("");
arr.sort((a, b) => b.localeCompare(a)); // 내림차순 정렬
const answer = arr.join("");
console.log(answer);
