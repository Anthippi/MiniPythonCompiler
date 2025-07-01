# Phase B - miniPython: AST & Symbol Semantic [![Static Badge](https://img.shields.io/badge/English-orange)](README.en.md)

Αυτή η φάση περιλαμβάνει τη δημιουργία Αφηρημένου Συντακτικού Δέντρου (AST) για προγράμματα γραμμένα σε miniPython με χρήση του SableCC. 'Οπως και την υλοποίηση της Σημασιολογικής Ανάλυσης, η οποία περιλαμβάνει τη δημιουργία πίνακα συμβόλων, τον έλεγχο τύπων και την εντοπισμό σημασιολογικών λαθών.

## Build 
```bash
sablecc minipython.grammar
```
## Compilation
```bash
javac -cp . ASTTest.java ParserTest.java
```

## Εκτέλεση
```bash
java ParserTest example.py
```

Παραδείγματα [minipython code](https://github.com/Anthippi/MiniPythonCompiler/tree/main/Phase%20B/examples).

## Παράδειγμα εκτέλεσης
miniPython code `miniPythonExample.py`
```python
def add(a, b):
    return a + b

result = add(None, 3)  # Error: None in addition

p = 5 + 5 - None
```

### Αφηρημένο Συντακτικό Δέντρο
```sh
  >- AGoal
     |- AFuncFunctionOrStatement
     |  `- AFunction
     |     |- AIdentifier
     |     |  `- add
     |     |- AArgument
     |     |  |- AIdentifier
     |     |  |  `- a
     |     |  `- AArgumentAdditionalAssign
     |     |     `- AIdentifier
     |     |        `- b
     |     `- AReturnStatement
     |        `- AAdditionExpression
     |           |- AIdentifierExpression
     |           |  `- AIdentifier
     |           |     `- a
     |           `- AIdentifierExpression
     |              `- AIdentifier
     |                 `- b
     |- AStatFunctionOrStatement
     |  `- AAssignEqStatement
     |     |- AIdentifier
     |     |  `- result
     |     `- AFCallExpression
     |        `- AFunctionCall
     |           |- AIdentifier
     |           |  `- add
     |           `- AArglist
     |              |- AValueExpression
     |              |  `- ANoneValue
     |              |     `- None
     |              `- AAdditionalExpression
     |                 `- AValueExpression
     |                    `- ANumberValue
     |                       `- AIntegerNumber
     |                          `- 3
     `- AStatFunctionOrStatement
        `- AAssignEqStatement
           |- AIdentifier
           |  `- p
           `- ASubtractionExpression
              |- AAdditionExpression
              |  |- AValueExpression
              |  |  `- ANumberValue
              |  |     `- AIntegerNumber
              |  |        `- 5
              |  `- AValueExpression
              |     `- ANumberValue
              |        `- AIntegerNumber
              |           `- 5
              `- AValueExpression
                 `- ANoneValue
                    `- None
```
### Eντοπισμός σημασιολογικών λαθών
```sh
 *** Commencing Checks! ***

 *** No errors found in 1st Visit. Proceeding . . . ***

! Warning: 'None' used outside an operation at line: 4

!!! Error in line 4: Mismatched types in addition expression. Left side is None and right side is Number

!!! Error in line 4: Cannot perform addition with None.

!!! Error in line 6: Found 'None' used in subtraction
!!! Error in line 6 Mismatched types in subtraction expression. Left side is Number and right side is None

!!! Error in line 6: Cannot perform subtraction with None.

 *** All visitors completed. ***

 *** Found 5 errors on visitor2 ***
```


## Σημασιολογική Ανάλυση
Η σημασιολογική ανάλυση υλοποιείται με επισκέπτες (Visitors) που διατρέχουν το AST και πραγματοποιούν τους απαραίτητους ελέγχους.

## Αναγνωριζόμενα Λάθη
- Χρήση μη δηλωμένης μεταβλητής
- Κλήση μη δηλωμένης συνάρτησης
- Λάθος αριθμός/είδος ορισμάτων σε συνάρτηση
- Ασυμβατότητα τύπων σε εκφράσεις
- Πράξεις με None
- Ακατάλληλη χρήση τιμής επιστροφής
- Επαναδήλωση συνάρτησης με συμβατά ορίσματα/defaults
