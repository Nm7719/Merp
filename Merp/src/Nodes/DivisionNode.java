package Nodes;

import Util.Errors;
import Util.SymbolTable;

/**
 * Division Node
 * Created by Noor Mohammad on 2/28/2017.
 */
public class DivisionNode extends BinaryOperatorNode{

    /**
     * Constructor that sets the left/right children
     * and sets the operator to the string // The precedence is set to MULT_DIVIDE
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public DivisionNode(MerpNode left, MerpNode right){
        super(left,right,Precedence.MULT_DIVIDE,"//");
    }

    /**
     * Evaluates the node to determine its integer value Errors if the right child evaluates to zero
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        int left = leftChild.evaluate(symbolTable);
        int right = rightChild.evaluate(symbolTable);
        if (right == 0){
            Errors.error("Divide by zero", null);
        }
        return left / right;
    }
}
