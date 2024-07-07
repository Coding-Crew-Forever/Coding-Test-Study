// 짝지어 제거하기
// lv 2
// 구현

function solution(s) {
  var answer = -1;
  let arr = [s[0]];
  for (let i = 1; i < s.length; i++) {
    if (arr[arr.length - 1] === s[i]) {
      arr.pop();
    } else {
      arr.push(s[i]);
    }
  }

  if (arr.length === 0) {
    answer = 1;
  } else {
    answer = 0;
  }

  return answer;
}
