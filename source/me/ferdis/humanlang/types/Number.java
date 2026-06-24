package me.ferdis.humanlang.types;


import me.ferdis.humanlang.tools.Printer;

import java.util.HashMap;

public class Number
{
    public static void registerWhole(String argument, HashMap<String, Object> storage)
    {
        String variableValue = argument.replace(argument.substring(0, argument.indexOf("=")), "")
                .replace(" ", "")
                .replace("=", "")
                .replace(";", "");

        String variableName = argument.replace(argument.substring(argument.indexOf("=")), "")
                .replace(argument.substring(0, 12), "")
                .replace(" ", "")
                .replace("\"", "");

        int whole = Integer.parseInt(variableValue);

        storage.put(variableName, whole);

        Printer.line("[WHOLE NUMBER] name: " + variableName + " | value: " + whole);

        //Printer.print(wholeNumberVariables);
    }

    public static void registerReal(String argument, HashMap<String, Object> storage)
    {
        String variableValue = argument.replace(argument.substring(0, argument.indexOf("=")), "")
                .replace(" ", "")
                .replace("=", "")
                .replace(";", "");

        String variableName = argument.replace(argument.substring(argument.indexOf("=")), "")
                .replace(argument.substring(0, 12), "")
                .replace(" ", "")
                .replace("\"", "");

        double whole = Double.parseDouble(variableValue);

        storage.put(variableName, whole);

        Printer.line("[WHOLE NUMBER] name: " + variableName + " | value: " + whole);

        //Printer.print(wholeNumberVariables);
    }

    public static void add(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("whole add ", "")
                .replace(argument.substring(argument.indexOf(",")), "").replace(" ", "");

        String additionValue = argument.replace(argument.substring(0, argument.indexOf(",")), "")
                .replace(" ", "")
                .replace(";", "")
                .replace(",", "");

        int added = Integer.parseInt(additionValue);

        int number = (int) storage.get(variable);
        number = number + added;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void addReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("real add ", "")
                .replace(argument.substring(argument.indexOf(",")), "").replace(" ", "");

        String additionValue = argument.replace(argument.substring(0, argument.indexOf(",")), "")
                .replace(" ", "")
                .replace(";", "")
                .replace(",", "");

        double added = Double.parseDouble(additionValue);

        double number = (double) storage.get(variable);
        number = number + added;

        storage.remove(variable);

        storage.put(variable, number);
    }
}
