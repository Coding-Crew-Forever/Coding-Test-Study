# 리트코드
# 55. Jump Game

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # 최대로 도달가능한 인덱스 (init: first index)
        max_reachable = 0

        for i, jump in enumerate(nums):
            # 최대로 도달가능한 인덱스가 주어진 nums의 인덱스보다 작은 경우 (마지막까지 도달할 수 없는 경우) False 반환
            if i > max_reachable:
                return False

            # 최대도달가능 인덱스(현재값)와 (현재 인덱스 + 현재 인덱스의 값) 중 큰 값으로 치환
            max_reachable = max(max_reachable, i + jump)

            # 최대로 도달가능한 인덱스가 주어진 nums의 마지막 인덱스보다 크거나 같다면 True 반환
            if max_reachable >= len(nums)-1:
                return True

        # for문을 다 돌았음에도 True 조건문을 통과하지 못한 경우
        return False
