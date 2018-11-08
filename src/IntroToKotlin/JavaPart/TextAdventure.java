package IntroToKotlin.JavaPart;

import java.util.Map;
import java.util.Scanner;

public class TextAdventure {
    private static Map<Integer, Location> locations = Locations.locations;

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer loc = 64;

        while (true) {
            Location location = locations.get(loc);
            System.out.println(location.getDescription());

            if (loc==0)
                break;

            Map<String, Integer> exits = location.getExits();

            StringBuilder sb = new StringBuilder();
            sb.append("Available exits are ");

            for (String exit: exits.keySet())
                sb.append(exit + ", ");

            System.out.println(sb.toString());

            String direction = scanner.nextLine().toUpperCase();

            if (exits.containsKey(direction))
                loc = exits.get(direction);
            else
                System.out.println("\n----You cannot go there----\n");
        }
    }
}
