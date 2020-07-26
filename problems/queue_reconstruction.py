class Queue:
    def reconstruct(self, arr):
        # Sort by persons height in descending order, for person with same height sort by position
        arr.sort(key=lambda x: (-x[0], x[1]))
        # [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
        print("After sort: {}".format(arr))
        queue = []
        for person in arr:
            # '.insert' method inserts an element at a specific position in the list by shifting other elements.
            queue.insert(person[1], person)

        return queue


arr = [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
print("Input: {}".format(arr))
print("Output: {}".format(Queue().reconstruct(arr)))
# [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]


arr1 = [[6, 4], [6, 2], [2, 3], [9, 0], [7, 0], [5, 6], [8, 1], [7, 3], [2, 0], [6, 0]]
print("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ")
print("Input: {}".format(arr1))
print("Output: {}".format(Queue().reconstruct(arr1)))
# [[2,0], [6,0], [7,0], [2,3], [6,2], [9,0], [5,6], [8,1], [6, 4], [7, 3]]