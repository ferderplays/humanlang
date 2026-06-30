package me.ferdis.humanlang.types;

import me.ferdis.humanlang.tools.Functions;
import me.ferdis.humanlang.tools.Printer;

import java.util.ArrayList;
import java.util.HashMap;

public class Text
{
    public static void register(String argument, HashMap<String, Object> storage, HashMap<String, String> typeStorage)
    {
        // syntax: text <variable> = <value>;
        /*String variableName = argument.replace(argument.substring(argument.indexOf("=")), "")
                .replace(" ", "")
                .replace("=", "")
                .replace("\"", "")
                .replace(";", "")
                .replace("text", "");*/

        String variableName = argument.substring(0, argument.indexOf("="))
                .replace("text", "")
                .replace("=", "")
                .replace(" ", "");

        String variableValue = argument.replace(argument.substring(0, argument.indexOf("=")), "")
                .replace("= ", "")
                .replace(";", "");

        ArrayList<String> variableNames = new ArrayList<>(storage.keySet());

        boolean isOfAVariable = false;

        for (String variable : variableNames)
        {
            if (variableValue.startsWith(variable))
            {
                if (variableValue.startsWith(variable + ".replace("))
                {
                    String outcomeValue = replace(variableValue, storage);

                    storage.put(variableName, outcomeValue);

                    typeStorage.put(variableName, "TEXT");

                    Printer.line("[TEXT] name: " + variableName + " | value: " + outcomeValue);
                }
                isOfAVariable = true;
            }
        }

        if (!isOfAVariable)
        {

            variableValue = argument.substring(argument.indexOf("\"") + 1, argument.lastIndexOf("\""));
            storage.put(variableName, variableValue);

            typeStorage.put(variableName, "TEXT");

            Printer.line("[TEXT] name: " + variableName + " | value: " + variableValue);
        }
    }

    public static void uppercase(String argument, HashMap<String, Object> storage)
    {
        String variableName = argument.replace(" ", "")
                .replace("to-upper(", "")
                .replace(";", "")
                .replace(")", "")
                .replace(",", "");

        String text = storage.get(variableName).toString();

        storage.put(variableName + "_upper", text.toUpperCase());
    }

    public static void lowercase(String argument, HashMap<String, Object> storage)
    {
        String variableName = argument.replace(" ", "")
                .replace("to-lower(", "")
                .replace(";", "")
                .replace(")", "")
                .replace(",", "");

        String text = storage.get(variableName).toString();

        storage.put(variableName + "_upper", text.toLowerCase());
    }

    public static String replace(String argument, HashMap<String, Object> storage)
    {
        // syntax: <variable>.replace(toReplace, replacer);
        String variableName = argument.substring(0, argument.indexOf("."));

        String variable = (String) storage.get(variableName);

        String arguments = argument.replace(argument.substring(0, argument.indexOf("(")), "")
                .replace("(", "")
                .replace(")", "");

        Printer.line("arguments > " + arguments);

        String toReplace = arguments.replace(arguments.substring(arguments.indexOf(",")), "")
                .replace("\"", "");

        Printer.line("to-replace > " + toReplace);

        String replacer = arguments.replace(toReplace, "")
                .replace(",", "")
                .replace("\"", "");

        Printer.line("replacer > " + replacer);

        return variable.replace(toReplace, replacer);
    }
}
