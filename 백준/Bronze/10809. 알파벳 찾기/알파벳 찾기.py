word = input()
answer = [-1] * 26

for idx, ch in enumerate(word):
    ch = ord(ch) - 97

    if answer[ch] == -1:
        answer[ch] = idx

for num in answer:
    print(num, end=' ')
