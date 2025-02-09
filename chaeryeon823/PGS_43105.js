// 정수 삼각형
// lv 3
// DP
// 아래서 위로 올라가면서 합이 큰 수 더해주기

function solution(triangle) {
  for (let i = triangle.length - 2; i >= 0; i--) {
    for (let j = 0; j < triangle[i].length; j++) {
      triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
    }
  }
  return triangle[0][0];
}
