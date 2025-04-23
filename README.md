## 🔐 Project Title: **DPDSL — Differential Privacy-Aware SQL Language with ANTLR**

---

## 🛍️ Project Goal

Design and implement a **domain-specific language (DSL)** that supports fine-grained **differential privacy control** at column, table, and query levels — providing a complete static analysis and rewriting pipeline to safely execute SQL-like queries while ensuring formal privacy guarantees.

---

## 🏠 System Architecture

```
               +-------------------+
               |   User Input:     |
               |  DPDSL Query      |
               +-------------------+
                         |
                         v
           +-------------------------+
           |   ANTLR Parser (DPDSL)  |
           |   Grammar: DPDSL.g4     |
           +-------------------------+
                         |
                         v
          +-----------------------------+
          |   AST + Label/Budget Pass   |
          +-----------------------------+
                         |
                         v
          +-----------------------------+
          |     Semantic Analyzer       |
          |  - Label Consistency        |
          |  - Label Verification       |
          |  - Budget Inference         |
          +-----------------------------+
                         |
                         v
          +-----------------------------+
          |     Rewriter Module         |
          |  → Inject DP Noise          |
          |  → Rewrite JOINs, WHERE     |
          +-----------------------------+
                         |
                         v
          +-----------------------------+
          |   Executable SQL Query      |
          | (For Presto or other engine)|
          +-----------------------------+
```

---

## 📆 Project Modules

### 1. `grammar/DPDSL.g4` — ANTLR Grammar
- SQL-like grammar with extensions:
  - `PUBLIC column`
  - `PRIVATE column OF [ε]`
  - Query budget: `[ε_total]`
- Handles:
  - SELECT queries with aggregation
  - JOINs and aliases
  - Budget and label annotations

### 2. `parser/DPDSLVisitor.java`
- Walks the AST and extracts:
  - Column labels (`PUBLIC` / `PRIVATE`)
  - Privacy budgets
  - Subqueries and alias resolution

### 3. `semantic/`
#### a. `LabelChecker.java`
- Ensures consistent label use within and across subqueries

#### b. `BudgetChecker.java`
- Verifies:
  - Column-level ≤ threshold
  - Table-level and query-level budget composition
- Implements the rules from the doc's Section 5.5

### 4. `rewrite/QueryRewriter.java`
- Rewrites safe queries into executable SQL:
  - Injects `NOISE(ε, col, table)` calls
  - Removes label annotations
  - Handles complex expressions and aggregations
- Uses a visitor or transformer pattern on the AST

### 5. `config/`
- JSON-based user-level configurations for:
  - Label maps per column
  - Budget thresholds (column/table/query)

```json
{
  "user": "analyst_1",
  "privacy_level": 2,
  "column_budgets": {
    "table_a.a": 0.5,
    "table_b.b": 0.2
  },
  "table_budgets": {
    "table_a": 1.0,
    "table_b": 1.5
  },
  "query_budget": 2.0
}
```

### 6. `main/DPDSLRunner.java`
- Orchestrates:
  - Parsing
  - Label/Budget resolution
  - Semantic check
  - Rewriting
  - Output SQL

---

## 🧪 Example

### Input DPDSL Query:
```sql
SELECT COUNT(PRIVATE salary OF [0.2]) AS A,
       AVG(PRIVATE age OF [0.1]) AS B
FROM employees [0.3];
```

### Output Rewritten SQL:
```sql
SELECT COUNT(salary) + NOISE(0.2, salary, employees) AS A,
       AVG(age) + NOISE(0.1, age, employees) AS B
FROM employees;
```

---

## 🛠 Build and Run

For detailed instructions on building and running the project, see [BUILD.md](BUILD.md).

### Quick Start
```bash
# Generate parser
antlr4 -o grammar grammar/DPDSL.g4 -visitor -no-listener -package grammar

# Compile
javac -cp ".;path\to\antlr-runtime.jar" grammar\*.java parser\*.java semantic\*.java rewrite\*.java main\*.java

# Run
java -cp ".;path\to\antlr-runtime.jar;." main.DPDSLRunner input.dpsql
```

Replace `path\to\antlr-runtime.jar` with the actual path to the ANTLR runtime JAR file.

---

## 🦉 Future Extensions

- ✅ Add support for `GROUP BY`, `HAVING`
-  Query fingerprinting or logging
-  Integrate with DP engine (e.g., SmartNoise)
-  Web interface for interactive query writing
- Budget consumption visualization
