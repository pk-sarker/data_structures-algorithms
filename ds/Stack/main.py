from stack import Stack


if __name__ == "__main__":
    stack = Stack()
    stack.push(3)
    stack.push(7)
    stack.push(2)
    stack.push(1)
    stack.print()
    print("Popped: ", stack.pop())
    stack.print()
    stack.push(9)
    stack.push(5)
    stack.print()
