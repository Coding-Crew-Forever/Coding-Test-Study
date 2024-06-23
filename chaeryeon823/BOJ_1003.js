// 피보나치 함수
// s3
// 수학

let fs = require('fs');
let input = fs.readFileSync('example.txt').toString().split('\n');
let T = Number(input[0]);

for (let i = 0; i < T; i++) {
  N = Number(input[i + 1]);
  const arr = [
    [1, 0],
    [0, 1],
  ];
  for (let j = 2; j <= N; j++) {
    arr[j] = [arr[j - 1][0] + arr[j - 2][0], arr[j - 1][1] + arr[j - 2][1]];
  }
  console.log(arr[N][0], arr[N][1]);
}
