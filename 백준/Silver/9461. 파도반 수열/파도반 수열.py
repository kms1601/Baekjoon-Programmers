seq = [1, 1, 1]
for idx in range(97):
    seq.append(seq[idx] + seq[idx + 1])
for _ in range(int(input())):
    print(seq[int(input()) - 1])
