package recursion.freecodecamp.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Say that you are a traveller on a 2D grid. You begin in the top-left
 * corner and your goal is to travel to the bottom-right corner.
 * You may only move down or right.
 * 
 * In how many ways can you travel to the goal on a grid with dimensions
 * m * n ?
 */

public class gridTraveler {
    
    private static Map<String, Float> cache = new HashMap<>();

    public static void main(String[] argv) {
        System.out.println(gridTravel(2,3));
        cache.clear();
        System.out.println(gridTravel(3,3));
        cache.clear();
        System.out.println(gridTravel(18,18));
        cache.clear();
    }

    public static Float gridTravel(int row, int col) {

        String key = String.valueOf(row) + "," + String.valueOf(col);
        
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        if(row == 1 && col == 1) {
            return 1f;
        } 
        
        if(row == 0 || col == 0) {
            return 0f;
        }

        cache.put(key, gridTravel(row - 1, col) + gridTravel(row, col-1));

        return cache.get(key);
    }
}
