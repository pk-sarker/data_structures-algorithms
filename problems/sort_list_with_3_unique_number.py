class Sort:
    def usingHashMap(self, arr):
        counts = {}
        for n in arr:
            counts[n] = counts.get(n, 0) + 1
        return ([1] * counts.get(1, 0) + [2] * counts.get(2, 0) + [3] * counts.get(3, 0))

    def inplace(self, arr):
        l = 0
        r = len(arr) - 1
        i = 0

        while i <= r:
            if arr[i] == 1:
                arr[i], arr[l] = arr[l], arr[i]
                l += 1
                i += 1
            elif arr[i] == 2:
                i += 1
            elif arr[i] == 3:
                arr[i], arr[r] = arr[r], arr[i]
                r -= 1
        return arr


ar = [1, 3, 2, 1, 2, 3, 1, 2, 1]
print("List to sort: {}".format(ar))
print('\nSort using Hash Map')
print(Sort().usingHashMap(ar))

print('\nIn place Sort')
print(Sort().inplace(ar))
