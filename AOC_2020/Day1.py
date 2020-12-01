# A 
# Find the two entries that sum to 2020; what do you get if you multiply them together?
def findTwo(l):
    for i in l:
        if 2020-i in l:
            return i*(2020-i)

# B
# What is the product of the three entries that sum to 2020?
def findThree(l):
    l2 = [i for i in l if i < 2020-l[0]-l[1]]
    for i in l2:
        for j in l2[l2.index(i):]:
            if 2020-i-j in l2:
                return i*j*(2020-i-j)

with open("Day1_input.txt") as f:
    l = sorted([int(i) for i in f.read().splitlines()])

print(findTwo(l))
print(findThree(l))
