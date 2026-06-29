package me.ferdis.humanlang;

import me.ferdis.humanlang.tools.Printer;
import me.ferdis.humanlang.types.Number;
import me.ferdis.humanlang.types.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Interpreter
{

    public static HashMap<String, Object> variables = new HashMap<>();
    public static HashMap<String, String> variablesTypes = new HashMap<>();

    public static void interpret(String argument)
    {

        if (argument.endsWith(";"))
        {
            // a print command, this command prints whatever u give it to print
            if (argument.startsWith("print "))
            {
                String output = "";
                if (argument.startsWith("print line"))
                {
                    output = argument.replace("print line \"", "").replace("\";", "");

                    Printer.line(output);
                }
                else if (argument.startsWith("print variable "))
                {
                    String variableChosen = argument.replace("print variable ", "") //argument.replace(argument.substring(0, 13), "")
                            .replace(" ", "")
                            .replace(";", "");

                    Printer.line("> " + variables.get(variableChosen));
                }
                else
                {
                    output = argument.replace("print \"", "").replace("\";", "");

                    Printer.print(output);
                }
            }

            /* textual operations */
            else if (argument.startsWith("to-upper("))
            {
                Text.uppercase(argument, variables);
            }
            else if (argument.startsWith("to-lower("))
            {
                Text.lowercase(argument, variables);
            }
            else if (argument.startsWith("replace("))
            {
                Text.replace(argument, variables);
            }

            /* statements */
            else if (argument.startsWith("if ("))
            {

            }

            /* storage operators */
            else if (argument.startsWith("storage remove "))
            {
                String variableName = argument.replace("storage remove ", "")
                        .replace(";", "");

                variables.remove(variableName);
                variablesTypes.remove(variableName);
            }
            else if (argument.equals("storage clear;"))
            {
                variables.clear();
            }

            /* variables */
            else if (argument.startsWith("whole number "))
            {
                Number.registerWhole(argument, variables, variablesTypes);
            }
            else if (argument.startsWith("real number "))
            {
                Number.registerReal(argument, variables, variablesTypes);
            }
            else if (argument.startsWith("text "))
            {
                Text.register(argument, variables);
            }
            else
            {
                /* variable functions */

                ArrayList<String> variableNames = new ArrayList<>(variables.keySet());

                for (String variableName : variableNames)
                {
                    Printer.line("current variable: " + variableName);
                    if (argument.startsWith(variableName))
                    {
                        switch (variablesTypes.get(variableName))
                        {
                            case "WHOLE NUMBER":

                                /* numeric operations */
                                if (argument.startsWith(variableName + ".add("))
                                {
                                    Number.add(argument, variables);
                                }
                                else if (argument.startsWith(variableName + ".subtract("))
                                {
                                    Number.subtract(argument, variables);
                                }
                                else if (argument.startsWith(variableName + ".multiply("))
                                {
                                    Number.multiply(argument, variables);
                                }
                                else if (argument.startsWith(variableName + ".divide("))
                                {
                                    Number.divide(argument, variables);
                                }

                                /* conversion */
                                else if (argument.startsWith(variableName + ".stringify("))
                                {
                                    Number.stringify(argument, variables);
                                }
                                else if (argument.startsWith(variableName + ".realify("))
                                {
                                    Number.parseReal(argument, variables);
                                }

                                break;

                            case "REAL NUMBER":

                                /* numeric operations */
                                if (argument.startsWith(variableName + ".add("))
                                {
                                    Number.addReal(argument, variables);
                                }
                                else if (argument.startsWith(variableName + ".subtract("))
                                {
                                    Number.subtractReal(argument, variables);
                                }
                                else if (argument.startsWith(variableName + ".multiply("))
                                {
                                    Number.multiplyReal(argument, variables);
                                }
                                else if (argument.startsWith(variableName + ".divide("))
                                {
                                    Number.divideReal(argument, variables);
                                }

                                /* conversion */
                                else if (argument.startsWith(variableName + ".stringify("))
                                {
                                    Number.stringifyReal(argument, variables);
                                }
                                else if (argument.startsWith(variableName + ".wholeify("))
                                {
                                    Number.parseWhole(argument, variables);
                                }

                                break;

                            case "TEXT":
                                break;
                        }
                    }
                }
            }
        }
        else
        {
            Printer.line("ERROR: ARGUMENT MUST END WITH \";\"");
        }
    }
}
