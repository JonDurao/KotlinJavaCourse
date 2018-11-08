package IntroToKotlin.JavaPart;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final Integer locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(Integer locationId, String description) {
        this.locationId = locationId;
        this.description = description;
        exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    public Integer getLocationId() {return locationId;}
    public String getDescription() {return description;}
    public Map<String, Integer> getExits() {return exits;}

    protected void addExit(String direction, Integer location) {exits.put(direction,location);}
}
