package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1_Part2 {
	public static void getCals() {
		try {
			File file = new File("day1/calories.txt");
			Scanner reader = new Scanner(file);
			ArrayList<Integer> calories = new ArrayList<>();
			int total = 0;
			int max = 0;
			String value = "";
			
			while (reader.hasNextLine()) {
				value = reader.nextLine();
				if (value.equals("")) {
					calories.add(total);
					total = 0;
				}
				else {
					total += Integer.parseInt(value);
				}
			}
			reader.close();
			Collections.sort(calories);
			max = calories.get(calories.size() - 1) + calories.get(calories.size() - 2) + calories.get(calories.size() - 3);
			System.out.printf("Max Calories: %d\n", max);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
}