package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day2_Part2 {

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

    private static int[] getHandPoints(String userChoice, String enemyChoice) {
        int[] hands = {0, 0};
        System.out.print(userChoice + " " + enemyChoice + " ");

        // lose if X
        if (userChoice.equals("X")) {
            switch (enemyChoice) {
                case "A":
                    hands[0] = 3;
                    hands[1] = 1;
                    break;
                case "B":
                    hands[0] = 1;
                    hands[1] = 2;
                    break;
                case "C":
                    hands[0] = 2;
                    hands[1] = 3;
                    break;
            } 
        }
        // draw if Y
        else if (userChoice.equals("Y")) {
            switch (enemyChoice) {
                case "A":
                    hands[0] = 1;
                    hands[1] = 1;
                    break;
                case "B":
                    hands[0] = 2;
                    hands[1] = 2;
                    break;
                case "C":
                    hands[0] = 3;
                    hands[1] = 3;
                    break;
            }
        }
        // win if Z
        else {
            switch (enemyChoice) {
                case "A":
                    hands[0] = 2;
                    hands[1] = 1;
                    break;
                case "B":
                    hands[0] = 3;
                    hands[1] = 2;
                    break;
                case "C":
                    hands[0] = 1;
                    hands[1] = 3;
                    break;
            } 
        }

        System.out.print(hands[0] + " " + hands[1] + "\n");
        return hands;
    }
}