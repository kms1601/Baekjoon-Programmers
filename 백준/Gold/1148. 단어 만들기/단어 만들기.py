import sys
from collections import defaultdict

input = sys.stdin.readline


def filter_dict(dictionary: list[dict[str, int]], puzzle: dict[str, int]) -> list[dict[str, int]]:
    result = []
    for word in dictionary:
        flag = True
        for char in word:
            if char not in puzzle or word[char] > puzzle[char]:
                flag = False
                break
        if flag:
            result.append(word)
    return result


def solve(dictionary: list[dict[str, int]], puzzle: dict[str, int]) -> (str, int, str, int):
    filtered = filter_dict(dictionary, puzzle)
    min_count = len(filtered)
    max_count = 0
    min_list = []
    max_list = []
    for mid in puzzle:
        count = 0
        for word in filtered:
            if mid in word:
                count += 1

        if count < min_count:
            min_count = count
            min_list = []
        if count > max_count:
            max_count = count
            max_list = []

        if min_count == count:
            min_list.append(mid)
        if max_count == count:
            max_list.append(mid)
    min_list.sort()
    max_list.sort()

    return "".join(min_list), min_count, "".join(max_list), max_count


def str_to_dict(string: str) -> dict[str, int]:
    dd = defaultdict(int)
    for s in string:
        dd[s] += 1
    return dd


def main():
    dictionary = []
    while True:
        word = input().strip()
        if word == "-":
            break
        dictionary.append(str_to_dict(word))

    puzzles = []
    while True:
        puzzle = input().strip()
        if puzzle == "#":
            break
        puzzles.append(str_to_dict(puzzle))

    for puzzle in puzzles:
        min_list, min_count, max_list, max_count = solve(dictionary, puzzle)
        print(min_list, min_count, max_list, max_count)


if __name__ == '__main__':
    main()
