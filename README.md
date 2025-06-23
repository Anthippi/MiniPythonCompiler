# MiniPython Compiler

Αυτή η εργασία αφορά την υλοποίηση ενός μεταγλωττιστή για τη γλώσσα **miniPython**, ένα υποσύνολο της Python. Η εργασία υλοποιείται σε δύο φάσεις, με χρήση του εργαλείου **[SableCC](https://sablecc.org)**.

## Δομή Εργασίας
Η εργασία αποτελείται από δύο κύριες φάσεις:

- **[Φάση Α:](https://github.com/Anthippi/MiniPythonCompiler/tree/main/Phase%20A)**  
  - Λεκτική Ανάλυση  
  - Συντακτική Ανάλυση  

- **[Φάση Β:](https://github.com/Anthippi/MiniPythonCompiler/tree/main/Phase%20B)**  
  - Κατασκευή Αφηρημένου Συντακτικού Δέντρου (AST)  
  - Πίνακας Συμβόλων & Σημασιολογικός Έλεγχος
 
## Εγκατάσταση και Setup

Η εργασία υλοποιείται σε **Java** με χρήση του εργαλείου **SableCC**.
Κατέβασε το SableCC v3 και τοποθέτησέ το στον φάκελο του project ή στο `PATH`.

### Προαπαιτούμενα
 Εγκατάσταση του [SableCC](https://sablecc.org)
 
- Java 8 ή νεότερη (π.χ., OpenJDK)
- `javac` και `java` στο `$PATH`
- SableCC (αρχείο `sablecc.jar`)
  > **Σημείωση**: Το `sablecc.jar` πρέπει να τοποθετηθεί σε φάκελο `lib/` **μέσα στον φάκελο**.

### Εκτέλεση SableCC

Από τον φάκελο όπου βρίσκεται το αρχείο γραμματικής (π.χ., `phaseA/`):

#### Windows:
1. Αντιγράψτε το `sablecc.bat` στον φάκελο `phaseA/`.
2. Εκτελέστε:
  ```sh
  sablecc minipython.grammar
  ```
#### Linux/macOS:
1. Αντιγράψτε το αρχείο sablecc (shell script).
2. Εκτελέστε:
  ```sh
  chmod +x sablecc
  ./sablecc minipython.grammar
  ```
Μετά την εκτέλεση, δημιουργείται αυτόματα φάκελος `minipython/` με τους υποφακέλους `analysis`, `lexer`, `parser`, `node`.

## Ομάδα
- [Ανδρίτσος Γεώργιος](https://github.com/Andritsos)
- [Φατσέα Ανθίππη](https://github.com/Anthippi)
- [Σταμούλος Χρήστος](https://github.com/ChristosStamoulos)
- [Σχοινάκη Μαρία](https://github.com/MariaSchoinaki)
