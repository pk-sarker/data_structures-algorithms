class QuickSort:
    def sort(self, arr, low, high):
        if low < high:
            p = self.partition(arr, low, high)
            self.sort(arr, low, p-1)
            self.sort(arr, p+1, high)

    def partition(self, arr, low, high):
        pivot = arr[high]
        i = low
        for x in range(low, high):
            if arr[x] < pivot:
                arr[i], arr[x] = arr[x], arr[i]
                i += 1
        arr[i], arr[high] = arr[high], arr[i]
        return i


ar = [4, 9, 1, 0, 5, 8, 6, 4, 7]
QuickSort().sort(ar, 0, len(ar)-1)
print(ar)
