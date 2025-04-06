// n^2 배열 자르기
// lv 2

function solution(n, left, right) {
  const answer = [];

  for (let i = left; i <= right; i++) {
    const temp = Math.max(Math.floor(i / n), i % n);
    answer.push(temp + 1);
  }

  return answer;
}
