class Calculator:
    def findSumOfTwo(self, numbers, target):
        hash_map = {}
        for i, n in enumerate(numbers):
            diff = target - n
            if diff in hash_map:
                return [i, hash_map[diff]]
            hash_map[n] = i
        return []


print(Calculator().findSumOfTwo([1, 4, 6, 9, 3, 16, 7], 16))