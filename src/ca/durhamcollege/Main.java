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

    // declare float array called average with length equal to number of players
    static Float[] average = new Float[Config.NUM_OF_PLAYERS];

    /**
     * This method allows get string from the console
     * @param prompt the message prompts to the user
     * @param object user input
     * @return string
     */
    public static String getConsoleInput(String prompt, String object) {
        Scanner console = new Scanner(System.in);
        System.out.print(prompt);
        return console.nextLine();

    }

    /**
     * This method allows get integer from the console
     * @param prompt the message send to the user
     * @param object user input
     * @return integer
     */
    public static int getConsoleInput(String prompt, int object) {
        Scanner console = new Scanner(System.in);
        System.out.print(prompt);
        return ((Integer) console.nextInt());
    }

    /**
     * This method allows us to read the user input from console for players names
     * and add them to the array of instances on Class Player
     * @param players array of instances class Player
     * @param log array type of string of user input
     */
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

    /**
     * This method allows us to create multi array of score different players
     * on different game as well as calculate average these entries
     * @param log multi array of game scores of integer type
     */
    public static void buildScoreArray(Integer[][] log) {
        String prompt = "";
        for (int i = 0; i < Config.NUM_OF_PLAYERS; i++) {
            average[i] = 0.0f;
        }

        for (int i = 0; i < Config.NUM_OF_GAMES; i++) {
            for (int j = 0; j < Config.NUM_OF_PLAYERS; j++) {
                prompt = "Please enter  Player score for Game # " + (i + 1) + ": ";
                boolean isValid = true;
                while (isValid) {
                    log[i][j] = new Integer(0);
                    log[i][j] = (Integer) getConsoleInput(prompt, log[i][j]);
                    if (log[i][j] % 1 == 0) {
                        if (log[i][j] >= Config.MINIMUM_SCORE && log[i][j] <= Config.MAXIMUM_SCORE) {
                            average[j] += log[i][j];
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
        for (int i = 0; i < Config.NUM_OF_PLAYERS; i++) {
           average[i] = average[i]/Config.NUM_OF_GAMES;
        }
    }

    /**
     * This method might allow us to build array by collecting data from the console
     * @param log array of type Integer for players on particular round of game
     */
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

    /**
     * This method allows us to display final report into the console
     * @param players array of instances of Player class
     * @param intLog multi array of game scores of integer type
     * @param average array of float type on average of specific player score
     */
    public static void displayReport(Player[] players, Integer[][] intLog, Float[] average)
    {
        for (int i = 0; i < Config.NUM_OF_PLAYERS; i++) {
            players[i].scoreDetails();
            for (int j = 0; j < Config.NUM_OF_GAMES; j++) {
                System.out.println("Game # " + (j + 1) + ":   " + intLog[j][i]);
            }
            players[i].averageDetails();
            System.out.println(average[i]);
        }
    }

    /**
     * This method allows us to read user input from console
     * @param players array of instances of Player class
     * @param Log array type of string of user input
     * @param intLog multi array of game scores of integer type
     */
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
            // readScore() method can substitute next two methods
            // buildPlayerArray(players, Log);
            // buildScoreArray(intLog);
            displayReport(players, intLog, average);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
