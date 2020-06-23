class Calculator:
    def isSumOfTwoMatch(self, numbers, target):
        for n1 in numbers:
            for n2 in numbers:
                if n1 == n2:
                    continue
                if n1 + n2 == target:
                    # print(str(n1) + ' ' + str(n2))
                    return True
        return False

    # Returns the position of the numbers
    def findSumOfTwo(self, numbers, target):
        for i, n1 in enumerate(numbers):
            for j, n2 in enumerate(numbers):
                if n1 == n2:
                    continue
                if n1 + n2 == target:
                    return [i, j]
        return []


print(Calculator().isSumOfTwoMatch([1, 4, 6, 9, 3, 16, 7], 16))

print(Calculator().findSumOfTwo([1, 4, 6, 9, 3, 16, 7], 16))
