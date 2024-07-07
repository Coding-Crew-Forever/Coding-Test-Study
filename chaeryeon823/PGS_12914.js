// 멀리 뛰기
// lv 2
// 피보나치 수, 구현

function solution(n) {
  var answer = 0;
  if (n === 1) {
    return 1;
  }
  [a, b] = [1, 1];
  for (let i = 1; i < n; i++) {
    [a, b] = [b, (a + b) % 1234567];
  }

  return b;
}
