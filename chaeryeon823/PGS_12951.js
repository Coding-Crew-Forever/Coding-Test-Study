// JadenCase 문자열 만들기
// lv 2
// 문자열, 구현

function solution(s) {
  let answer = '';
  const checkAlpha = /[a-zA-Z]/; //영어
  let word = '';
  s = s.toLowerCase();
  for (let i = 0; i < s.length; i++) {
    if (s[i] === ' ') {
      answer += s[i];
      word = '';
    } else {
      if (word === '' && checkAlpha.test(s[i])) {
        answer += s[i].toUpperCase();
      } else {
        answer += s[i];
      }
      word += s[i];
    }
  }

  return answer;
}
