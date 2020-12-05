def getID(s):
    return int(s[:7],2)*8+int(s[7:],2)

def getMax(l):   
    return max(getID(s) for s in l)

def findSeat(l):
    rows = {}
    for s in l:
        if int(s[:7],2) in rows:
            rows.update({int(s[:7],2):rows[int(s[:7],2)]+int(s[7:],2)+1})
        else:
            rows.update({int(s[:7],2):int(s[7:],2)+1})
    
    for row in rows:
        if rows[row] != 36 and rows[row-1] == 36 and rows[row+1] == 36:
            return row*8 + (36 - rows[row] - 1)

with open("Day5_input.txt") as f:
    l = [x.strip().replace('B','1').replace('F','0').replace('R','1').replace('L','0') for x in f.readlines()]
    

#Part 1
print(getMax(l))

#Part 2
print(findSeat(l))