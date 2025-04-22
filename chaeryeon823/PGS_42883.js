// 큰 수 만들기
// lv 2
// 그리디
// 스택

function solution(number, k) {
  const stack = [];

  for (let digit of number) {
    while (k > 0 && stack.length && stack[stack.length - 1] < digit) {
      stack.pop();
      k--;
    }
    stack.push(digit);
  }

  return stack.slice(0, stack.length - k).join("");
}
