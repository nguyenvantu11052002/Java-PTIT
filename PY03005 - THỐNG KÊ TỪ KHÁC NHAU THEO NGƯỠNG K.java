import math

def TC():
    m = {}
    n, k = [int(x) for x in input().split()]
    for i in range(n):
        s = input().lower() + " ";
        res = ""
        for j in s:
            if j.isdigit() or j.isalpha():
                res += j
            else:
                if res != "":
                    if res in m:
                        m[res] += 1
                    else:
                        m[res] = 1
                    res = ""
    m = sorted(m.items(), key= lambda x : (-x[1], x[0]))
    for i in m:
        if i[1] >= k:
            print(i[0], i[1])

t = 1
#t = int(input())
for i in range(t): TC()

# 3 2
# PTIT duy tri hoc phi on dinh nam 2019 va khong tang trong nam 2020-2021 va 2021-2022!
# Khi dich benh xuat hien PTIT trich hon 6 ty dong ho tro sinh vien PTIT
# voi muc ho tro 500000 dong/sinh vien PTIT.





