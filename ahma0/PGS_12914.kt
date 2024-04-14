class Solution {
    
    fun solution(n: Int): Long {
        var answer: Long = 0
        
        val arr = LongArray(n + 1, {0})
        arr[0] = 1
        arr[1] = 1
        
        for(i: Int in 2 until n + 1) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567
        }
        
        return arr[n]
    }

}