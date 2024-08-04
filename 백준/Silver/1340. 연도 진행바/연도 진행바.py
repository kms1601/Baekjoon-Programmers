MONTH = {
    'January': 0,
    'February': 31,
    'March': 59,
    'April': 90,
    'May': 120,
    'June': 151,
    'July': 181,
    'August': 212,
    'September': 243,
    'October': 273,
    'November': 304,
    'December': 334,
}

month, day, year, time = input().split()
hour, minute = map(int, time.split(':'))
day = int(day[:-1])
year = int(year)

if year % 400 == 0 or (year % 4 == 0 and year % 100 != 0):
    is_leap = True
else:
    is_leap = False

passed = minute + hour * 60 + (day - 1) * 1440

if month not in ['January', 'February'] and is_leap:
    passed += (MONTH[month] + 1) * 1440
else:
    passed += MONTH[month] * 1440

print((passed / (527040 if is_leap else 525600)) * 100)