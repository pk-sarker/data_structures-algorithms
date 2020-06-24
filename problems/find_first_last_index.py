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
            if arr[mid] == target:
                if mid == 0:
                    return mid
                elif arr[mid - 1] < target:
                    return mid
                elif arr[mid - 1] == target:
                    return self.binary_search(arr, target, low, mid - 1, find_first)
            if target > arr[mid]:
                return self.binary_search(arr, target, mid+1, high, find_first)
            else:
                return self.binary_search(arr, target, low, mid-1, find_first)
        else:
            if arr[mid] == target:
                if mid == len(arr) - 1:
                    return mid
                if arr[mid + 1] > target:
                    return mid
                elif arr[mid + 1] == target:
                    return self.binary_search(arr, target, mid + 1, high, find_first)
            if target > arr[mid]:
                return self.binary_search(arr, target, mid+1, high, find_first)
            else:
                return self.binary_search(arr, target, low, mid-1, find_first)


print(Search().find_first_and_last_index([1, 2, 2, 3, 6, 7, 8, 8, 8, 13, 13, 13, 14], 13))