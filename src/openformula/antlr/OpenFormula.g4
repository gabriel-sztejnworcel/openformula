
grammar OpenFormula;

/* parser rules */

formula
	: 'of:=' '='? expression EOF
	;
	
expression
	: number										# ExpressionNumber
	| String										# ExpressionString
	| reference										# ExpressionReference
	| '+' expression								# ExpressionUnaryPlus
	| '-' expression								# ExpressionUnaryMinus
	| expression '^' expression						# ExpressionPower
	| expression '*' expression						# ExpressionMultiply
	| expression '/' expression						# ExpressionDivide
	| expression '+' expression						# ExpressionAdd
	| expression '-' expression						# ExpressionSubtract
	| expression '=' expression						# ExpressionEquals
	| expression '<>' expression					# ExpressionNotEquals
	| expression '<' expression						# ExpressionLessThan
	| expression '>' expression						# ExpressionGreaterThan
	| expression '<=' expression					# ExpressionLessOrEqual
	| expression '>=' expression					# ExpressionGreaterOrEqual
	| '(' expression ')'							# ExpressionParenthesis
	| functionName '(' parameterList? ')'			# ExpressionFunctionCall
	| Error											# ExpressionError
	;
	
number
	: StandardNumber
	| NonStandardNumber
	| Integer
	;
	
reference
	: SingleCellReference							# SingleCellReference
	/*
	| CellRangeReference							# CellRangeReference
	*/
	;
	
parameterList
	: expression (ParameterSeparator expression)* 
	;
	
functionName
	: Identifier
	| IdentifierWithDot
	;

/* lexer rules */

Identifier
	: [A-Za-z] [A-Za-z0-9_]*
	;

IdentifierWithDot
	: [A-Za-z] [A-Za-z0-9_.]*
	;
	
SingleQuoted
	: '\'' (~['\[\]*\?\:/\\] | '\'\'')+ '\''
	;
	
SheetName
	: '$'? (Identifier | SingleQuoted)
	;
	
SingleCellReference
	: '[' SheetName? '.' [A-Z]+ [1-9][0-9]* ']'
	;
	
/*
CellRangeReference
	: '[' SheetName? '.' [A-Z]+ [1-9][0-9]* ':' '.' [A-Z]+ [1-9][0-9]* ']'
	| '[' SheetName '.' [A-Z]+ [1-9][0-9]* ':' SheetName '.' [A-Z]+ [1-9][0-9]* ']'
	;
*/

ParameterSeparator
	: [;,]
	;
	
Error
	: '#' [A-Z0-9]+ ([!?] | ('/' ([A-Z] | ([0-9] [!?]))))
	;

Integer
	: [0-9]+
	;

StandardNumber
	: [0-9]+ ('.' [0-9]+)? ([eE] [-+]? [0-9]+)?
	;
	
NonStandardNumber
	: '.' [0-9]+ ([eE] [-+]? [0-9]+)?
	;

String
	: '"' (~["] | '""')* '"'
	;
	
Whitespace
	: [ \t\r\n]+ -> skip
	;
