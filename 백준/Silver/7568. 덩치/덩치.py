n = int(input())
person_list = []

for _ in range(n):
    person_list.append(list(map(int, input().split())))

for idx, person in enumerate(person_list):
    level = 1

    for comp in person_list[:idx] + person_list[idx + 1 :]:
        if person[0] - comp[0] < 0 and person[1] - comp[1] < 0:
            level += 1
    print(level, end=" ")
