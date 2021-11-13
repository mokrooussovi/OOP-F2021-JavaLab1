/**
 * @JavaLab1
 * @author Ivan Mokrooussov, Tyler Henry
 * @IvanStudentID: 100808605
 * @TylerStudentID: 10053023
 * @date: November 12, 2021
 * @description: Logic, Arrays, and Strings
 */

package ca.durhamcollege;

import java.util.Scanner;

public class Main
{
    /**
     * This method gets a string from the console
     * @param prompt a friendly message to show the user
     * @param object the object type to store the console input
     * @param <T> the generic type
     * @return
     */
    public static <T> T getConsoleInput(String prompt, T object)
    {
        Scanner console = new Scanner(System.in);
        System.out.print(prompt);

        switch (object.getClass().getSimpleName())
        {
            case "String":
                return (T) console.nextLine();
            case "Integer":
                return (T) ((Integer) console.nextInt());
            default:
                return (T) console.nextLine();
        }
    }

    /**
     * This function prints a generic array
     * @param log the array to print
     * @param <T> the generic type
     */
    public static <T> void printLog(T[] log)
    {
        for (var line:log)
        {
            System.out.println(line);
        }
    }

    /**
     * This function adds elements to a generic array
     * @param log the array to add elements to
     * @param <T> the generic type
     * @throws Exception
     */
    public static <T> void buildLog(T[] log) throws Exception
    {
        int capacity = 0;
        String prompt = "";

        if(log instanceof  String[])
        {
            capacity = Config.NUM_OF_PLAYERS;
            prompt = "Enter Player Name: ";
        }
        else if (log instanceof Integer[])
        {
            capacity = Config.NUM_OF_PLAYERS;
            prompt = "Enter Player Score: ";
        }
        else
        {
            throw new Exception("Exception message");
        }

        for (int i = 0; i < capacity; i++)
        {
            if(log instanceof  String[])
            {
                log[i] = (T)"";
            }
            else if (log instanceof Integer[])
            {
                log[i] = (T) new Integer(0);
            }

            log[i] = (T) getConsoleInput(prompt, log[i]);
        }
    }


    /**
     * Entry point for our application
     * @param args
     */
    public static void main(String[] args)
    {
        String[] Log = new String[Config.NUM_OF_PLAYERS];
        Integer[] intLog = new Integer[Config.NUM_OF_GAMES_ROUND_ONE];
        Integer[] intLog2 = new Integer[Config.NUM_OF_GAMES_ROUND_TWO];

        try
        {
            buildLog(Log);
            printLog(Log);
            System.out.println(); // empty space

            buildLog(intLog);
            printLog(intLog);
            System.out.println(); // empty space

            buildLog(intLog2);
            printLog(intLog2);
            System.out.println(); // empty space
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }
}