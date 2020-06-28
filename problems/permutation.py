class Permutation:
    def _permutationHelper(self, arr, start=0):
        if start == len(arr):
            return [arr[:]]
        result = []
        for i in range(start, len(arr)):
            arr[start], arr[i] = arr[i], arr[start]
            result += self._permutationHelper(arr, start + 1)
            arr[start], arr[i] = arr[i], arr[start]
        return result

    def permute(self, arr):
        return self._permutationHelper(arr)


print(Permutation().permute([3, 2, 1]))
