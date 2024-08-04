import time
today = time.gmtime()
print(str(today[0]), '-', str(today[1]) if today[1] >= 10 else '0' + str(today[1]), '-', str(today[2]), sep='')
