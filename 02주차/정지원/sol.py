def solution(numbers, target):
    idx = 0
    current = 0

    def dfs(list_of_nums, target_num, current_num, current_idx):
        if current_idx == len(list_of_nums):
            return 1 if current_num == target_num else 0
        
        # 현재 상황에서 숫자를 빼거나 더하여 재귀함수 호출
        return dfs(list_of_nums, target_num, current_num + list_of_nums[current_idx], current_idx + 1) + dfs(list_of_nums, target_num, current_num - list_of_nums[current_idx], current_idx + 1)

    result = dfs(numbers, target, current, idx)
    return result