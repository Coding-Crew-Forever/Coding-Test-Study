# 리트코드
# 179. Largest Number

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        nums = sorted(list(map(str, nums)), key=lambda x: x*10, reverse=True)
        
        result = ''.join(nums)
        return result if result[0] != '0' else '0'
