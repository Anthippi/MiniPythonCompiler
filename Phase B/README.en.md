# Phase B – miniPython: AST & Semantic Analysis [![Static Badge](https://img.shields.io/badge/English-orange)](README.en.md)

This phase involves the construction of an **Abstract Syntax Tree (AST)** for programs written in miniPython using **SableCC**, as well as the implementation of **semantic analysis**, which includes symbol table construction, type checking, and detection of semantic errors.

## Build
```bash
sablecc minipython.grammar
```
## Compilation
```bash
javac -cp . ASTTest.java ParserTest.java
```
## Execution
```bash
java ParserTest example.py
```
You can find example programs in the [minipython code examples folder](https://github.com/Anthippi/MiniPythonCompiler/tree/main/Phase%20B/examples).

## Semantic Analysis
Semantic analysis is implemented using visitor classes that traverse the AST and perform the required checks.

## Recognized Semantic Errors
- Use of undeclared variables
- Calling undeclared functions
- Incorrect number/type of function arguments
- Type incompatibility in expressions
- Operations involving None
- Improper use of return values
- Redeclaration of functions with conflicting parameters or default values
