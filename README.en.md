# MiniPython Compiler

This project involves the implementation of a **compiler** for the **miniPython** language, which is a subset of Python. The project is developed in two phases using the **[SableCC](https://sablecc.org)** tool.

## Project Structure

The project consists of two main phases:

- **[Phase A](https://github.com/Anthippi/MiniPythonCompiler/blob/main/Phase%20A)**  
  - Lexical Analysis  
  - Syntax Analysis  

- **[Phase B](https://github.com/Anthippi/MiniPythonCompiler/blob/main/Phase%20B)**  
  - Abstract Syntax Tree (AST) Construction  
  - Symbol Table & Semantic Analysis  

## Installation and Setup

The compiler is implemented in **Java** using the **SableCC** tool.  
Download **SableCC v3** and place it either in the project folder or in your system `PATH`.

### Prerequisites

- Java 8 or newer (e.g., OpenJDK)
- `javac` and `java` available in your `$PATH`
- SableCC (`sablecc.jar`)
  > **Note**: The `sablecc.jar` file should be placed inside a `lib/` folder within your project directory.

### Running SableCC

From the folder where the grammar file is located (e.g., `phaseA/`):

#### Windows

1. Copy `sablecc.bat` into the `phaseA/` folder.
2. Run:
  ```sh
  sablecc minipython.grammar
  ```
#### Linux/macOS
1. Copy the `sablecc` shell script into the directory.
2. Run:
  ```sh
  chmod +x sablecc
  ./sablecc minipython.grammar
  ```
After execution, a folder named ` minipython/` will be automatically generated, containing the subfolders: `analysis/`, `lexer/`, `parser/`, `node/`

## Team 
- [Georgios Andritsos](https://github.com/Andritsos)
- [Anthippi Fatsea](https://github.com/Anthippi)
- [Christos Stamoulos](https://github.com/ChristosStamoulos)
