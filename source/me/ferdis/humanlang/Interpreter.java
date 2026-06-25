package me.ferdis.humanlang;

import me.ferdis.humanlang.tools.Printer;
import me.ferdis.humanlang.types.Number;
import me.ferdis.humanlang.types.Text;

import java.util.HashMap;

public class Interpreter
{

    public static HashMap<String, Object> variables = new HashMap<>();

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

            /* numeral operations */
            else if (argument.startsWith("whole add "))
            {
                Number.add(argument, variables);
            }
            else if (argument.startsWith("real add "))
            {
                Number.addReal(argument, variables);
            }
            else if (argument.startsWith("whole subtract "))
            {
                Number.subtract(argument, variables);
            }
            else if (argument.startsWith("real subtract "))
            {
                Number.subtractReal(argument, variables);
            }
            else if (argument.startsWith("whole multiply "))
            {
                Number.multiply(argument, variables);
            }
            else if (argument.startsWith("real multiply "))
            {
                Number.multiplyReal(argument, variables);
            }
            else if (argument.startsWith("whole divide "))
            {
                Number.divide(argument, variables);
            }
            else if (argument.startsWith("real divide "))
            {
                Number.divideReal(argument, variables);
            }
            else if (argument.startsWith("whole to-string "))
            {
                Number.stringify(argument, variables);
            }
            else if (argument.startsWith("real to-string "))
            {
                Number.stringifyReal(argument, variables);
            }
            else if (argument.startsWith("get-whole-number "))
            {
                Number.parseWhole(argument, variables);
            }
            else if (argument.startsWith("get-real-number "))
            {
                Number.parseReal(argument, variables);
            }

            /* textual operations */

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
            }
            else if (argument.equals("storage clear;"))
            {
                variables.clear();
            }

            /* variables */
            else
            {
                if (argument.startsWith("whole number "))
                {
                    Number.registerWhole(argument, variables);
                }
                else if (argument.startsWith("real number "))
                {
                    Number.registerReal(argument, variables);
                }
                else if (argument.startsWith("text "))
                {
                    Text.register(argument, variables);
                }
            }
        }
        else
        {
            Printer.line("ERROR: ARGUMENT MUST END WITH \";\"");
        }
    }
}
