total_grade = 0
total_time = 0
grade_dict = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0.0}
while True:
    try:
        subject, time, grade = input().split()
        if grade != 'P':
            total_time += float(time)
            total_grade += float(time) * grade_dict[grade]
    except EOFError:
        print(total_grade / total_time)
        break
