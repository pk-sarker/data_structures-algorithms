def find_pythagorean_triplet_brute_force(arr):
    for a in arr:
        for b in arr:
            for c in arr:
                if a*a + b*b == c*c:
                    return True

    return False


def find_pythagorean_triplet(arr):
    sq = set([n*n for n in arr])
    for a in arr:
        for b in arr:
            if a*a + b*b in sq:
                return True
    return False


ar = [8, 1, 7, 17, 9, 15, 2]
ar1 = [8, 1, 7, 17, 9, 14, 2]
print(ar)
print(find_pythagorean_triplet_brute_force(ar))
print(find_pythagorean_triplet(ar))
print(ar1)
print(find_pythagorean_triplet(ar1))