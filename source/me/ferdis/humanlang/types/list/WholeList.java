package me.ferdis.humanlang.types.list;

import me.ferdis.humanlang.tools.Printer;

import java.util.ArrayList;
import java.util.HashMap;

public class WholeList
{

    public static void registerList(String argument, HashMap<String, Object> storage, HashMap<String, String> typeStorage)
    {
        String variableName = argument.substring(0, argument.indexOf("="))
                .replace("list<whole>", "")
                .replace(" ", "")
                .replace("=", "");

        Printer.line("Variable name: " + variableName);

        String[] values = argument.substring(argument.indexOf("["))
                .replace("];", "")
                .split(",");

        ArrayList<Integer> list = new ArrayList<>();

        for (String value : values)
        {
            int val = Integer.parseInt(value.replace(",", ""));
            list.add(val);
        }

        storage.put(variableName, list);
        typeStorage.put(variableName, "LIST<WHOLE>");
    }
}
