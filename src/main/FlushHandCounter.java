package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FlushHandCounter {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// instantiate a new map, define k/v data types, CRUD: create step
		Map<String, Integer> flushCount = new HashMap<>();
		flushCount.put("Patrick Stewart", 0);
		flushCount.put("Rita Repulsa", 0);
		flushCount.put("He Man", 0);
		flushCount.put("TJ Hooker", 0);

//		System.out.println(flushCount);
		// CRUD read step
		try (BufferedReader fileReader = new BufferedReader(new FileReader("PokerHands.csv"))) {
			fileReader.readLine();
			String line;

			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");

				String player = lineData[0];
				String hand = lineData[1].trim();

				if (hand.equals("FLUSH")) {
					if (flushCount.containsKey(player)) {
						int currentCount = flushCount.get(player);
						flushCount.put(player, currentCount + 1);
					}
				}

			}
			System.out.println(flushCount);
		}
		// CRUD update step

		if (flushCount.containsKey("Rita Repulsa")) {

			int ritaCount = flushCount.get("Rita Repulsa");

			flushCount.put("Zordon", ritaCount);
			flushCount.remove("Rita Repulsa");
		}
		System.out.println(flushCount);
		// CRUD delete step
		flushCount.remove("He Man");
		System.out.println(flushCount);

	}

}
