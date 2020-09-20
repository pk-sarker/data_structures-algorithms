class Solution:
  def check(self, ar):
    print("Input: {}".format(ar))
    index = -1
    for i in range(0, len(ar) - 1):
      if ar[i] > ar[i + 1]:
        if index != -1:
          return False
        else:
          index = i

    if index == -1 or index == 0 or index == len(ar) - 2 or ar[index + 2] >= ar[index] or ar[index + 1] >= ar[
      index - 1]:
      return True

    return False


  def check_and_fix(self, ar):
    print("Input: {}".format(ar))
    index = -1
    for i in range(0, len(ar) - 1):
      if ar[i] > ar[i + 1]:
        if index != -1:
          return False
        else:
          index = i

    if index == -1:
      return ar
    if index == 0:
      ar[index] = ar[index+1]
      return ar
    if index == len(ar) - 2:
      ar[index+1] = ar[index]
      return ar
    if ar[index + 2] >= ar[index]:
      ar[index + 1] = ar[index+2]
      return ar
    if ar[index + 1] >= ar[index - 1]:
      ar[index] = ar[index + 1]
      return ar

    return False


print("Output: " + str(Solution().check([5, 3, 4])))  # True
print("Output: " + str(Solution().check([2, 5, 3])))  # True
print("Output: " + str(Solution().check([2, 3, 5, 1, 7])))  # True
print("Output: " + str(Solution().check([2, 3, 7, 5, 6])))  # True
print("Output: " + str(Solution().check([1, 4, 1, 2]))) # True
print("Output: " + str(Solution().check([1, 4, 0, 4]))) # True

print("Output: " + str(Solution().check([3, 1, 5, 7, 3])))  # False
print("Output: " + str(Solution().check([2, 4, 5, 2, 4])))  # False

print("Output: " + str(Solution().check_and_fix([1, 4, 1, 2])))
print("Output: " + str(Solution().check_and_fix([1, 4, 0, 4])))
print("Output: " + str(Solution().check_and_fix([2, 3, 5, 1, 7])))



