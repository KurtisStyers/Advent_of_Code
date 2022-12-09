package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day2_Part1 {

    
    /**
     * Reads through a file containing the hands from a rock-paper-scissors game 
     * and calculates the users points
     */
    public static void getWins() {
        try {
            File file = new File("day2/rockpaperscissors.txt");
            Scanner reader = new Scanner(file);
            String enemyChoice = "";
            String userChoice = "";
            int[] hands = new int[2];
            int totalPoints = 0;

            while (reader.hasNext()) {
                enemyChoice = reader.next();
                userChoice = reader.next();

                // get points for choice
                hands = getHandPoints(userChoice, enemyChoice);
                totalPoints += hands[0];

                // check for win and add points for outcome 
                totalPoints += getWinPoints(hands);               
            }
            reader.close();
            System.out.printf("Total Points: %d\n", totalPoints);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    /**
     * Returns the points from the outcome of a rock-paper-scissors game.
     * @param hands an array that holds each players hand. rock: 3, paper: 2, scissors: 1
     * @return      the points for the outcome of the game. win: 6, draw: 3, lose: 0
     */
    private static int getWinPoints(int[] hands) {
        // draw
        if (hands[0] == hands[1]) {
            return 3;
        }
        //win: (rock vs scissors) || (paper vs rock) || (scissors vs paper)
        else if ((hands[0] == 1 && hands[1] == 3) || (hands[0] == 2 && hands[1] == 1) || (hands[0] == 3 && hands[1] == 2)) {
            return 6;
        }
        else {
            return 0;
        }
        
    }

    /**
     * Returns the numerical value for the hand played in rock-paper-scissors
     * @param userChoice the hand played by the user. X: rock, Y: paper, Z: scissors
     * @param enemyChoice the hand played by the opponent. A: rock, B: paper, C: scissors
     * @return an array holding the point values of the user hand and the opponent hand
     */
    private static int[] getHandPoints(String userChoice, String enemyChoice) {
        int[] points = {0, 0};
        
        switch (userChoice) {
            case "X": 
                points[0] = 1;
                break;
            case "Y": 
                points[0] = 2;
                break;
            case "Z":
                points[0] = 3;
                break;
            default:
                points [0]= 0;
        }

        switch (enemyChoice) {
            case "A": 
                points[1] = 1;
                break;
            case "B": 
                points[1] = 2;
                break;
            case "C":
                points[1] = 3;
                break;
            default:
                points [1]= 0;
        }

        return points;
    }
}