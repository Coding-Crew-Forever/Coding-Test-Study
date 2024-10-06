function solution(array, commands) {
    let answer = [];
    
    commands.map((iter) => {
        let slicedArray = array.slice(iter[0]-1, iter[1]).sort((a,b) => a - b);
        answer.push(slicedArray[iter[2]-1]);
    })
    
    return answer;
}