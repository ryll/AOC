import re

countA,countB = 0,0

with open("Day2_input.txt") as f:
    for line in f:
        p1, p2, char, pw = re.split("-| |: ", line)
        if int(p1) <= pw.count(char) <= int(p2):
            countA += 1
        if (pw[int(p1)-1] is char) != (pw[int(p2)-1] is char):
            countB += 1 
print(countA)
print(countB)

