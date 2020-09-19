class Product:
  def product_of_array(self, nums):
    print("Input: {}".format(nums))
    n = len(nums)
    left, right, product = [0] * n, [0] * n, [1] * n

    left[0] = 1
    for i in range(1, n):
      left[i] = nums[i-1] * left[i-1]

    right[n-1] = 1
    for i in range(n-2, -1, -1):
      right[i] = right[i + 1] * nums[i + 1]
      product[i] = left[i] * right[i]
    product[n-1] = left[n-1] * right[n-1]
    return product

print("Output: {}".format(Product().product_of_array([4, 5, 9, 3])))
print("Output: {}".format(Product().product_of_array([1, 2, 3, 4])))
