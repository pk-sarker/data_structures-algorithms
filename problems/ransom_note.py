from collections import defaultdict


class RansomNote:
    def canConstruct(self, note, magazine):
        letter_map = defaultdict(int)
        for l in magazine:
            letter_map[l] += 1
        for c in note:
            if letter_map[c] <= 0:
                return False
            letter_map[c] -= 1
        return True


print("Is it possible to construct a ransom note 'abadc' using 'aazzbccdy' magazine")
print(RansomNote().canConstruct('abadc', 'aazzbccdy'))
print("Is it possible to construct a ransom note 'aebe' using 'aazebccdy' magazine")
print(RansomNote().canConstruct('aebe', 'aazebccdy'))
