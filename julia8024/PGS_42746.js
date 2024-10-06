function solution(numbers) {
    let num = numbers.map((iter) => String(iter));
    let answer = (num.sort((a, b) => (b+a) - (a+b))).join("");
    return answer[0] == "0" ? "0" : answer;
}