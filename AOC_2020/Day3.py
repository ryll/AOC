def countTrees(map,right,down):
    count,n,w = 0,1+right,len(map[0])
    for row in map[down:len(map):down]:
        if row[n%w-1] is '#':
            count += 1
        n += right
    return count



with open("Day3_input.txt") as f:
    map = [x.strip() for x in f.readlines()]

ans = 1
for n in [(1,1),(3,1),(5,1),(7,1),(1,2)]:
    ans *= countTrees(map,n[0],n[1])
print(countTrees(map,3,1))
print(ans)