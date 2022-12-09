package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day2_Part1 {
    //first column: A) rock  B) paper  C) scissors
    //second column: X) rock  Y) paper  Z) scissors
    //score for each round is score for shape plus outcome
    // points: rock 1  paper 2  scissors 3
    // points for outcome: loss 0  draw 3  win 6

    public static void getWins() {
        try {
            File file = new File("day2/rockpaperscissors.txt");
            Scanner reader = new Scanner(file);
            String enemyChoice = "";
            String userChoice = "";
            int[] points = new int[2];
            int totalPoints = 0;

            // loop through input
            while (reader.hasNext()) {
                enemyChoice = reader.next();
                userChoice = reader.next();

                // get points for choice
                points = getHandPoints(userChoice, enemyChoice);
                totalPoints += points[0];

                // check for win and add points for outcome 
                totalPoints += getWinPoints(points);               
            }
            reader.close();
            System.out.printf("Total Points: %d\n", totalPoints);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    private static int getWinPoints(int[] points) {
        // draw
        if (points[0] == points[1]) {
            return 3;
        }
        //win: (rock vs scissors) || (paper vs rock) || (scissors vs paper)
        else if ((points[0] == 1 && points[1] == 3) || (points[0] == 2 && points[1] == 1) || (points[0] == 3 && points[1] == 2)) {
            return 6;
        }
        else {
            return 0;
        }
        
    }

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