scenario = 0

while True:
    scenario += 1
    n = int(input())
    if n == 0:
        break
    
    students = []
    
    for _ in range(n):
        students.append([input(), 0])
    
    for _ in range(2 * n - 1):
        s, a = input().split()
        
        students[int(s) - 1][1] += 1
    
    for students, count in students:
        if count == 1:
            print(scenario, students)