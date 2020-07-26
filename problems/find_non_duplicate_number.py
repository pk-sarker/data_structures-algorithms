class Practice:
    def find_non_duplicate_number_using_hashmap(self, arr):
        occurrence = {}
        for n in arr:
            occurrence[n] = occurrence.get(n, 0) + 1
        for key, value in occurrence.items():
            if value == 1:
                return key
    def find_non_duplicate_number(self, arr):
        res = 0
        for n in arr:
            res = res ^ n
        return res


arr = [4, 8, 3, 5, 4, 2, 5, 3, 8]
print("Input: {}".format(arr))
print("Output: {}".format(Practice().find_non_duplicate_number(arr)))

print("- - - - - - - - - - - - - - - - - - - - - - - - - - - - ")
print("Input: {}".format(arr))
print("Output: {}".format(Practice().find_non_duplicate_number_using_hashmap(arr)))



