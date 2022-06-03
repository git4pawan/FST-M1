# Define function to calculate sum
def calculateSum(num):
  if num:
    # Recursive function call
    return num + calculateSum(num-1)
  else:
    return 0

# Call calculateSum() function
#inNum = int(input("Enter a Interger number "))
res = calculateSum(int(input("Enter a Interger number ")))

# Print result
print(res)