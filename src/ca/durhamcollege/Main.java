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

public class Main {
    public static String getConsoleInput(String prompt, String object) {
        Scanner console = new Scanner(System.in);
        System.out.print(prompt);
        return console.nextLine();

    }


    public static int getConsoleInput(String prompt, int object) {
        Scanner console = new Scanner(System.in);
        System.out.print(prompt);
        return ((Integer) console.nextInt());

    }

    public static void buildPlayerArray(Player[] players, String[] log) {
        int capacity = 0;
        String prompt = "";

        capacity = Config.NUM_OF_PLAYERS;
        prompt = "Enter Player Name: ";

        for (int i = 0; i < capacity; i++) {
            log[i] = (String) "";
            log[i] = (String) getConsoleInput(prompt, log[i]);

            players[i] = new Player(log[i]);
        }
    }


    public static void buildScoreArray(Integer[][] log) {
        String prompt = "";
        Float[] average = new Float[Config.NUM_OF_PLAYERS];
        for (int i = 0; i < Config.NUM_OF_GAMES; i++) {
            for (int j = 0; j < Config.NUM_OF_PLAYERS; j++) {
                prompt = "Please enter  Player score for Game # " + (i + 1) + ": ";
                boolean isValid = true;
                while (isValid) {
                    log[i][j] = new Integer(0);
                    log[i][j] = (Integer) getConsoleInput(prompt, log[i][j]);
                    if (log[i][j] % 1 == 0) {
                        if (log[i][j] >= Config.MINIMUM_SCORE && log[i][j] <= Config.MAXIMUM_SCORE) {
                            isValid = false;
                        } else {
                            System.out.println("Invalid input. Value must be between 0 and 300. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Value must be numeric integer");
                    }
                }
            }
        }
    }

    public static void buildIntegerLog(Integer[] log) {
        String prompt = "";

        for (int i = 0; i < Config.NUM_OF_PLAYERS; i++) {
            prompt = "Please enter  Player score for Game # : ";
            boolean isValid = true;
            while (isValid) {
                log[i] = new Integer(0);
                log[i] = (Integer) getConsoleInput(prompt, log[i]);
                if (log[i] % 1 == 0) {
                    if (log[i] >= Config.MINIMUM_SCORE && log[i] <= Config.MAXIMUM_SCORE) {
                        isValid = false;
                    } else {
                        System.out.println("Invalid input. Value must be between 0 and 300. Please try again.");
                    }
                } else {
                    System.out.println("Invalid input. Value must be numeric integer");
                }
            }
        }
    }

    public static void displayReport(Player[] players, Integer[][] intLog)
    {
        for (int i = 0; i < Config.NUM_OF_PLAYERS; i++) {
            players[i].scoreDetails();
            for (int j = 0; j < Config.NUM_OF_GAMES; j++) {
                System.out.println("Game # " + (j + 1) + ":   " + intLog[j][i]);
            }
        }
    }

    public static void readScore(Player[] players, String[] Log, Integer[][] intLog)
    {
        buildPlayerArray(players, Log);
        buildScoreArray(intLog);
    }

    //****************************************************************

    /**
     * Entry point for our application
     * @param args
     */
    public static void main(String[] args)
    {
        String[] Log = new String[Config.NUM_OF_PLAYERS];
        Integer[][] intLog = new Integer[Config.NUM_OF_GAMES][Config.NUM_OF_PLAYERS];
        Player[] players = new Player[Config.NUM_OF_PLAYERS];

        try {

            readScore(players, Log, intLog);
            //buildPlayerArray(players, Log);
            //buildScoreArray(intLog);
            displayReport(players, intLog);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
