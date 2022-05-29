package recursion.freecodecamp.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class fibonacci {
    private static Map<Float, Float> cache = new HashMap<>();
    public static void main(String[] argv) {
        System.out.println(fib(6));
        System.out.println(fib(50));
    }

    public static float fib(float num) {

        if (num <= 2) {
            return 1;
        }

        if(cache.containsKey(num)) {
            return cache.get(num);
        } else {
            float temp = fib(num - 1) + fib(num - 2);
            cache.put(num, temp);
            return cache.get(num);
        }
    }
}
