package Nodes;

import Util.SymbolTable;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.org.apache.bcel.internal.generic.ConstantPoolGen;

/**
 * Constant MerpNode
 * Created by Noor Mohammad on 2/28/2017.
 */
public class ConstantNode implements MerpNode{

    private int value;

    /**
     * Constructor that sets the value of this node
     * @param value - the integer value of this node
     */
    public ConstantNode(int value){
        this.value = value;
    }

    /**
     * Returns the value of this node
     * @param symbolTable the symbol table to use for variable processing
     * @return = the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        return value;
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    public String toPrefixString(){
        return Integer.toString(value);
    }

    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    public String toInfixString(){
        return Integer.toString(value);
    }


    /**
     * Displays this node as postfix notation expression string
     * @return string representing the node as postfix notation
     */
    public String toPostfixString(){
        return Integer.toString(value);
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
        return NodeType.Constant;
    }

}
