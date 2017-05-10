package Processors;

import Util.SymbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Class to process Merp Programming Language Statements
 * Created by Noor Mohammad on 2/28/2017.
 */
public class EquationProcessor {

    MerpProcessor processor;

    SymbolTable symbolTable;

    ArrayList<String> equations;

    /**
     * Constructor to create an Equation Processor. Creates an empty SymbolTable.
     * @param equations
     * @param processor
     */
    public EquationProcessor(ArrayList<String> equations, MerpProcessor processor){
        this.equations = equations;
        this.processor = processor;
        this.symbolTable = new SymbolTable();
    }

    /**
     * Processes the provided list of statements using
     * the provided Merp Processor and Symbol Table.
     */
    public void processEquations(){
        for (String eq : equations){
            processEquation(eq);
        }
    }

    /**
     * Creates the merp language.
     * @param eq - The equation needed to be evaluated
     * @return an int value to be used for the conditional statements in the MerpLanguage
     */
    private int processEquation(String eq){
        eq = eq.replaceAll("[()]"," ");
        eq.trim();
        ArrayList<String> equation = new ArrayList<String>(Arrays.asList(eq.split(" ")));
        int x = 0;
        for (String i: equation){
            i = i.replace(",","");
            equation.set(x,i);
            x += 1;
        }
        String first = equation.get(0);
        boolean VAR = equation.size() >= 3;
        boolean statement = false;
        boolean print = first.equals("print");
        boolean printVars = first.equals("printVars");
        boolean condition = first.equals("if");
        boolean iteration = first.equals("while");
        if (first.matches("^[a-zA-Z].*") && VAR){
            VAR = equation.get(1).equals("=");
        }
        else{
            VAR = false;
        }
        if (print || printVars || condition || iteration){
            statement = true;
        }
        if (!(VAR) && (!(statement))){
            this.processor.constructTree(equation);
            int i = processor.evaluateTree(symbolTable);
            return i;
//            System.out.println(this.processor.evaluateTree(symbolTable));
        }
        if (VAR){
            equation.remove(0);
            equation.remove(0);
            this.processor.constructTree(equation);
            int i = this.processor.evaluateTree(symbolTable);
            symbolTable.put(first,i);
        }
        if (print){
            equation.remove(0);
            this.processor.constructTree(equation);
            int i = this.processor.evaluateTree(symbolTable);
            System.out.println(i);
        }
        if (printVars){
            symbolTable.dump();
        }

        if (condition){
            String conditional = "";
            equation.remove(0);
            equation.remove(0);

            String temp = "";
            while (!(equation.isEmpty())){
                temp = equation.remove(0);
                if (temp.contains("print") || equation.get(1).equals("=")){
                    equation.add(temp);
                    break;
                }
                conditional += temp + " ";
            }
            String statement1 = temp + " ";
            while (!(equation.isEmpty())){
                temp = equation.remove(0);
                if (temp.contains("print") || equation.get(1).equals("=")){
                    equation.add(temp);
                    break;
                }
                statement1 += temp + " ";
            }
            String statement2 = temp + " ";
            while (!(equation.isEmpty())){
                temp = equation.remove(0);
                if (temp.contains("print") || equation.get(1).equals("=")){
                    break;
                }
                statement2 += temp + " ";
            }
            if (processEquation(conditional) != 0){
                processEquation(statement1);
            }
            else{
                processEquation(statement2);
            }
        }

        if (iteration){
            String conditional = "";
            equation.remove(0);
            equation.remove(0);

            String temp = "";
            while (!(equation.isEmpty())){
                temp = equation.get(0);
                if (temp.contains("print") || equation.get(1).equals("=") || temp.equals(",")){
                    break;
                }
                equation.remove(0);
                conditional += temp + " ";
            }

            ArrayList<String> statements = new ArrayList<>();
            String statement1 = "";
            while (!(equation.isEmpty())) {
                temp = equation.remove(0);
                if (temp.equals(";") || temp.equals(",")) {
                    statements.add(statement1);
                    statement1 = "";
                }
                else {
                    statement1 += temp + " ";
                }
            }
            statements.add(statement1);
            while(processEquation(conditional) != 0){
                for (String i: statements){
                    processEquation(i);
                }
            }
        }
        return 0;
    }


}
