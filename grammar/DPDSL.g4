grammar DPDSL;

// Parser rules
query         : SELECT select_list FROM table_name (budget_clause)?;
select_list   : select_item (',' select_item)*;
select_item   : aggregate_expr alias? | column_expr alias?;
aggregate_expr: agg_func '(' label_expr ')' (budget_expr)?;
column_expr   : label_expr (budget_expr)?;
label_expr    : LABEL_TYPE ID;
alias         : AS ID;
budget_expr   : OF '[' NUMBER ']';
budget_clause : '[' NUMBER ']';

agg_func      : 'SUM' | 'COUNT' | 'AVG';

// Lexer rules
SELECT        : 'SELECT';
FROM          : 'FROM';
AS            : 'AS';
OF            : 'OF';

LABEL_TYPE    : 'PUBLIC' | 'PRIVATE';

ID            : [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER        : [0-9]+ ('.' [0-9]+)?;

WS            : [ \t\r\n]+ -> skip;
