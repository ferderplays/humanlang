package me.ferdis.humanlang;

import me.ferdis.humanlang.tools.Interpreter;

import java.util.Scanner;

public class Main
{

    /**
     * I decided to make just about the most humane programming language ever
     *
     * it is an interpreted language tho
     *
     * I did not use AI for any coding here, only for bug fixes whenever they were not obvious
     *
     * this language is me at 17 githubmaxxing in the summer so i can land maybe land a job in the future
     *
     * I believe the language has potential in making coding easier more mind-focused without the need to use AI to write all the code
     *
     * I mean if someone speaks english fluently and doesnt have it easy learning this language thats a huge skill issue
     */

    public static void main(String[] args) {
        executeCode();
    }

    public static void executeCode() {
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
