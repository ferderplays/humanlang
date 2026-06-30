package me.ferdis.humanlang.tools;

import me.ferdis.humanlang.types.Number;

import java.util.HashMap;

public class Functions
{

    public static void wholeNumber(String argument, String variableName, HashMap<String, Object> storage, HashMap<String, String> typeStorage)
    {
        /* numeric operations */
        if (argument.startsWith(variableName + ".add("))
        {
            Number.add(argument, storage);
        }
        else if (argument.startsWith(variableName + ".subtract("))
        {
            Number.subtract(argument, storage);
        }
        else if (argument.startsWith(variableName + ".multiply("))
        {
            Number.multiply(argument, storage);
        }
        else if (argument.startsWith(variableName + ".divide("))
        {
            Number.divide(argument, storage);
        }

        /* conversion */
        else if (argument.startsWith(variableName + ".toText("))
        {
            Number.stringify(argument, storage, typeStorage);
        }
        else if (argument.startsWith(variableName + ".toReal("))
        {
            Number.parseReal(argument, storage, typeStorage);
        }
    }

    public static void realNumber(String argument, String variableName, HashMap<String, Object> storage, HashMap<String, String> typeStorage)
    {
        /* numeric operations */
        if (argument.startsWith(variableName + ".add("))
        {
            Number.addReal(argument, storage);
        }
        else if (argument.startsWith(variableName + ".subtract("))
        {
            Number.subtractReal(argument, storage);
        }
        else if (argument.startsWith(variableName + ".multiply("))
        {
            Number.multiplyReal(argument, storage);
        }
        else if (argument.startsWith(variableName + ".divide("))
        {
            Number.divideReal(argument, storage);
        }

        /* conversion */
        else if (argument.startsWith(variableName + ".toText("))
        {
            Number.stringifyReal(argument, storage, typeStorage);
        }
        else if (argument.startsWith(variableName + ".toWhole("))
        {
            Number.parseWhole(argument, storage, typeStorage);
        }
    }

    public static void text(String argument, String variableName, HashMap<String, Object> storage)
    {
        if (argument.startsWith(variableName + ".splitBy("))
        {

        }
    }
}
