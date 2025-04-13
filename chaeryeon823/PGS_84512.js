// 모음 사전
// lv 2
// 완전탐색
// 경우의 수

function solution(word) {
  let answer = 0;
  let cnt = [781, 156, 31, 6, 1];
  let arr = ["A", "E", "I", "O", "U"];
  for (let i = 0; i < word.length; i++) {
    answer += arr.indexOf(word[i]) * cnt[i] + 1;
  }
  return answer;
}
