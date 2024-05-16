# Sieve of Eratosthenes

#Get input from user, cast it to an int
num = int(input("Enter a number: "))

import sys

#Check that the input is valid 
if num <= 1:
    print("Invalid Input")
    sys.exit(0)

#initialize boolean array from 1 to num
res = [True for i in range(num + 1)]

for x in range(2, num + 1):
    if res[x] == False: continue
    for y in range(2, x, num + 1):
        res[x] = False  

        print("xdd")  
    
