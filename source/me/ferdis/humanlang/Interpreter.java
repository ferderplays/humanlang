package me.ferdis.humanlang;

import me.ferdis.humanlang.tools.Printer;

import java.util.HashMap;

public class Interpreter
{

    // this stores variables
    public static HashMap<String, Integer> wholeNumberVariables = new HashMap<>();
    public static HashMap<String, String> textVariables = new HashMap<>();

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
                else if (argument.startsWith("print number "))
                {
                    /**
                     * gets the variable from the hashmap
                     */

                    String variableChosen = argument.replace("print number ", "") //argument.replace(argument.substring(0, 13), "")
                            .replace(" ", "")
                            .replace(";", "");

                    //Printer.line("[PRINT]: " + variableChosen); - debugging

                    int number = wholeNumberVariables.get(variableChosen);

                    Printer.line(number);
                }
                else if (argument.startsWith("print text "))
                {
                    /**
                     * gets the variable from the hashmap
                     */

                    String variableChosen = argument.replace("print text ", "") //argument.replace(argument.substring(0, 13), "")
                            .replace(" ", "")
                            .replace(";", "");

                    Printer.line(textVariables.get(variableChosen));
                }
                else
                {
                    output = argument.replace("print \"", "").replace("\";", "");

                    Printer.print(output);
                }
            }
            /* variables */
            else
            {
                String variableValue = argument.replace(argument.substring(0, argument.indexOf("=")), "")
                        .replace(" ", "")
                        .replace("=", "")
                        .replace(";", "");
                if (argument.startsWith("whole number"))
                {
                    String variableName = argument.replace(argument.substring(argument.indexOf("=")), "")
                            .replace(argument.substring(0, 12), "")
                            .replace(" ", "");

                    int whole = Integer.parseInt(variableValue);

                    wholeNumberVariables.put(variableName, whole);

                    Printer.line("[WHOLE NUMBER] name: " + variableName + " | value: " + whole);

                    //Printer.print(wholeNumberVariables);
                }
                else if (argument.startsWith("text"))
                {
                    String variableName = argument.replace(argument.substring(argument.indexOf("=")), "")
                            .replace(" ", "")
                            .replace("=", "")
                            .replace("\"", "")
                            .replace(";", "")
                            .replace("text", "");

                    textVariables.put(variableName, variableValue);

                    Printer.line("[TEXT] name: " + variableName + " | value: " + variableValue);

                    Printer.print(textVariables);
                }
            }
        }
        else
        {
            Printer.line("ERROR: ARGUMENT MUST END WITH \";\"");
        }
    }
}
