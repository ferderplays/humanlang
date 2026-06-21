package me.ferdis.humanlang;

import me.ferdis.humanlang.tools.Printer;

import java.io.IOException;
import java.util.Scanner;

public class Main
{

    /**
     * I decided to make just about the most humane programming language ever
     *
     * it is an interpreted language tho
     */

    public static void main(String[] args) throws IOException {
        executeCode();
    }

    public static void executeCode() throws IOException {
        Scanner reader = new Scanner(System.in);

        boolean isExecutorRunning = true;

        // runs until the executor is stopped
        while (isExecutorRunning)
        {

            System.out.println("Enter code below : ");

            String line = reader.nextLine();

            // exec stop is the command to stop the executor
            if (line.equals("exec stop"))
            {
                isExecutorRunning = false;
            }
            else
            {
                //Printer.line("[SYSTEM] current argument: " + line);

                Interpreter.interpret(line);
            }
        }

        reader.close();
    }
}
