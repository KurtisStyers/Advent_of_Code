package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day1_Part1 {
    public static void getCals() {
		try {
			File file = new File("day1/calories.txt");
			Scanner reader = new Scanner(file);
			int total = 0;
			int elfCount = 0;
			int maxElf = 0;
			int max = 0;
			String value = "";
			
			while (reader.hasNextLine()) {
				value = reader.nextLine();
				if (value.equals("")) {
					elfCount++;
					if (total > max) {
						max = total;
						maxElf = elfCount;
					}
					total = 0;
				}
				else {
					total += Integer.parseInt(value);
				}
			}
			reader.close();
			System.out.printf("Max Calories: %d\n", max);
			System.out.printf("Elf with max calories: %d\n", maxElf);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
}

