#! /usr/bin/env/python3
# -*-coding=utf8-*-

# """方式一"""

days = int(input("Enter days: "))
months = days // 30
days = days % 30

print("Months ={} Days={}".format(months, days))

# '''方式二'''

# days=int(input("Enter days: "));
print("Months={} Days={}".format(*divmod(days, 30)))
