// H-index
// Lv 2
// 정렬

function solution(citations) {
  let answer = 0;
  citations = citations.sort((a, b) => b - a);
  for (let i = 0; i < citations.length; i++) {
    if (i + 1 <= citations[i]) {
      answer = i + 1;
    } else {
      return answer;
    }
  }
  return answer;
}
