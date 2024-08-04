import sys

input = sys.stdin.readline
n, m = map(int, input().split())
pokemon_dict = {}

for i in range(1, n + 1):
    name = input().strip()
    pokemon_dict[i] = name
    pokemon_dict[name] = i

for _ in range(m):
    question = input().strip()
    print(
        pokemon_dict[int(question)]
        if question[0] in ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
        else pokemon_dict[question]
    )
