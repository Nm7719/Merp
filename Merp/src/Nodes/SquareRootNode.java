package Nodes;

import Util.Errors;
import Util.SymbolTable;

/**
 * Square Root MerpNode
 * Created by Noor Mohammad on 2/28/2017.
 */
public class SquareRootNode extends UnaryOperatorNode {

    /**
     * Constructor that sets the left child and sets the operator to the string @
     * The precedence is set to POWER
     * @param child - MerpNode that is the child of this node
     */
    public SquareRootNode(MerpNode child){
        super(child,Precedence.POWER,"@");
    }

    /**
     * Evaluates the node to determine its integer value
     * Errors if the child evaluates to a negative number
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        int node = child.evaluate(symbolTable);
        if (node < 0){
            Errors.error("Square Root of a negative number.", null);
        }
//        int result = (int)Math.sqrt(node);
        return (int)Math.sqrt(node);
    }
}
