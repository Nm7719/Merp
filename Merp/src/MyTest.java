import Nodes.*;
import Processors.MerpInfixProcessor;
import Processors.MerpPostfixProcessor;
import Processors.MerpPrefixProcessor;
import Processors.MerpProcessor;
import Util.Errors;
import Util.SymbolTable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Noor Mohammad on 3/6/2017.
 */
public class MyTest {

    public static void main(String[] args) {
        SymbolTable x = new SymbolTable();
        x.put("x",10);
        x.put("y", 20);
        x.put("z",30);
//        MerpNode tree;
//
//        ConstantNode constant = new ConstantNode(8);
//        VariableNode varx = new VariableNode("x");
//        VariableNode vary = new VariableNode("y");
//        MultiplicationNode mult = new MultiplicationNode(constant,new AdditionNode(varx,vary));
//        ConstantNode firstconst = new ConstantNode(5);
//        VariableNode firstvariable = new VariableNode("y");
//        AdditionNode firstadd = new AdditionNode(firstconst,firstvariable);
//        ConstantNode secondconst = new ConstantNode(6);
//        VariableNode secondvariable = new VariableNode("z");
//        MultiplicationNode firstmult = new MultiplicationNode(secondconst,secondvariable);
//        BinaryOperatorNode firstbinaryOperator = new SubtractionNode(firstmult,new ConstantNode(3));
//        BooleanOperatorNode firstbooleanOperator = new LessThanEqualNode(firstmult,firstadd);
//        UnaryOperatorNode firstunaryOperator = new AbsValueNode(firstbinaryOperator);
//        SquareRootNode firstsqr = new SquareRootNode(firstbinaryOperator);
//        firstconst.toInfixString();
//        firstvariable.toInfixString();
//        System.out.println(firstvariable.evaluate(x));
//        System.out.println(firstbinaryOperator.toInfixString());
//        System.out.println(firstbinaryOperator.getNodeType());
//        System.out.println(firstbinaryOperator.evaluate(x));
//        System.out.println(firstbooleanOperator.evaluate(x));
//        System.out.println(firstunaryOperator.evaluate(x));
//        System.out.println(firstbooleanOperator.toPrefixString());
//        System.out.println(firstsqr.evaluate(x));
//        System.out.println(firstsqr.toPrefixString());
//        System.out.println(mult.toInfixString());
//        System.out.println(mult.evaluate(x));
//        System.out.println(mult.toPrefixString());
//        System.out.println(mult.toPostfixString());

        MerpProcessor processor;
        String type = "postfix";
//        String equation = "3 + 4 * 2 // 1 - 5 ^ 2 ^ 3";
//        String equation = "- * // 15 - 7 + 1 1 3 + 2 + 1 1";
//        String equation = "5 1 2 + 4 * + 3 -";
        String equation = "2 3 * 4 5 * +";
        if(type.equals("infix")){
            processor = new MerpInfixProcessor();
        }
        else if(type.equals("prefix")){
            processor = new MerpPrefixProcessor();
        }
        else if(type.equals("postfix")){
            processor = new MerpPostfixProcessor();
        }
        else{
            Errors.error("Invalid type", type);
            return;
        }

        System.out.println("Testing " + equation + " using " + type);

        processor.constructTree(new ArrayList<String>(Arrays.asList(equation.split(" "))));
        System.out.println(processor.getTree().toPostfixString());
        System.out.println(processor.evaluateTree(x));

//        System.out.println(processor);
    }
}
