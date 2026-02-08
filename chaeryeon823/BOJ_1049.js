const fs = require('fs');
const input = fs.readFileSync(0, 'utf8').trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);

let minPack = Infinity;
let minOne = Infinity;

// 각 브랜드의 패키지/낱개 최소 가격 갱신
for (let i = 1; i <= M; i++) {
  const [p, o] = input[i].split(' ').map(Number);
  if (p < minPack) minPack = p;
  if (o < minOne) minOne = o;
}

const costAllOne = N * minOne;
const costAllPack = Math.ceil(N / 6) * minPack;
const costMix = Math.floor(N / 6) * minPack + (N % 6) * minOne;
const answer = Math.min(costAllOne, costAllPack, costMix);

console.log(answer);
