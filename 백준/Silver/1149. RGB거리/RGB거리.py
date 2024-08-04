import sys

sys.setrecursionlimit(1000000)
costs_list = []
COMPARE = ((1, 2), (0, 2), (0, 1))


def get_lowest_cost(house, costs):
    result = [0, 0, 0]

    if house == len(costs_list):
        return costs

    result[0], result[1], result[2] = costs_list[house][0], costs_list[house][1], costs_list[house][2]

    for i, (x, y) in enumerate(COMPARE):
        if costs[x] < costs[y]:
            result[i] += costs[x]
        else:
            result[i] += costs[y]
    return get_lowest_cost(house + 1, result)


for _ in range(int(input())):
    costs_list.append(list(map(int, input().split())))

print(min(get_lowest_cost(0, [0, 0, 0])))
