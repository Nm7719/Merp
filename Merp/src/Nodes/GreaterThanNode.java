package Nodes;

import Util.SymbolTable;

/**
 * Node Representing the greater than operator
 * Created by Noor Mohammad on 2/28/2017.
 */
public class GreaterThanNode extends BooleanOperatorNode{

    /**
     * Constructor that sets the left/right children
     * and sets the operator to the string ==
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public GreaterThanNode(MerpNode left, MerpNode right){
        super(left,right,">");
    }

    /**
     * Evaluates the node to determine its integer value 1 for true, zero for false
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        int left = leftChild.evaluate(symbolTable);
        int right = rightChild.evaluate(symbolTable);
        if (left > right){
            return 1;
        }
        return 0;
    }
}
