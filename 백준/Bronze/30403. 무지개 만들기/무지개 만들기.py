RAINBOW_UPPER = ('R', 'O', 'Y', 'G', 'B', 'I', 'V')
RAINBOW_LOWER = ('r', 'o', 'y', 'g', 'b', 'i', 'v')

N = input()
string = input()
upper_set = set()
lower_set = set()
result = 0

for char in string:
  if char in RAINBOW_UPPER:
    upper_set.add(char)
  elif char in RAINBOW_LOWER:
    lower_set.add(char)

if len(upper_set) == 7:
  result += 1

if len(lower_set) == 7:
  result += 2
  
if result & 3 == 3:
  print('YeS')
elif result & 3 == 2:
  print('yes')
elif result & 3 == 1:
  print('YES')
else:
  print('NO!')