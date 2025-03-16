# 프로그래머스
# Lv2 [3차] 파일명 정렬

import re

def solution(files):
    temp = [re.split(r"([0-9]+)", s) for s in files]
    sort = sorted(temp, key = lambda x: (x[0].lower(), int(x[1])))
    
    return [''.join(s) for s in sort]
