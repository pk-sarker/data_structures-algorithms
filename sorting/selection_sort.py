class SelectionSort:
    def sort(self, arr):
        for i in range(0, len(arr)):
            min_i = i
            for j in range(i+1, len(arr)):
                if arr[min_i] > arr[j]:
                    min_i = j
            arr[i], arr[min_i] = arr[min_i], arr[i]
        return arr


ar = [9, 8, 5, 4, 1, 3, 7, 0, 5]

print(SelectionSort().sort(ar))