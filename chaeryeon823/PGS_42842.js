// 카펫
// 구현

function solution(brown, yellow) {
  let yellows = [];
  // yellow 가능성 구하기
  for (let i = 1; i <= Math.sqrt(yellow); i++) {
    if (yellow % i === 0) {
      yellows.push([parseInt(yellow / i), i]);
    }
  }
  // brown 구하기
  for (y of yellows) {
    let tmp = (y[0] + 2) * (y[1] + 2) - y[0] * y[1];
    if (tmp === brown) {
      return [y[0] + 2, y[1] + 2];
    }
  }
  return;
}
