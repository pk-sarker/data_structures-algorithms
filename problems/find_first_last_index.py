import math


class Search:
    def find_first_and_last_index(self, arr, target):
        first = self.binary_search(arr, target, 0, len(arr) - 1, True)  # Find  first index of target
        last = self.binary_search(arr, target, 0, len(arr) - 1, False)  # Find  last index of target

        return [first, last]

    def binary_search(self, arr, target, low, high, find_first):
        if low > high:
            return -1
        mid = math.floor((low + high) / 2)
        if find_first:
            if (mid == 0 or arr[mid - 1] < target) and arr[mid] == target:
                return mid
            if target > arr[mid]:
                return self.binary_search(arr, target, mid+1, high, find_first)
            else:
                return self.binary_search(arr, target, low, mid-1, find_first)
        else:
            if (mid == len(arr) - 1 or arr[mid + 1] > target) and arr[mid] == target:
                return mid
            if target < arr[mid]:
                return self.binary_search(arr, target, low, mid - 1, find_first)
            else:
                return self.binary_search(arr, target, mid + 1, high, find_first)


print(Search().find_first_and_last_index([1, 2, 2, 3, 6, 7, 8, 8, 8, 13, 13, 13, 14], 13))