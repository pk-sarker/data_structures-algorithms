import math


class BinarySearch:
    def search(self, numbers, target, low, high):
        mid = math.floor((low + high) / 2)
        # print("{} {} {} => {}".format(low, high, mid, numbers[mid]))
        if low > high:
            return "Could not find " + str(target)
        if numbers[mid] == target:
            return mid
        if target > numbers[mid]:
            low = mid + 1
            return self.search(numbers, target, low, high)
        if target < numbers[mid]:
            high = mid - 1
            return self.search(numbers, target, low, high)

    def find(self, ar, num):
        return self.search(ar, num, 0, len(ar) - 1)


print("{}".format(BinarySearch().find([1, 1, 3, 4, 5, 7, 9, 10, 11, 11, 13], 11)))