// Define a grammar called Hello
grammar MyGrammatic;
expr: left=add(op+=('+'|'-')right+=add)*;
add: left=mul(op+=('*'|'/')right+=mul)*;
mul: num=NUMBER | '(' expr ')';

NUMBER: [0-9]+('.'[0-9]*)? | '.' [0-9]+;
WHITESPACE: [ \n\r\t]+ -> skip;
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';