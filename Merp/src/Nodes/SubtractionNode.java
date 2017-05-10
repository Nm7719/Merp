package Nodes;

import Util.SymbolTable;

/**
 * Subtraction MerpNode
 * Created by Noor Mohammad on 2/28/2017.
 */
public class SubtractionNode extends BinaryOperatorNode {

    /**
     * Constructor that sets the left/right children
     * and sets the operator to the string - The precedence is set to ADD_SUBTRACT
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public SubtractionNode(MerpNode left, MerpNode right){
        super(left,right,Precedence.ADD_SUBTRACT,"-");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        int left = leftChild.evaluate(symbolTable);
        int right = rightChild.evaluate(symbolTable);
        return left - right;
    }
}
