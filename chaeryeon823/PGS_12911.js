// 다음 큰 숫자
// lv 2
// 문자열, 구현

function solution(n) {
  var answer = n;
  while (true) {
    answer++;
    if (
      n.toString(2).split('1').length === answer.toString(2).split('1').length
    ) {
      break;
    }
  }
  return answer;
}
