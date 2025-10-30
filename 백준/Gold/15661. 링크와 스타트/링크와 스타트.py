import sys

input = sys.stdin.readline


def get_total_stat(team: list, stat: list[list]) -> int:
    total = 0
    for i in range(len(team)):
        for j in range(len(team)):
            total += stat[team[i]][team[j]]
    return total


def main():
    N = int(input())
    stat = [[0 for _ in range(N)] for _ in range(N)]

    for i in range(N):
        inp = list(map(int, input().split()))
        for j in range(N):
            stat[i][j] = inp[j]

    _min = 9999
    for n in range(1, 2 ** (N - 1)):
        team = bin(n)[2:].zfill(N)
        team_start = []
        team_link = []
        for i, t in enumerate(team):
            if t == "0":
                team_start.append(i)
            else:
                team_link.append(i)
        _min = min(abs(get_total_stat(team_start, stat) - get_total_stat(team_link, stat)), _min)
    print(_min)



if __name__ == "__main__":
    main()
