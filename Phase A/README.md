# Phase A – miniPython: Lexer & Parser [![Static Badge](https://img.shields.io/badge/English-orange)](README.en.md)

Αυτή η φάση περιλαμβάνει την υλοποίηση ενός **λεξικού αναλυτή (Lexer)** και ενός **συντακτικού αναλυτή (Parser)** για μια υποσύνολο της γλώσσας **miniPython**, χρησιμοποιώντας το εργαλείο **SableCC**.

Η γραμματική έχει οριστεί στο αρχείο `minipython.grammar` και περιλαμβάνει:

- Συντακτικά στοιχεία όπως: `if`, `while`, `for`, `def`, `return`, `print`, `import`
- Εκφράσεις: αριθμητικές, λογικές, συγκρίσεις
- Δομές ελέγχου και βρόχους
- Συναρτήσεις, πίνακες, και κλήσεις συναρτήσεων
- Υποστήριξη για συμβολοσειρές με `'` και `"`
- Σχόλια Python (`#`)

### Build

```bash
java -jar sablecc.jar minipython.grammar
sablecc minipython.grammar
```

### Compilation
```bash
javac -cp . ParserTest.java LexerTest.java

```

## Εκτέλεση Παραδειγμάτων
```bash
# Λεξική Ανάλυση
java LexerTest miniPythonExample.py

# Συντακτική Ανάλυση
java ParserTest miniPythonExample.py
```
## Παράδειγμα εκτέλεσης
miniPython code `miniPythonExample.py`
```python
def add(a, b):
    return a + b

result = add(None, 3)  # Error: None in addition

p = 5 + 5 - None
```
### Λεξική Ανάλυση
 ```sh
TDef: def
TWhitespace:
TId: add
TLeftParenthesis: (
TId: a
TComa: ,
TWhitespace:
TId: b
TRightParenthesis: )
TColon: :
TWhitespace:

TWhitespace:
TWhitespace:
TWhitespace:
TWhitespace:
TReturn: return
TWhitespace:
TId: a
TWhitespace:
TPlus: +
TWhitespace:
TId: b
TWhitespace:

TWhitespace:

TId: result
TWhitespace:
TAssign: =
TWhitespace:
TId: add
TLeftParenthesis: (
TNone: None
TComa: ,
TWhitespace:
TNum: 3
TRightParenthesis: )
TWhitespace:
TWhitespace:
TCommentStart: #
TCommentText:  Error: None in addition
TEndComment:

TWhitespace:

TId: p
TWhitespace:
TAssign: =
TWhitespace:
TNum: 5
TWhitespace:
TPlus: +
TWhitespace:
TNum: 5
TWhitespace:
TMinus: -
TWhitespace:
TNone: None
```
### Συντακτική Ανάλυση
```sh
def add ( a , b ) : return a + b result = add ( None , 3 ) p = 5 + 5 - None
```

