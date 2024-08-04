num = int(input())
answer = 0

for _ in range(num):
    word = input()
    check = []

    for idx, ch in enumerate(word):
        if ch in check:
            if word[idx - 1] != ch:
                check.clear()
                break
        else:
            check.append(ch)
    if check:
        answer += 1
print(answer)