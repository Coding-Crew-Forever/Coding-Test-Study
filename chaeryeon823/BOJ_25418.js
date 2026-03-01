const fs = require('fs');
let [A, K] = fs.readFileSync(0, 'utf8').trim().split(' ').map(Number);

const dist = Array(K + 1).fill(-1);
const queue = [];

queue.push(A);
dist[A] = 0;

while (queue.length) {
  const cur = queue.shift();
  if (cur === K) break;

  const nexts = [cur + 1, cur * 2];

  for (const nx of nexts) {
    if (nx > K) continue;         
    if (dist[nx] !== -1) continue; // 스킵
    dist[nx] = dist[cur] + 1;
    queue.push(nx);
  }
}

console.log(dist[K]);
