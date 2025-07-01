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

## Sample run
miniPython code `miniPythonExample.py`
```python
def add(a, b):
    return a + b

result = add(None, 3)  # Error: None in addition

p = 5 + 5 - None
```

### Abstract Syntax Tree
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
### Detection of semantic errors
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
