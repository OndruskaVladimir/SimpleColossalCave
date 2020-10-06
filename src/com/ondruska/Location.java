package com.ondruska;

import java.util.HashMap;
import java.util.Map;

public final class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;

        //test to see, if the this.exits if null or not. If it is null, then we should send empty parameters with this.exits.
        if(exits != null) {
            this.exits = new HashMap<>(exits);
        } else {
            this.exits = new HashMap<>();
        }

        this.exits.put("Q", 0);

    }

//    public void addExit(String direction, int location) {
//        this.exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(this.exits);
    }

    protected void addExit(String direction, int location) {
            exits.put(direction, location);
    }
}
