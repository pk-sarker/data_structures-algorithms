class MaxStack:
    def __init__(self):
        self.stack = []
        self.max_stack = []

    def push(self, value):
        self.stack.append(value)
        if self.max_stack and self.max_stack[-1] > value:
            self.max_stack.append(self.max_stack[-1])
        else:
            self.max_stack.append(value)

    def pop(self):
        if self.max_stack:
            self.max_stack.pop()
        return self.stack.pop()

    def print(self):
        for x in self.stack:
            print(x)

    def max(self):
        if self.max_stack:
            return self.max_stack[-1]
        else:
            return None

ms = MaxStack()
ms.push(1)
print("PUSH 1")
ms.push(2)
print("PUSH 2")
ms.push(1)
print("PUSH 1")
ms.push(3)
print("PUSH 3")
print('------')
print("Max {}".format(ms.max()))

print("POP {} Max {}".format(ms.pop(), ms.max()))
print("POP {} Max {}".format(ms.pop(), ms.max()))
print("POP {} Max {}".format(ms.pop(), ms.max()))
print("POP {} Max {}".format(ms.pop(), ms.max()))