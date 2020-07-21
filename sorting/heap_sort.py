# Heapsort implementation
#
class HeapSort:

    def max_heapify(self, arr, heap_size, i):
        l = self.left(i)
        r = self.right(i)
        largest = i
        if l < heap_size and arr[l] > arr[i]:
            largest = l
        if r < heap_size and arr[r] > arr[largest]:
            largest = r
        if largest != i:
            arr[i], arr[largest] = arr[largest], arr[i]
            self.max_heapify(arr, heap_size, largest)

    def sort(self, arr):
        heap_size = len(arr)
        # Build heap
        for i in range(heap_size//2 - 1, -1, -1):
            self.max_heapify(arr, heap_size, i)

        for i in range(heap_size - 1, 0, -1):
            arr[i], arr[0] = arr[0], arr[i]
            self.max_heapify(arr, i, 0)

    def left(self, i):
        return 2 * i + 1

    def right(self, i):
        return 2 * i + 2


ar = [7, 2, 1, 6, 3, 2, 0, 9, 8, 6, 0]
print("Given array: {}".format(ar))
HeapSort().sort(ar)
print("Sorted array is: {}".format(ar))