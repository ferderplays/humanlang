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
                .replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "");

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
                .replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "");

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

    public static void subtract(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("whole subtract ", "")
                .replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "");

        String subtractorValue = argument.replace(argument.substring(0, argument.indexOf(",")), "")
                .replace(" ", "")
                .replace(";", "")
                .replace(",", "");

        int subtractor = Integer.parseInt(subtractorValue);

        int number = (int) storage.get(variable);
        number = number - subtractor;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void subtractReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("real subtract ", "")
                .replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "");

        String subtractorValue = argument.replace(argument.substring(0, argument.indexOf(",")), "")
                .replace(" ", "")
                .replace(";", "")
                .replace(",", "");

        double subtractor = Double.parseDouble(subtractorValue);

        double number = (double) storage.get(variable);
        number = number - subtractor;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void multiply(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("whole multiply ", "")
                .replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "");

        String multiplicatorValue = argument.replace(argument.substring(0, argument.indexOf(",")), "")
                .replace(" ", "")
                .replace(";", "")
                .replace(",", "");

        int multiplicator = Integer.parseInt(multiplicatorValue);

        int number = (int) storage.get(variable);
        number = number * multiplicator;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void multiplyReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("real multiply ", "")
                .replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "");

        String multiplicatorValue = argument.replace(argument.substring(0, argument.indexOf(",")), "")
                .replace(" ", "")
                .replace(";", "")
                .replace(",", "");

        double multiplicator = Double.parseDouble(multiplicatorValue);

        double number = (double) storage.get(variable);
        number = number * multiplicator;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void divide(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("whole divide ", "")
                .replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "");

        String dividerValue = argument.replace(argument.substring(0, argument.indexOf(",")), "")
                .replace(" ", "")
                .replace(";", "")
                .replace(",", "");

        int divider = Integer.parseInt(dividerValue);

        int number = (int) storage.get(variable);
        number = number / divider;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void divideReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("real divide ", "")
                .replace(argument.substring(argument.indexOf(",")), "")
                .replace(" ", "");

        String dividerValue = argument.replace(argument.substring(0, argument.indexOf(",")), "")
                .replace(" ", "")
                .replace(";", "")
                .replace(",", "");

        double divider = Double.parseDouble(dividerValue);

        double number = (double) storage.get(variable);
        number = number / divider;

        storage.remove(variable);

        storage.put(variable, number);
    }

    public static void stringify(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("whole to-string ", "")
                .replace(";", "");

        Integer toStringify = (Integer) storage.get(variable);

        String stringified = toStringify.toString();

        storage.put(variable + "_string", stringified);
    }

    public static void stringifyReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("real to-string ", "")
                .replace(";", "");

        Double toStringify = (Double) storage.get(variable);

        String stringified = toStringify.toString();

        storage.put(variable + "_string", stringified);
    }

    public static void parseWhole(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("get-whole-number ", "")
                .replace(";", "");

        String toParse = storage.get(variable).toString()
                .replace("\"", "");

        storage.put(variable + "_whole", Integer.parseInt(toParse));
    }

    public static void parseReal(String argument, HashMap<String, Object> storage)
    {
        String variable = argument.replace("get-whole-number ", "")
                .replace(";", "");

        String toParse = storage.get(variable).toString()
                .replace("\"", "");

        storage.put(variable + "_whole", Double.parseDouble(toParse));
    }
}
