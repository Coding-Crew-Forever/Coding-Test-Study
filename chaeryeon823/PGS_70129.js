// 이진 변환 반복하기
// lv 2
// 문자열, 구현

function solution(s) {
  var answer = [0, 0];
  while (s !== '1') {
    // 0 제거
    answer[1] += s.split('0').length - 1;
    s = s.replaceAll('0', '');

    // 길이를 2진수
    s = s.length.toString(2);

    answer[0]++;
  }
  console.log(s);
  return answer;
}
