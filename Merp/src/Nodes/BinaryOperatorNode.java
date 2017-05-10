package Nodes;

/**
 * Abstract class to represent a binary operator Has a left/right child, precedence, and operator
 * Created by Noor Mohammad on 2/28/2017.
 */
public abstract class BinaryOperatorNode implements MerpNode{

    protected MerpNode leftChild;

    protected MerpNode rightChild;

    protected Precedence precedence;

    protected String operator;

    public BinaryOperatorNode(MerpNode leftChild, MerpNode rightChild,
                              Precedence precedence,String operator){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.precedence = precedence;
        this.operator = operator;
    }

    /**
     * Setter for left child
     * @param leftChild
     */
    public void setLeftChild(MerpNode leftChild){
        this.leftChild = leftChild;
    }

    /**
     * Setter for right child
     * @param rightChild - The MerpNode to be set at this node's right child
     */
    public void setRightChild(MerpNode rightChild){
        this.rightChild = rightChild;
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    public String toPrefixString(){
        String string = operator + " ";
        if (!(leftChild.equals(null))){
            string += leftChild.toPrefixString() + " ";
        }
        if (!(rightChild.equals(null))){
            string += rightChild.toPrefixString();
        }
        return string;
    }

    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    public String toInfixString(){
        String string = "";
        if (leftChild != null){
            string += "(" + leftChild.toInfixString() + " ";
        }
        string += operator + " ";

        if (rightChild != null){
            string += rightChild.toInfixString() + ")";
        }
        return string;
    }


    /**
     * Displays this node as postfix notation expression string
     * @return string representing the node as postfix notation
     */
    public String toPostfixString(){
        String string = "";
        if (leftChild != null){
            string += leftChild.toPostfixString() + " ";
        }
        if (rightChild != null){
            string += rightChild.toPostfixString() + " ";
        }
        return string + operator;

    }

    /**
     * Returns the precedence of this node
     * @return returns the precedence as an int value
     */
    public int getPrecedence(){
        return precedence.getPrecedence();
    }

    /**
     * determines if the node is an operation node
     * @return - true if an operation node, false otherwise
     */
    public boolean isOperation(){
        return true;
    }

    /**
     * Determines the node type
     * @return the type of this node
     */
    public NodeType getNodeType(){
        return NodeType.BinaryOperation;
    }

}
