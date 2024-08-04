answer = []
while True:
    try:
        answer.append(input())
    except EOFError:
        break
for word in answer:
    print(word)