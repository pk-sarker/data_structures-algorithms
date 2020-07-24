# Problem:
# Given two linked-lists representing two non-negative integers.
# The digits are stored in reverse order and each of their nodes contain a single digit.
# Add the two numbers and return it as a linked list.
#
# Example:
#  543    -> Link List: 3 -> 4 -> 5
# +465    -> Link List: 5 -> 6 -> 4
# -----               -------------------
# 1008                  8 -> 0 -> 0 -> 1

class Node:
    def __init__(self, value):
        self.value = value;
        self.next = None

class Calculator:
    def add_two_numbers(self, n1, n2):
        return self.add(n1, n2, 0)

    def add(self, l1, l2, co):
        sum = l1.value + l2.value + co
        co = sum // 10
        new_node = Node(sum % 10)
        if l1.next is not None or l2.next is not None:
            if not l1.next:
                l1.next = Node(0)
            if not l2.next:
                l2.next = Node(0)
            new_node.next = self.add(l1.next, l2.next, co)
        elif co:
            new_node.next = Node(co)
        return new_node

ll1 = Node(3)
ll1.next = Node(4)
ll1.next.next = Node(5)

ll2 = Node(5)
ll2.next = Node(6)
ll2.next.next = Node(4)

print("Number - Reverse")
print(" {}   - {}".format(543, 345))
print(" {}   - {}".format(465, 564))
print("1008 ")
# 8 -> 0 -> 10
# 8 -> 0 -> 0 -> 1

ll3 = Calculator().add_two_numbers(ll1, ll2)

while ll3:
  print(ll3.value, end=' ')
  ll3 = ll3.next
