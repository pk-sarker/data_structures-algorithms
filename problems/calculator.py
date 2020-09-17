class Calculator:

  def evaluate(self, expression):
    (sum, index) = self._eval(expression, 0)
    return sum

  def _eval(self, expression, index):
    operator = '+'
    sum = 0

    while index < len(expression):
      char = expression[index]
      if char in ('+', '-'):
        operator = char
      else:
        value = 0
        if char.isdigit():
          value = int(char)
        if char == '(':
          (value, index) = self._eval(expression, index + 1)
        if operator == '+':
          sum += value
        if operator == '-':
          sum -= value
      index += 1
    return (sum, index)

print(Calculator().evaluate('4+(2-5)-3'))
