// 연속 부분 수열의 합
// lv 2
// 구현
function solution(elements) {
  var answer = 0;
  let arr = [];
  let l = elements.length;

  for (let i = 0; i < l; i++) {
    for (let j = 0; j < l - 1; j++) {
      let sum = elements.slice(i, i + j + 1).reduce((acc, cur) => acc + cur);
      arr.push(sum);
    }
    elements.push(elements[i]);
  }
  let setArr = new Set(arr);
  answer = setArr.size;
  return answer + 1;
}
