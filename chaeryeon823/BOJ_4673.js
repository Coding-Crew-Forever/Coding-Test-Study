const MAX = 10000;

function d(n) {
  let sum = n;
  while (n > 0) {
    sum += n % 10;
    n = Math.floor(n / 10);
  }
  return sum;
}

const isSelf = Array(MAX + 1).fill(true);

for (let i = 1; i <= MAX; i++) {
  const v = d(i);
  if (v <= MAX) {
    isSelf[v] = false;
  }
}

let output = "";
for (let i = 1; i <= MAX; i++) {
  if (isSelf[i]) {
    output += i + "\n";
  }
}

console.log(output.trim());
