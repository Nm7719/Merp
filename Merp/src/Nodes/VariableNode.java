package Nodes;

import Util.SymbolTable;

/**
 * Variable MerpNode
 * Created by Noor Mohammad on 2/28/2017.
 */
public class VariableNode implements MerpNode{

    private String name;

    /**
     * Constructor
     * @param name - the variable name
     */
    public VariableNode(String name){
        this.name = name;
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable - the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        return symbolTable.get(name);
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    public String toPrefixString(){
        return name;
    }

    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    public String toInfixString(){
        return name;
    }


    /**
     * Displays this node as postfix notation expression string
     * @return string representing the node as postfix notation
     */
    public String toPostfixString(){
        return name;
    }

    /**
     * Returns the precedence of this node
     * @return returns the precedence as an int value
     */
    public int getPrecedence(){
        return 3;
    }

    /**
     * determines if the node is an operation node
     * @return - true if an operation node, false otherwise
     */
    public boolean isOperation(){
        return false;
    }

    /**
     * Determines the node type
     * @return the type of this node
     */
    public NodeType getNodeType(){
        return NodeType.Variable;
    }

}
