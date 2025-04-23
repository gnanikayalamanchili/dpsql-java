package semantic;

import java.util.Map;

public class BudgetChecker {

    private final Map<String, Double> columnBudgets; // user-supplied or default per-column budgets
    private final Map<String, Double> columnThresholds; // backend-enforced column-level thresholds
    private final Map<String, Double> tableThresholds; // backend-enforced table-level thresholds
    private final double queryBudgetThreshold;

    public BudgetChecker(Map<String, Double> columnBudgets,
            Map<String, Double> columnThresholds,
            Map<String, Double> tableThresholds,
            double queryBudgetThreshold) {
        this.columnBudgets = columnBudgets;
        this.columnThresholds = columnThresholds;
        this.tableThresholds = tableThresholds;
        this.queryBudgetThreshold = queryBudgetThreshold;
    }

    public boolean isColumnBudgetValid(String column) {
        double userBudget = columnBudgets.getOrDefault(column, 0.0);
        double maxAllowed = columnThresholds.getOrDefault(column, Double.MAX_VALUE);
        return userBudget <= maxAllowed;
    }

    public boolean isTableBudgetValid(String table) {
        double totalTableBudget = columnBudgets.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(table + "."))
                .mapToDouble(Map.Entry::getValue)
                .sum();
        double tableThreshold = tableThresholds.getOrDefault(table, Double.MAX_VALUE);
        return totalTableBudget <= tableThreshold;
    }

    public boolean isQueryBudgetValid() {
        double totalQueryBudget = columnBudgets.values().stream().mapToDouble(Double::doubleValue).sum();
        return totalQueryBudget <= queryBudgetThreshold;
    }

    public boolean checkAllBudgets(String table) {
        boolean columnsOK = columnBudgets.keySet().stream().allMatch(this::isColumnBudgetValid);
        return columnsOK && isTableBudgetValid(table) && isQueryBudgetValid();
    }

    public void logBudgetWarnings() {
        columnBudgets.forEach((col, budget) -> {
            double max = columnThresholds.getOrDefault(col, Double.MAX_VALUE);
            if (budget > max) {
                System.out.println("⚠️ Budget for " + col + " exceeds threshold: " + budget + " > " + max);
            }
        });
    }
}
