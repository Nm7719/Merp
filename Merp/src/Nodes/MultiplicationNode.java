package Nodes;

import Util.SymbolTable;

/**
 * Multiplication Node
 * Created by Noor Mohammad on 2/28/2017.
 */
public class MultiplicationNode extends BinaryOperatorNode{

    /**
     * Constructor that sets the left/right children
     * and sets the operator to the string * The precedence is set to MULT_DIVIDE
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public MultiplicationNode(MerpNode left, MerpNode right){
        super(left,right,Precedence.MULT_DIVIDE,"*");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        int left = leftChild.evaluate(symbolTable);
        int right = rightChild.evaluate(symbolTable);
        return left * right;
    }

}
