N = int(input())
scores = []
for _ in range(N):
    scores.append(int(input()))

if N == 1:
    print(scores[0])
else:
    dp = [[0, 0] for _ in range(N)]
    dp[0] = [scores[0], 0]
    dp[1] = [scores[1], scores[0] + scores[1]]

    for i in range(2, N):
        dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + scores[i]
        dp[i][1] = dp[i - 1][0] + scores[i]

    print(max(dp[-1]))
    