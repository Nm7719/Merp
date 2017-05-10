package Nodes;

import Util.SymbolTable;

/**
 * Negation MerpNode
 * Created by Noor Mohammad on 2/28/2017.
 */
public class NegationNode extends UnaryOperatorNode{

    /**
     * Constructor that sets the left child and sets the operator to the string _
     * The precedence is set to MULT_DIVIDE
     * @param child - MerpNode that is the child of node
     */
    public NegationNode(MerpNode child){
        super(child,Precedence.MULT_DIVIDE,"_");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        int left = child.evaluate(symbolTable);
        return 0 - left;
    }
}
