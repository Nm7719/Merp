package Processors;

import Nodes.*;
import Util.Errors;

import java.util.*;

/**
 * Class to process Merp expressions using prefix notation
 * Created by Noor Mohammad on 2/28/2017.
 */
public class MerpPrefixProcessor extends MerpProcessor{

    /**
     * Constructs and assigns a Merp tree
     * from the provided list of MerpNode tokens using prefix notation.
     * @param tokens list of MerpNodes used to create the pares tree
     */
    public void constructTree(ArrayList<String> tokens){
        Stack<MerpNode> stack = new Stack();
        for (int i = tokens.size() - 1; i >= 0; i--){
            String token = tokens.get(i);
            if (token.equals("")){
                ;
            }
            else if (isNumeric(token) || isVariable(token)){
                stack.push(createMerpNode(token));
            }
            else{
                MerpNode operator = createMerpNode(token);
                if (operator instanceof BinaryOperatorNode){
                    if (stack.size() < 2){
                        Errors.error("The user has not input sufficient values in the expression.",null);
                    }
                    else{
                        MerpNode o1 = stack.pop();
                        MerpNode o2 = stack.pop();
                        ((BinaryOperatorNode) operator).setLeftChild(o1);
                        ((BinaryOperatorNode) operator).setRightChild(o2);
                        stack.push(operator);
                    }
                }
                else {
                    if (stack.size() < 1) {
                        Errors.error("The user has not input sufficient values in the expression.", null);
                    }
                    else if (operator instanceof UnaryOperatorNode) {
                        MerpNode o = stack.pop();
                        ((UnaryOperatorNode) operator).setChild(o);
                        stack.push(operator);
                    }
                }
//                MerpNode o1 = stack.pop();
//                MerpNode o2 = stack.pop();
//                MerpNode operator = null;
//                if (token.equals("+")){
//                    operator = new AdditionNode(o1, o2);
//                }
//                else if (token.equals("-")){
//                    operator = new SubtractionNode(o1, o2);
//                }
//                else if (token.equals("//")){
//                    operator = new DivisionNode(o1, o2);
//                }
//                else if (token.equals("*")){
//                    operator = new MultiplicationNode(o1, o2);
//                }
//                else if (token.equals("^")){
//                    operator = new PowerNode(o1, o2);
//                }
            }
        }
        tree = stack.pop();
    }

    /**
     * Helper to recursively construct the parse tree
     * @param tokens - list of Merpnodes to process
     * @return current root of the parse tree
     */
    private MerpNode constructTreeHelper(ArrayList<String> tokens){
        return null;
    }
}
