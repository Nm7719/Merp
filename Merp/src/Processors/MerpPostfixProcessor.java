package Processors;

import Nodes.BinaryOperatorNode;
import Nodes.MerpNode;
import Nodes.UnaryOperatorNode;
import Util.Errors;

import java.util.*;

/**
 * Class to process Merp expressions using postfix notation
 * Created by Noor Mohammad on 2/28/2017.
 */
public class MerpPostfixProcessor extends MerpProcessor {

    /**
     * Constructs and assigns a Merp tree
     * from the provided list of MerpNode tokens using postfix notation.
     * @param tokens list of MerpNodes used to create the pares tree
     */
    public void constructTree(ArrayList<String> tokens) {

        Stack<MerpNode> stack = new Stack();
        while (!(tokens.isEmpty())){
            String token = tokens.remove(0);
            if (token.equals("")){
                ;
            }
            else if (isNumeric(token) || isVariable(token)){
                stack.push(createMerpNode(token));
            }
            else {
                MerpNode operator = createMerpNode(token);
                if (operator instanceof BinaryOperatorNode){
                    if (stack.size() < 2){
                        Errors.error("The user has not input sufficient values in the expression.",null);
                    }
                    else{
                        MerpNode o1 = stack.pop();
                        MerpNode o2 = stack.pop();
                        ((BinaryOperatorNode) operator).setLeftChild(o2);
                        ((BinaryOperatorNode) operator).setRightChild(o1);
                        stack.push(operator);
                    }
                }
                else{
                    if (stack.size() < 1){
                        Errors.error("The user has not input sufficient values in the expression.",null);
                    }
                    else if (operator instanceof UnaryOperatorNode){
                        MerpNode o = stack.pop();
                        ((UnaryOperatorNode) operator).setChild(o);
                        stack.push(operator);
                    }
                }
            }
        }
        if (stack.size() > 1){
            Errors.error("The user input has too many values", null);
        }
        else{
            tree = stack.pop();
        }
    }

    /**
     * Helper to recursively construct the parse tree
     * @param tokens - the list of Merpnodes to process
     * @return current root of the parse tree
     */
    private MerpNode constructTreeHelper(ArrayList<String> tokens){
        return null;
    }
}
