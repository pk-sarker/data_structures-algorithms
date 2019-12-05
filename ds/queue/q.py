class Queue:
    def __init__(self, size=1000):
        self.size = size
        self.__q = [None] * self.size
        self.__head = 0
        self.__tail = -1

    def enqueue(self, value):
        print("Enqueue: ", value)
        if self.full():
            self.__tail = 0
        else:
            self.__tail = self.__tail + 1
        self.__q[self.__tail] = value

    def dequeue(self):
        if self.empty():
            print("Queue is empty.")
            return None
        else:
            element = self.__q[self.__head]
            self.__q[self.__head] = None
            if self.__head == self.size:
                self.__head = 0
            else:
                self.__head = self.__head + 1
            print("Dequeue: ", element)
            return element

    def empty(self):
        if self.__head == self.__tail:
            return True
        else:
            return False

    def full(self):
        if self.__tail == self.size - 1:
            return True
        else:
            return False

    def print(self):
        queued_items = ""
        for item in self.__q:
            if item is not None:
                queued_items += str(item) + " "
        print(queued_items)


if __name__ == "__main__":
    q = Queue()
    q.enqueue(5)
    q.enqueue(9)
    q.enqueue(2)
    q.print()
    q.dequeue()
    q.print()
    q.enqueue(-3)
    q.enqueue(-2)
    q.print()
    q.dequeue()
    q.enqueue(1)
    q.print()