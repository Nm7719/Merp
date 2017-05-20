Parse an expression, construct a syntax tree, and evaluate the tree to obtain its integer value.

Source Language

A source program in the Merp language is a sequence of expressions. 
There is no punctuation between statements. 
Spaces are required between each element of every expression.
Identifiers are guaranteed to begin with an alphabetic character.
Expressions represent integer calculations. Their syntax is recursive in nature. They come in one of four forms:

  integer-constant
  
  identifier 
  
  Unary Operation:
    
    unary-operator expression (Infix/Prefix)
    
    expression unary-operator (PostFix)
  
  Binary Operation:
    
    expression1 binary-operator expression2 (Infix)
    
    binary-operator expression1 expression2 (Prefix)
   
    expression1 expression2 binary-operator (PostFix)


Note two things:
The first two forms are the base cases in that they identify primitive elements that cannot be broken down further.
The recursive forms follow either a prefix, infix, or postfix notation: The operator comes first, in between, or after the expressions.
integer-constants are in base 10 and are therefore a string of decimal digits. A leading minus sign is OK, as long as there is no space after it. Use the normal technique to convert these strings to integers when needed.

The legal unary-operators:
     
    _ negation, equivalent to zero minus the expression (Note: it's the underscore character!)
    @ square root
    | absolute value
  
  
The legal binary-operators:  
    
    addition +
    subtraction - (minuend first)
    multiplication * 
    division // (dividend first)
    power node ^ (base first)


Boolean Operators:
   
    greater than node > 
   
    greater than and equal to node >= 
   
    less than node  < 
   
    less than equal to node <= 
   
    equal to node == 
   
    not equal to node != 

Since square root and division can create non-integer results, the actual answer will be rounded to an integer according to how your programming language normally converts double-precision floating point numbers to integers.
Boolean operations typically produce a true or false value, but this violates the rules set forth in the interface. Therefore 0 is to be considered false, and anything non-zero will be consider true.

Process a program written in a very basic programming language, MPL (Merp Programming Language). The program will be a series of statements that need to be executed. These statements can change the state of the machine, ie change variables.

It can do the following things:

  exp: evaluate the expression exp. Expressions can contain variables, numbers, and operators. A Merp Processor will be used to evaluate   expression.
  
  print( exp ): print the value of the expression exp.
  
  printVars(): will print the current list of variables and thier values. This is done by using the SymbolTable's dump() function.
  
  VAR = exp: assign the value of exp to the variable VAR. The Symbol Table for the program will be updated.
 
  statement: a statement can be an expression, assignment, or print statement.
  
  if( cond, statement1, statement2 ): if statement where cond is the condition to evaluate. If cond is non-zero statement is evaluated,   otherwise statement2 is evaluated.
  
  while( cond, statement1; statement2; ..., statementN ): while loop where cond is the condition to continue the loop. statement1;         statement2; ..., statmentN is a list of statements to run for each iteration of the loop. Notice they are semicolon seperated.

Things to note:
Loops and ifs cannot be nested inside of each other. This means no ifs in ifs, no ifs in whiles, not whiles in ifs, and no whiles in whiles.
Assignment is not allowed in a print()
Only a single variable is allowed on the left hand side of the equals. No calculation is allowed on the left hand side.
Example Program: 

The program will work as follows:

Ask the user for the types of the equations: postfix, prefix, infix. 
Create the proper Merp Processor. 
Create an EquationProcessor. 
Prompt the user for a list of code to process, one statement per line. Blank line to end entry. 
Pass the list of statements to the Equation Processor. The EquationProcessor will process the statement one at a time.
Things to note:

Only variables can exist on the left-hand side of a statement.
Any combination of variables, operators, and numbers can exist on the right-hand side of the statement.
The usage of an unassigned variable results in an error.
Variables can be reassigned, even after they have already been used.
If, while, and print statements return nothing. Therefore cannot be assigned to variables.

