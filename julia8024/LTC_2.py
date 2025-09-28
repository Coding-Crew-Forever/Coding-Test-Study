# 리트코드
# 2. Add Two Numbers

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # change from ListNode to list
        list1 = convertToList(l1)
        list2 = convertToList(l2)

        # reverse and return int
        num1 = int(''.join(map(str, reversed(list1))))
        num2 = int(''.join(map(str, reversed(list2))))
        
        # add num1 and num2
        total = num1 + num2

        # convert list to ListNode (by reverse)
        result = ListNode()
        current = result
        for i in str(total)[::-1]:
            current.next = ListNode(int(i))
            current = current.next

        return result.next

def convertToList(listnode: Optional[ListNode]):
    result = []
    while listnode:
        result.append(listnode.val)
        listnode = listnode.next
    return result
