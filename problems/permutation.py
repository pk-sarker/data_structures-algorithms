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

    def permute2(self, nums, values=[]):
        if not nums:
            return [values]
        result = []
        for i in range(len(nums)):
            result += self.permute2(nums[:i] + nums[i + 1:], values + [nums[i]])
        return result


print(Permutation().permute([3, 2, 1]))

print(Permutation().permute2([3, 2, 1]))
