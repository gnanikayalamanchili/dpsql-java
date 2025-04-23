public class DPDSLRunner {
    public static void main(String[] args) throws Exception {
        String input = "SELECT COUNT(PRIVATE salary OF [0.2]), AVG(PRIVATE age OF [0.1]) FROM employees [0.3];";

        DPDSLLexer lexer = new DPDSLLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DPDSLParser parser = new DPDSLParser(tokens);

        ParseTree tree = parser.query();

        DPDSLVisitor visitor = new DPDSLVisitor();
        visitor.visit(tree);

        Map<String, String> labels = visitor.getLabels();
        Map<String, Double> budgets = visitor.getBudgets();

        String rewrittenQuery = QueryRewriter.rewriteQuery(labels, budgets);
        System.out.println("Rewritten Query:\n" + rewrittenQuery);
    }
}
