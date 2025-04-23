public class QueryRewriter {
    public static String rewrite(String column, String label, Double budget) {
        if ("PRIVATE".equalsIgnoreCase(label)) {
            return column + " + NOISE(" + budget + ", " + column + ", table)";
        }
        return column;
    }

    public static String rewriteQuery(Map<String, String> labels, Map<String, Double> budgets) {
        StringBuilder sb = new StringBuilder("SELECT ");
        List<String> rewrittenCols = new ArrayList<>();

        for (String col : labels.keySet()) {
            String rewritten = rewrite(col, labels.get(col), budgets.getOrDefault(col, 0.1));
            rewrittenCols.add(rewritten);
        }

        sb.append(String.join(", ", rewrittenCols));
        sb.append(" FROM table;");
        return sb.toString();
    }
}
