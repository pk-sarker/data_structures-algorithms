# Stack

## Pseudocode
Check if Stack is empty
```
STACK-EMPTY(S)
1 if S:top == 0
2   return TRUE
3 else return FALSE
```


Add new element to Stack
```
PUSH(S,x)
1 S.top = S.top + 1
2 S[S.top] = x
```

Remove element from Stack
```
POP(S)
1  if STACK-EMPTY(S)
2     error “underflow”
3  else S.top = S:top - 1
4 return S[S.top] + 1
```