# Phase A – miniPython: Lexer & Parser 

This phase includes the implementation of a **Lexer** and a **Parser** for a subset of the **miniPython** language, using the **SableCC** tool.

The grammar is defined in the `minipython.grammar` file and includes:

- Syntactic elements such as: `if`, `while`, `for`, `def`, `return`, `print`, `import`
- Expressions: arithmetic, logical, and comparison operators
- Control structures and loops
- Functions, arrays, and function calls
- Support for string literals with both `'` and `"`
- Python-style comments (`#`)

### Build

```bash
java -jar sablecc.jar minipython.grammar
sablecc minipython.grammar
```

### Compilation
```bash
javac -cp . ParserTest.java LexerTest.java
```

### Running Examples
```bash
# Lexical Analysis
java LexerTest miniPythonExample.py

# Syntax Analysis
java ParserTest miniPythonExample.py
```
## Sample run
miniPython code `miniPythonExample.py`
```python
def add(a, b):
    return a + b

result = add(None, 3)  # Error: None in addition

p = 5 + 5 - None
```
### Lexical Analysis
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
### Syntax Analysis
```sh
def add ( a , b ) : return a + b result = add ( None , 3 ) p = 5 + 5 - None
```
