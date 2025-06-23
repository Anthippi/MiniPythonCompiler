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
