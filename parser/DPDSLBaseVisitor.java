package parser;

/**
 * A simplified base visitor for DPDSL language.
 * This is a placeholder implementation for the project structure.
 */
public class DPDSLBaseVisitor<T> {

    /**
     * Visit a parse tree produced by DPDSLParser#query.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitQuery(DPDSLParser.QueryContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#select_list.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitSelect_list(DPDSLParser.Select_listContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#select_item.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitSelect_item(DPDSLParser.Select_itemContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#aggregate_expr.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitAggregate_expr(DPDSLParser.Aggregate_exprContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#column_expr.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitColumn_expr(DPDSLParser.Column_exprContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#label_expr.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitLabel_expr(DPDSLParser.Label_exprContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#alias.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitAlias(DPDSLParser.AliasContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#budget_expr.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitBudget_expr(DPDSLParser.Budget_exprContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#budget_clause.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitBudget_clause(DPDSLParser.Budget_clauseContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#agg_func.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitAgg_func(DPDSLParser.Agg_funcContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by DPDSLParser#table_name.
     * @param ctx the parse tree
     * @return the visitor result
     */
    public T visitTable_name(DPDSLParser.Table_nameContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit the children of a node.
     * @param node the node to visit
     * @return the visitor result
     */
    protected T visitChildren(Object node) {
        return null;
    }
}
