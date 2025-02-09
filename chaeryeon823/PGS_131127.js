// 할인 행사
// lv 2
// Counter 카운터

function Counter(array) {
  const counter = {};
  array.forEach((val) => (counter[val] = (counter[val] || 0) + 1));
  return counter;
}

function check(dictWantNumber, dis) {
  const counterDis = Counter(dis);

  const keys1 = Object.keys(dictWantNumber);
  const keys2 = Object.keys(counterDis);

  if (keys1.length !== keys2.length) return false;

  return keys1.every(
    (key) =>
      dictWantNumber[key] === counterDis[key] && counterDis.hasOwnProperty(key)
  );
}

function solution(want, number, discount) {
  let answer = 0;
  const dic = {};

  for (let i = 0; i < want.length; i++) {
    dic[want[i]] = number[i];
  }

  for (let i = 0; i <= discount.length - 10; i++) {
    answer += check(dic, discount.slice(i, i + 10)) ? 1 : 0;
  }

  return answer;
}
