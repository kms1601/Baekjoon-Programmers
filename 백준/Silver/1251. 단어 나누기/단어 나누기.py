word = input()
word_list = []

for i in range(1, len(word) - 1):
    for j in range(i + 1, len(word)):
        left, mid, right = word[:i], word[i:j], word[j:]
        word_list.append(''.join(list(reversed(left)) + list(reversed(mid)) + list(reversed(right))))
print(sorted(word_list)[0])