# 전화번호 목록
# lv 2
# 문자열

def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book) - 1):
        stand = phone_book[i]
        if phone_book[i + 1].startswith(stand):
            return False
    return True

# startswith 함수
# 문자열 sort 의 기준