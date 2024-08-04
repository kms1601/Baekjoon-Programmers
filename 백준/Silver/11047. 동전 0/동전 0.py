import heapq

N, K = map(int, input().split())
unit = []
for _ in range(N):
    heapq.heappush(unit, -int(input()))

count = 0
while unit:
    money = -heapq.heappop(unit)
    temp = K // money
    count += temp
    K -= temp * money
    
print(count)