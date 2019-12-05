class Stack:

    def __init__(self) -> object:
        self.__stack = [None] * 1000
        self.__top = -1

    def push(self, value):
        print("Push ", value)

        if self.__top == 1000:
            self.__top = 0
        else:
            self.__top = self.__top + 1

        self.__stack[self.__top] = value

    def pop(self):
        temp = self.__stack[self.__top]
        self.__stack[self.__top] = None
        self.__top = self.__top - 1
        print("Pop ", temp)
        return temp

    def print(self):
        stack_items = ""
        for item in self.__stack:
            if item is not None:
                stack_items += str(item) + " "
        print(stack_items)