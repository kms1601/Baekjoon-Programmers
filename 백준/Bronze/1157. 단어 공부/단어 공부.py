from collections import Counter

cnt = Counter(input().upper())
print(cnt.most_common(1)[0][0] if len(cnt) == 1 or cnt.most_common(2)[0][1] != cnt.most_common(2)[1][1] else '?')