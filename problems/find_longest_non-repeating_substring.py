def find_longest_substring(str):
    hash_map = {}
    start = -1
    end = 0
    result = 0

    while end < len(str):
        c = str[end]
        # move start index if duplicate found
        if c in hash_map:
            start = max(start, hash_map[c])

        # get maximum of previous result and current result
        result = max(result, end - start)

        # Update/add index of `c`
        hash_map[c] = end
        # Increase index of end/ move to next char
        end += 1
    return result


str = "AABCBDCAEDBF"
print("String: {}".format(str))
print("Max Length: {}".format(find_longest_substring(str)))
