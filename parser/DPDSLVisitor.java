package parser;

import java.util.Map;
import java.util.HashMap;

public class DPDSLVisitor extends DPDSLBaseVisitor<Void> {
    private Map<String, String> labels = new HashMap<>();
    private Map<String, Double> budgets = new HashMap<>();

    @Override
    public Void visitSelect_item(DPDSLParser.Select_itemContext ctx) {
        String col = ctx.getText(); // You'll want to parse this cleaner
        if (ctx.column_expr() != null) {
            String label = ctx.column_expr().label_expr().LABEL_TYPE();
            String name = ctx.column_expr().label_expr().ID();
            labels.put(name, label);

            if (ctx.column_expr().budget_expr() != null) {
                String bStr = ctx.column_expr().budget_expr().NUMBER();
                budgets.put(name, Double.parseDouble(bStr));
            }
        }
        return null;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public Map<String, Double> getBudgets() {
        return budgets;
    }
}
