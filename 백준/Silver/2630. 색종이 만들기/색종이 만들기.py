def cutting(paper, N):
  result = []
  for row in (0, N//2):
    for col in (0, N//2):
      tmp = []
      for i in range(col, col + N//2):
        tmp.extend(paper[i*N+row:i*N+row+N//2])
      result.append(tmp)
  return result

def cnt(paper, N):
  if sum(paper) == 0:
    return 1, 0
  elif sum(paper) == N ** 2:
    return 0, 1
  else:
    cut = cutting(paper, N)
    aw, ab = cnt(cut[0], N//2)
    bw, bb = cnt(cut[1], N//2)
    cw, cb = cnt(cut[2], N//2)
    dw, db = cnt(cut[3], N//2)
    return  aw + bw + cw + dw, ab + bb + cb + db
    
N = int(input())
paper = []

for _ in range(N):
  paper.extend(list(map(int, input().split())))

white, blue = cnt(paper, N)
print(white, blue, sep='\n')
