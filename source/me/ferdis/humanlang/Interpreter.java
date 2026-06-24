package me.ferdis.humanlang;

import me.ferdis.humanlang.tools.Printer;
import me.ferdis.humanlang.types.Number;

import java.util.HashMap;

public class Interpreter
{
    public static HashMap<String, Object> variables = new HashMap<>();

    public static void interpret (String[] code)
    {
        for (String argument : code)
        {
            // a print command, this command prints whatever u give it to print
            if (argument.startsWith("print \""))
            {
                String output = "";
                if (argument.startsWith("print line"))
                {
                    output = argument.replace("print line \"", "").replace("\";", "");

                    Printer.line(output);
                }
                else
                {
                    output = argument.replace("print \"", "").replace("\";", "");

                    Printer.print(output);
                }
            }
        }
    }

    public static void interpret (String argument)
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
            /* variable methods */
            else if (argument.startsWith("whole add "))
            {
                Number.add(argument, variables);
            }
            else if (argument.startsWith("real add "))
            {
                Number.addReal(argument, variables);
            }
            /* variables */
            else
            {
                String variableValue = argument.replace(argument.substring(0, argument.indexOf("=")), "")
                        .replace(" ", "")
                        .replace("=", "")
                        .replace(";", "");
                if (argument.startsWith("whole number "))
                {
                    Number.registerWhole(argument, variables);
                }
                else if (argument.startsWith("real number "))
                {
                    Number.registerReal(argument, variables);
                }
                else if (argument.startsWith("text"))
                {
                    String variableName = argument.replace(argument.substring(argument.indexOf("=")), "")
                            .replace(" ", "")
                            .replace("=", "")
                            .replace("\"", "")
                            .replace(";", "")
                            .replace("text", "");

                    variables.put(variableName, variableValue);

                    Printer.line("[TEXT] name: " + variableName + " | value: " + variableValue);
                }
            }
        }
        else
        {
            Printer.line("ERROR: ARGUMENT MUST END WITH \";\"");
        }
    }
}
