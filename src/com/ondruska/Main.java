package com.ondruska;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() == 1) {
                if (exits.containsKey(direction)) {
                    loc = exits.get(direction);
                } else {
                    System.out.println("you cannot go in that direction");
                }
            } else {
                if (exits.containsKey(determineDirection(direction))) {
                    loc = exits.get(determineDirection(direction));
                } else {
                    System.out.println("you cannot go in that direction");
                }
            }
        }


    }

    public static String determineDirection(String direction) {
        String[] directionSplit = direction.split(" ");
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("NORTH", "N");
        stringMap.put("SOUTH", "S");
        stringMap.put("EAST", "E");
        stringMap.put("WEST", "W");
        stringMap.put("QUIT", "Q");
        for (String s : directionSplit) {
            if(stringMap.containsKey(s)) {
                return stringMap.get(s);
            }
        }
        return null;
    }
}
