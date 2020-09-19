# 1 + 23 - 4 = 20
# 2 - (19 - 16) + 5 = 4
# 123 = 123

class Calculator:

  # Evaluate sub-expression
  def _eval(self, stack):
    sum = stack.pop()
    while stack and stack[-1] != ')':
      operator = stack.pop()
      if operator == '+':
        sum += stack.pop()
      if operator == '-':
        sum -= stack.pop()

    return sum

  def evaluate_expression(self, exp):
    print("Expression: {}".format(exp))
    exp_len = len(exp)
    operand = 0
    number_len = 0
    stack = []

    for i in range(exp_len - 1, -1, -1):
      if exp[i].isdigit():
        operand = 10 ** number_len * int(exp[i]) + operand
        number_len += 1
      elif exp[i] != ' ':
        if number_len > 0:
          stack.append(operand)
          operand = 0
          number_len = 0
        if exp[i] == "(":
          sum = self._eval(stack)
          stack.pop()
          stack.append(sum)
        else:
          stack.append(exp[i])
      if number_len > 0:
        stack.append(operand)

    return self._eval(stack)


print("Sum {} ".format(Calculator().evaluate_expression('1+23-4')))
print("Sum {} ".format(Calculator().evaluate_expression('2-(19-16)+5')))
print("Sum {} ".format(Calculator().evaluate_expression('123')))