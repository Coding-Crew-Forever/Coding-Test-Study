// 가장 큰 수
// lv2

function solution(numbers) {
  let answer = numbers
    .map((v) => v + "")
    .sort((a, b) => b + a - (a + b))
    .join("");

  return answer[0] === "0" ? "0" : answer;
}
