

passports = []
temp = []
checks = ('byr','iyr','eyr','hgt','hcl','ecl','pid')

def checkKeys(p):
    return all(any(x in item for item in p.keys()) for x in checks)


def checkValues(p):
    if not checkKeys(p):
        return False
    elif not 1920 <= int(p['byr']) <= 2002: # byr (Birth Year) - four digits; at least 1920 and at most 2002.
        return False
    elif not 2010 <= int(p['iyr']) <= 2020: # iyr (Issue Year) - four digits; at least 2010 and at most 2020.
        return False
    elif not 2020 <= int(p['eyr']) <= 2030: # eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
        return False
    elif not ((p['hgt'][-2:] == 'cm' and 150 <= int(p['hgt'][:-2]) <= 193) or (p['hgt'][-2:] == 'in' and 59 <= int(p['hgt'][:-2]) <= 76)): # hgt (Height) - a number followed by either cm or in: # If cm, the number must be at least 150 and at most 193. # If in, the number must be at least 59 and at most 76.
        return False
    elif not (p['hcl'][0] == '#' and len(p['hcl']) == 7 and all(x in 'abcdef0123456789' for x in p['hcl'][1:])): # hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
        return False
    elif not p['ecl'] in ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth']: # ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
        return False
    elif not (p['pid'].isdigit() and len(p['pid']) == 9): # pid (Passport ID) - a nine-digit number, including leading zeroes.
        return False
    
    return True


with open("Day4_input.txt") as f:
    for line in f:
        if line is '\n':
            passports.append({k:v for [k,v] in [x.split(':') for x in temp]})
            temp = []
        else:
            temp.extend(line.strip().split())
    passports.append({k:v for [k,v] in [x.split(':') for x in temp]})

#Problem 1
print(sum([checkKeys(x) for x in passports]))

#Problem 2
print(sum([checkValues(x) for x in passports]))