// 구명보트
// lv 2
// 투포인터

function solution(people, limit) {
  var answer = 0;
  let right = people.length - 1;
  let left = 0;
  people.sort((a, b) => a - b);

  while (left <= right) {
    if (people[left] + people[right] <= limit) {
      left++;
    }
    right--;
    answer++;
  }
  return answer;
}
