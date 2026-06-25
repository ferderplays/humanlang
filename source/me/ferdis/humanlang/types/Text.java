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
                .replace(" ", "")
                .replace("=", "")
                .replace(";", "");

        storage.put(variableName, variableValue);

        Printer.line("[TEXT] name: " + variableName + " | value: " + variableValue);
    }

    public static void uppercase(String argument, HashMap<String, Object> storage)
    {
        String variableName = argument.replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "")
                .replace("=", "")
                .replace("\"", "")
                .replace(";", "")
                .replace("text", "");
    }
}
