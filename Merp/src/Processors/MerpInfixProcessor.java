package Processors;

import Nodes.*;
import Util.Errors;

import java.util.*;

/**
 * Class to process Merp expressions using infix notation
 * Created by Noor Mohammad on 2/28/2017.
 */
public class MerpInfixProcessor extends MerpProcessor{

    /**
     * Constructs and assigns a Merp tree
     * from the provided list of MerpNode tokens using infix notation.
     * @param tokens list of MerpNodes used to create the pares tree
     */
    public void constructTree(ArrayList<String> tokens){
        HashMap<String,Integer> precedence = new HashMap<String,Integer>();
        precedence.put("*",3);
        precedence.put("//",3);
        precedence.put("+",2);
        precedence.put("-",2);
        precedence.put("^",4);
        precedence.put("@",4);
        precedence.put("|",4);
        precedence.put("_",4);
        precedence.put("<",1);
        precedence.put("==",1);
        precedence.put("<=",1);
        precedence.put(">",1);
        precedence.put(">=",1);
        precedence.put("!=",1);
        Queue<String> queue = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();
        while (!(tokens.isEmpty())){
            String token = tokens.remove(0);

            if (token.equals("")){
                ;
            }
            else if (isNumeric(token) || isVariable(token)){
                queue.add(token);
            }
            else {
                String o1 = token;
                while (!(stack.isEmpty())){
                    String o2 = stack.pop();
                    if (precedence.get(o1).equals(4)){
                        if (precedence.get(o1) < precedence.get(o2)){
                            queue.add(o2);
                        }
                    }
                    else if (precedence.get(o1) <= precedence.get(o2)){
                        queue.add(o2);
                    }
                    else{
                        stack.push(o2);
                        break;
                    }
                }
                stack.push(o1);
            }
        }
        while (!(stack.isEmpty())){
            queue.add(stack.pop());
        }
        String equation = "";
        for (String i: queue){
            equation += i + " ";
        }
        tree = processStack(new ArrayList<String>(Arrays.asList(equation.split(" "))));
    }

    /**
     * Constructs and assigns a Merp tree
     * from the provided list of MerpNode tokens using postfix notation.
     * @param tokens list of MerpNodes used to create the pares tree
     */
    private MerpNode processStack(ArrayList<String> tokens) {

        Stack<MerpNode> stack = new Stack();
        while (!(tokens.isEmpty())){
            String token = tokens.remove(0);
            if (isNumeric(token) || isVariable(token)){
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
            return stack.pop();
        }
        return null;
    }
}
