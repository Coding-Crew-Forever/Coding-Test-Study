// 뒤에 있는 큰 수 찾기
// Lv2

function solution(numbers) {
  const answer = new Array(numbers.length).fill(-1);
  const stack = [];

  for (let i = 0; i < numbers.length; i++) {
    const tmp = numbers[i];
    while (stack.length && numbers[stack[stack.length - 1]] < tmp) {
      const last = stack.pop();
      answer[last] = tmp;
    }
    stack.push(i);
  }

  return answer;
}
