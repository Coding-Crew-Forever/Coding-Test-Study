// 숫자의 표현
// lv 2
// 수학, 구현

function solution(n) {
  let answer = 1;
  for (let i = 1; i < n; i++) {
    let sum = 0;
    let tmp = i;
    while (sum < n) {
      sum += tmp;
      tmp += 1;
    }
    if (sum === n) {
      answer++;
    }
  }
  return answer;
}
