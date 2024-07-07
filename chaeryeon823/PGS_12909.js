// 올바른 괄호
// lv 2
// 스택

function solution(s) {
  var answer = true;
  let arr = [];
  for (let i = 0; i < s.length; i++) {
    if (s[i] === '(') {
      arr.push('(');
    } else {
      if (arr.length === 0) {
        answer = false;
        break;
      }
      arr.pop();
    }
  }
  if (arr.length > 0) {
    answer = false;
  }
  return answer;
}
