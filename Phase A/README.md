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

