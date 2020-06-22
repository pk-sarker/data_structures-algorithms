#
#  342    -> Link List: 2 -> 4 -> 3
# +465    -> Link List: 5 -> 6 -> 4
# -----               ----------------
# 807                  7 -> 0 -> 8
class Node:
    def __init__(self, value):
        self.value = value;
        self.next = None

class Calculator:
    def add_two_numbers(self, n1, n2):
        return self.add(n1, n2, 0)

    def add(self, l1, l2, co):
        sum = l1.value + l2.value + co
        co = sum / 10
        new_node = Node(sum % 10)

        if l1.next is not None or l2.next is not None:
            if not l1.next:
                l1.next = Node(0)
            if not l2.next:
                l2.next = Node(0)
            new_node = self.add(l1.next, l2.next, co)
        return new_node


ll1 = Node(2)
ll1.next = Node(4)
ll1.next.next = Node(3)

ll2 = Node(5)
ll2.next = Node(6)
ll2.next.next = Node(4)

ll3 = Calculator().add_two_numbers(ll1, ll2)

while ll3:
    print(ll3.value)
    ll3 = ll3.next
