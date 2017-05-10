package Nodes;

import Util.SymbolTable;

/**
 * Absolute Value MerpNode
 * Created by Noor Mohammad on 2/28/2017.
 */
public class AbsValueNode extends UnaryOperatorNode {

    /**
     * Constructor that sets the left child and sets the operator to the string
     * | The precedence is set to MULT_DIVIDE
     * @param child
     */
    public AbsValueNode(MerpNode child){
        super(child,Precedence.MULT_DIVIDE,"|");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        int node = child.evaluate(symbolTable);
        if (node < 0){
            return node + (-node * 2);
        }
        return node;
    }
}