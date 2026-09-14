package me.ferdis.humanlang.tools;

import me.ferdis.humanlang.types.Number;
import me.ferdis.humanlang.types.Text;
import me.ferdis.humanlang.types.list.WholeList;

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

                    if (variablesTypes.get(variableChosen).equals("TEXT"))
                    {
                        Printer.line("> \"" + variables.get(variableChosen) + "\"");
                    }
                    else
                    {
                        Printer.line("> " + variables.get(variableChosen));
                    }
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
                Text.register(argument, variables, variablesTypes);
            }
            else if (argument.startsWith("list<whole> "))
            {
                WholeList.registerList(argument, variables, variablesTypes);
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
                                Functions.wholeNumber(argument, variableName, variables, variablesTypes);
                                break;

                            case "REAL NUMBER":
                                Functions.realNumber(argument, variableName, variables, variablesTypes);
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
