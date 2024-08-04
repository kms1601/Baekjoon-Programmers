from collections import deque


deck = deque([i for i in range(1, int(input()) + 1)])
top_card = deck.popleft()

while deck:
    top_card = deck.popleft()
    deck.append(top_card)
    top_card = deck.popleft()
print(top_card)
