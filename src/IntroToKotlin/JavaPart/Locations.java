package IntroToKotlin.JavaPart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Locations {
    public static Map<Integer, Location> locations = new HashMap<>();

    //Executed once at the beginning
    static {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new FileReader("locations_big.txt"));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()) {
                Integer loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                locations.put(loc, new Location(loc, description));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            scanner.close();
        }

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()) {
                Integer locId = scanner.nextInt();
                Location loc = locations.get(locId);

                scanner.skip(scanner.delimiter());
                String restData = scanner.nextLine();
                String direction = restData.split(scanner.delimiter().pattern())[0];
                Integer destination = Integer.parseInt(restData.split(scanner.delimiter().pattern())[1]);

                loc.addExit(direction, destination);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static Map<Integer, Location> getLocations () {
        return locations;
    }
}
