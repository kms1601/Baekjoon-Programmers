word = input()

print(len(word.replace('c=', 'c').replace('c-', 'c').replace('dz=', 'd').replace('d-', 'd').replace('lj', 'l').replace('nj', 'n').replace('s=', 's').replace('z=', 'z')))