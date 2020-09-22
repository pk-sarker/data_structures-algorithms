class Solution:
  def uniqueOccurrences(self, arr):
    print("Input: {}".format(arr))
    hmap = {}
    for n in arr:
      hmap[n] = hmap.get(n, 0) + 1
    seen = []
    for key in hmap.keys():
      # print(">> {}".format(hmap.get(key)))
      if hmap.get(key) in seen:
        return False
      seen.append(hmap.get(key))
    return True


print("Output: {}".format(str(Solution().uniqueOccurrences([1,3,2,2,1,1,3]))))
print("Output: {}".format(str(Solution().uniqueOccurrences([1,3,2,2,1,1]))))