package Nodes;

/**
 * Abstract class to represent a unary operator
 * Unary operators only have a single child
 * Created by Noor Mohammad on 2/28/2017.
 */
public abstract class UnaryOperatorNode implements MerpNode{

    protected MerpNode child;

    protected String operator;

    protected Precedence precedence;

    public UnaryOperatorNode(MerpNode child, Precedence precedence, String operator){
        this.child = child;
        this.operator = operator;
        this.precedence = precedence;
    }

    /**
     * Sets the child of this node
     * @param child - the MerpNode representing the child
     */
    public void setChild(MerpNode child){
        this.child = child;
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    public String toPrefixString(){
        String string = operator + " ";
        if (child != null){
            string += child.toPrefixString();
        }
        return string;
    }

    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    public String toInfixString(){
        String string = "(" + operator + " ";
        if (child != null){
            string += child.toInfixString() + ")";
        }
        return string;
    }


    /**
     * Displays this node as postfix notation expression string
     * @return string representing the node as postfix notation
     */
    public String toPostfixString(){
        String string = "";
        if (child != null){
            string += child.toInfixString() + " ";
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
        return NodeType.UnaryOperation;
    }

}
