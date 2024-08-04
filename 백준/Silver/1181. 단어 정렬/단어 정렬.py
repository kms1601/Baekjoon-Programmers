num = int(input())
word_set = set()

for _ in range(num):
    word_set.add(input())
word_set = sorted(list(word_set), key=lambda x: (len(x), x))

for word in word_set:
    print(word)
