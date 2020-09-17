class Dominoes:

  def push_dominoes(self, dominoes):
    total_dominoes = len(dominoes)
    forces = [0] * total_dominoes

    force = 0
    for i, d in enumerate(dominoes):
      if d == 'R':
        force = total_dominoes
      elif d == 'L':
        force = 0
      else:
        force = max(0, force - 1)
      forces[i] = force

    force = 0
    for i in range(total_dominoes -1, -1, -1):
      if dominoes[i] == 'L':
        force = -1 * total_dominoes
      elif dominoes[i] == 'R':
        force = 0
      else:
        force = min(0, force + 1)
      forces[i] += force

    result = ''
    for i in forces:
      if i == 0:
        result += '.'
      if i > 0:
        result += 'R'
      if i < 0:
        result += 'L'

    return result


print('Input: \t .L.R...LLR.R....LR..')
print('Output:\t {}'.format(Dominoes().push_dominoes('.L.R...LLR.R....LR..')))

print('Input: \t .L.R...LR..L..')
print('Output:\t {}'.format(Dominoes().push_dominoes('.L.R...LR..L..')))
# .LRRRRRLRRRLRR
# LL.RR.LLRRLL..

print('Input: \t RR.L')
print('Output:\t {}'.format(Dominoes().push_dominoes('RR.L')))

LL.RR.LLRRLL..
LL.RR.LLRRLL..