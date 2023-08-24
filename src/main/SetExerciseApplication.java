package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SetExerciseApplication {

	// instatiate new hashset

	public static void main(String[] args) throws IOException {

		Set<String> pokerHands = new HashSet<>();

		pokerHands.add("ACE HIGH");
		pokerHands.add("QUEEN HIGH");
		// extract the data from the CSV
		extractDataFromCSV("PokerHands.csv", pokerHands);
		// remove ACE HIGH and QUEEN HIGH
		printToConsole(pokerHands);
		
		pokerHands.remove("ACE HIGH");
		pokerHands.remove("QUEEN HIGH");
			
		printToConsole(pokerHands);

		// Update PAIR to DEUCES
		pokerHands.remove("PAIR");
		pokerHands.add("DEUCES");
				
		printToConsole(pokerHands);
	}

	public static void printToConsole(Set<String> pokerHands) {
		for (String hand : pokerHands) {
			System.out.println(hand);
		}
		System.out.println();

	}

	public static Set<String> extractDataFromCSV(String fileName, Set<String> pokerHands) throws IOException {
		try (BufferedReader fileReader = new BufferedReader(new FileReader("PokerHands.csv"))) {
			fileReader.readLine();
			String line;

			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");

				String players = lineData[0];
				String hand = lineData[1].trim();
				pokerHands.add(hand);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		return null;
	}

}
