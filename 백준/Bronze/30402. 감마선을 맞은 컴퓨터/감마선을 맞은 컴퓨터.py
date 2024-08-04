out = ''
try:
  for _ in range(15):
    photo = input().split()
    for color in photo:
      if color == 'w':
        out = 'chunbae'
        raise Exception
      elif color == 'b':
        out ='nabi'
        raise Exception
      elif color == 'g':
        out = "yeongcheol"
        raise Exception
except:
  print(out)
