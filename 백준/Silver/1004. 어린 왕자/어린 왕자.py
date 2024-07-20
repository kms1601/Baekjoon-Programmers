def get_distance(x1, y1, x2, y2):
    return ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** 0.5

for _ in range(int(input())):
    x1, y1, x2, y2 = map(int, input().split())
    answer = 0
    
    for _ in range(int(input())):
        cx, cy, r = map(int, input().split())
        dist_start = get_distance(cx, cy, x1, y1)
        dist_end = get_distance(cx, cy, x2, y2)
        
        if (dist_start > r and dist_end < r) or (dist_start < r and dist_end > r):
            answer += 1
    print(answer)