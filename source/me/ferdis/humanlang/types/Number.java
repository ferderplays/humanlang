package me.ferdis.humanlang.types;


import me.ferdis.humanlang.tools.Printer;

import java.util.ArrayList;
import java.util.HashMap;

public class Number
{
    public static void registerWhole(String argument, HashMap<String, Object> storage, HashMap<String, String> typeStorage)
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

        typeStorage.put(variableName, "WHOLE NUMBER");

        Printer.line("[WHOLE NUMBER] name: " + variableName + " | value: " + whole);

        //Printer.print(wholeNumberVariables);
    }

    public static void registerReal(String argument, HashMap<String, Object> storage, HashMap<String, String> typeStorage)
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

        typeStorage.put(variableName, "WHOLE NUMBER");

        Printer.line("[WHOLE NUMBER] name: " + variableName + " | value: " + whole);

        //Printer.print(wholeNumberVariables);
    }

    public static void add(String argument, HashMap<String, Object> storage)
    {

        String variable = argument.substring(0, argument.indexOf("."));

        String additionValue = argument.replace(variable, "")
                .replace(".add(", "")
                .replace(");", "");

        int added = Integer.parseInt(additionValue);

        int number = (int) storage.get(variable);
        number = number + added;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void addReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String additionValue = argument.replace(variable, "")
                .replace(".add(", "")
                .replace(");", "");

        double added = Double.parseDouble(additionValue);

        double number = (double) storage.get(variable);
        number = number + added;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void subtract(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String subtractorValue = argument.replace(variable, "")
                .replace(".subtract(", "")
                .replace(");", "");

        int subtractor = Integer.parseInt(subtractorValue);

        int number = (int) storage.get(variable);
        number = number - subtractor;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void subtractReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String subtractorValue = argument.replace(variable, "")
                .replace(".subtract(", "")
                .replace(");", "");

        double subtractor = Double.parseDouble(subtractorValue);

        double number = (double) storage.get(variable);
        number = number - subtractor;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void multiply(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String multiplicatorValue = argument.replace(variable, "")
                .replace(".multiply(", "")
                .replace(");", "");

        int multiplicator = Integer.parseInt(multiplicatorValue);

        int number = (int) storage.get(variable);
        number = number * multiplicator;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void multiplyReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String multiplicatorValue = argument.replace(variable, "")
                .replace(".multiply(", "")
                .replace(");", "");

        double multiplicator = Double.parseDouble(multiplicatorValue);

        double number = (double) storage.get(variable);
        number = number * multiplicator;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void divide(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String dividerValue = argument.replace(variable, "")
                .replace(".divide(", "")
                .replace(");", "");

        int divider = Integer.parseInt(dividerValue);

        int number = (int) storage.get(variable);
        number = number / divider;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void divideReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String dividerValue = argument.replace(variable, "")
                .replace(".divide(", "")
                .replace(");", "");

        double divider = Double.parseDouble(dividerValue);

        double number = (double) storage.get(variable);
        number = number / divider;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void stringify(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        Integer toStringify = (Integer) storage.get(variable);

        storage.put(variable + "_string", toStringify.toString());
    }

    public static void stringifyReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        Double toStringify = (Double) storage.get(variable);

        storage.put(variable + "_string", toStringify.toString());
    }

    public static String toString(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        Integer toStringify = (Integer) storage.get(variable);

        return toStringify.toString();
    }

    public static void parseWhole(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String toParse = (String) storage.get(variable);

        storage.put(variable + "_whole", Integer.parseInt(toParse));
    }

    public static void parseReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.substring(0, argument.indexOf("."));

        String toParse = (String) storage.get(variable);

        storage.put(variable + "_real", Double.parseDouble(toParse));
    }
}
