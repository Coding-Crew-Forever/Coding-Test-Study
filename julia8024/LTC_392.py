# 리트코드
# 392. Is Subsequence

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        current_idx = 0
        temp = []

        for i_val in s:
            for j in range(current_idx, len(t)):
                if i_val == t[j]:
                    # 다음은 현재 기준 +1 인덱스부터 탐색
                    current_idx = j+1
                    temp.append(i_val)
                    break
        
        return s == "".join(temp)
