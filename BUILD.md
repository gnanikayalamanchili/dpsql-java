# Building and Running DPDSL

This document provides detailed instructions for building and running the DPDSL (Differential Privacy-Aware SQL Language) project.

## Prerequisites

Before you begin, ensure you have the following installed:

1. **Java Development Kit (JDK)** - Version 8 or higher
   - Download from: [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://adoptopenjdk.net/)
   - Verify installation: `java -version`

2. **ANTLR4 Tool** - For generating the parser
   - Download from: [ANTLR4 Website](https://www.antlr.org/download.html)
   - Install using one of these methods:
     - Using Java: Download the JAR file and add it to your classpath
     - Using a package manager:
       - macOS: `brew install antlr`
       - Linux: `apt-get install antlr4` or equivalent for your distribution
       - Windows: Download the JAR file or use a package manager like Chocolatey: `choco install antlr`
   - Verify installation: `antlr4 -version`

3. **ANTLR4 Runtime** - For running the generated parser
   - Download from: [ANTLR4 Website](https://www.antlr.org/download.html)
   - Add the JAR file to your classpath

## Project Structure

The project is organized as follows:

- `grammar/` - Contains the ANTLR grammar file (DPDSL.g4)
- `parser/` - Contains the parser implementation
- `semantic/` - Contains the semantic analyzers (LabelChecker, BudgetChecker)
- `rewrite/` - Contains the query rewriter
- `main/` - Contains the main runner class
- `config/` - Contains configuration files
- `test/` - Contains test cases

## Building the Project

Follow these steps to build the project:

1. **Clone the repository** (if you haven't already):
   ```bash
   git clone <repository-url>
   cd dpsql-java
   ```

2. **Generate the ANTLR parser**:
   ```bash
   antlr4 -o grammar grammar/DPDSL.g4 -visitor -no-listener -package grammar
   ```
   This command generates the lexer, parser, and visitor classes in the `grammar` directory.

3. **Compile the Java files**:
   ```bash
   javac -cp ".:path/to/antlr-runtime.jar" grammar/*.java parser/*.java semantic/*.java rewrite/*.java main/*.java test/*.java
   ```
   Replace `path/to/antlr-runtime.jar` with the actual path to the ANTLR runtime JAR file.

   For Windows, use semicolons instead of colons in the classpath:
   ```bash
   javac -cp ".;path\to\antlr-runtime.jar" grammar\*.java parser\*.java semantic\*.java rewrite\*.java main\*.java test\*.java
   ```

## Running the Project

After building the project, you can run it using the following command:

```bash
java -cp ".:path/to/antlr-runtime.jar:." main.DPDSLRunner input.dpsql
```

Replace `path/to/antlr-runtime.jar` with the actual path to the ANTLR runtime JAR file, and `input.dpsql` with the path to your input file.

For Windows, use semicolons instead of colons in the classpath:
```bash
java -cp ".;path\to\antlr-runtime.jar;." main.DPDSLRunner input.dpsql
```

## Example Input

Create a file named `input.dpsql` with the following content:

```sql
SELECT COUNT(PRIVATE salary OF [0.2]) AS A,
       AVG(PRIVATE age OF [0.1]) AS B
FROM employees [0.3];
```

This query calculates the count of salaries and the average age from the employees table, with privacy budgets specified for each column and for the table.

## Expected Output

When you run the project with the example input, you should see output similar to the following:

```
Input Query: SELECT COUNT(PRIVATE salary OF [0.2]) AS A, AVG(PRIVATE age OF [0.1]) AS B FROM employees [0.3];
Rewritten Query:
SELECT COUNT(salary) + NOISE(0.2, salary, employees) AS A, AVG(age) + NOISE(0.1, age, employees) AS B FROM employees;
```

The rewritten query adds noise to the private columns (salary and age) to ensure differential privacy.

## Running Tests

You can run the test cases using the following command:

```bash
java -cp ".:path/to/antlr-runtime.jar:." test.TestCases
```

For Windows, use semicolons instead of colons in the classpath:
```bash
java -cp ".;path\to\antlr-runtime.jar;." test.TestCases
```

## Troubleshooting

If you encounter any issues, try the following:

1. **ANTLR tool not found**: Ensure that the ANTLR tool is installed and in your PATH.
2. **ANTLR runtime not found**: Ensure that the ANTLR runtime JAR file is in your classpath.
3. **Compilation errors**: Ensure that you have the correct version of the JDK installed.
4. **Runtime errors**: Ensure that the input file exists and has the correct format.

## Additional Resources

- [ANTLR Documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Differential Privacy Resources](https://www.cis.upenn.edu/~aaroth/Papers/privacybook.pdf)