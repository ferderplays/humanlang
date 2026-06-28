package me.ferdis.humanlang.types;

import me.ferdis.humanlang.tools.Printer;

import java.util.HashMap;

public class Text
{
    public static void register(String argument, HashMap<String, Object> storage)
    {
        String variableName = argument.replace(argument.substring(argument.indexOf("=")), "")
                .replace(" ", "")
                .replace("=", "")
                .replace("\"", "")
                .replace(";", "")
                .replace("text", "");

        String variableValue = argument.replace(argument.substring(0, argument.indexOf("=")), "")
                .replace("=", "")
                .replace(";", "");

        storage.put(variableName, variableValue);

        Printer.line("[TEXT] name: " + variableName + " | value: " + variableValue);
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

    public static void replace(String argument, HashMap<String, Object> storage)
    {
        String[] arguments = argument.replace("replace(", "")
                .replace(argument.substring(argument.indexOf("(")), "")
                .replace(");", "")
                .replace("\"", "")
                .split(",");

        Printer.line(arguments);

        String variableName = arguments[0].replace(",", "").replace(" ", "");
        String replaced = arguments[1].replace(",", "");
        String replacable = arguments[2];

        String variable = storage.get(variableName).toString();

        String outcome = variable.replace(replaced, replacable);

        storage.remove(variableName);

        storage.put(variableName, outcome);
    }
}
