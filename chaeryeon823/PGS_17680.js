// [1차] 캐시
// lv 2
// LRU

function solution(cacheSize, cities) {
  let answer = 0;
  const cache = [];

  if (cacheSize === 0) {
    return 5 * cities.length;
  }

  for (let city of cities) {
    city = city.toLowerCase();
    const index = cache.indexOf(city);
    // 캐시에 있음
    if (index !== -1) {
      cache.splice(index, 1);
      cache.push(city);
      answer += 1;
      // 캐시에 없고, 공간있음
    } else if (cache.length < cacheSize) {
      cache.push(city);
      answer += 5;
      // 캐시에 없고, 공간도 없음 -> 캐시 full
    } else {
      cache.shift();
      cache.push(city);
      answer += 5;
    }
  }

  return answer;
}
