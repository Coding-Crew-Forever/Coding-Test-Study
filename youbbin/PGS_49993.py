def solution(skill, skill_trees):
    answer = 0  # 가능한 스킬트리 개수

    for skill_tree in skill_trees:
        filtered_skill_tree = ''
        # 선행 스킬 순서에 있는 skill만 추출
        for s in skill_tree:
            if s in skill:
                filtered_skill_tree += s

        # 추출된 스킬 순서가 선행 스킬 순서에 맞는지 확인
        if skill.startswith(filtered_skill_tree):
            answer += 1

    return answer