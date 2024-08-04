from collections import deque


testcase_cnt = int(input())

for _ in range(testcase_cnt):
    queue = deque()
    answer = 1
    _, question = map(int, input().split())
    importance_list = list(map(int, input().split()))
    
    for idx, importance in enumerate(importance_list):
        queue.append((idx, importance))
    
    while True:
        max_importance = max(queue, key=lambda x: x[1])[1]
        
        while queue[0][1] != max_importance:
            push = queue.popleft()
            queue.append(push)
        if queue.popleft()[0] == question:
            break
        answer += 1
    print(answer)