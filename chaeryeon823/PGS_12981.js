// 영어 끝말잇기
// 문자열

function solution(n, words) {
  var answer = [0, 0];
  let last = words[0].slice(-1);
  let set = new Set();
  set.add(words[0]);
  for (let i = 1; i < words.length; i++) {
    let arr = words.slice(0, i);
    if (last !== words[i][0] || set.has(words[i])) {
      answer[0] = (i % n) + 1;
      answer[1] = Math.floor(i / n) + 1;
      break;
    }
    last = words[i].slice(-1);
    set.add(words[i]);
  }
  return answer;
}
