class MergeSort:

    def sort(self, arr):
        if len(arr) > 1:
            mid = len(arr)//2
            left = arr[:mid]
            right = arr[mid:]
            self.sort(left)
            self.sort(right)
            self._merge(arr, left, right)

    def _merge(self, arr, left, right):
        i = j = k = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                arr[k] = left[i]
                i = i + 1
            else:
                arr[k] = right[j]
                j = j + 1
            k = k + 1

        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1


ar = [7, 2, 1, 6, 3, 2, 0, 9, 8, 6, 0]
MergeSort().sort(ar)
print(ar)