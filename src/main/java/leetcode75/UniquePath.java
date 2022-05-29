package leetcode75;

import java.util.HashMap;
import java.util.Map;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePath(19, 13, new HashMap<>()));
    }

    public static int uniquePath(int m, int n) {
        if(m == 1 && n == 1) return 1;
        if(m< 1 || n < 1) return 0;

        return uniquePath(m-1, n) + uniquePath(m, n-1);
    }

    public static int uniquePath(int m, int n, Map<String, Integer> cache) {
        String key = String.valueOf(m)+","+String.valueOf(n);

        if(cache.containsKey(key)) return cache.get(key).intValue();

        if(m == 1 && n == 1) return 1;
        if(m< 1 || n < 1) return 0;

        cache.put(key, uniquePath(m-1, n, cache) + uniquePath(m, n-1, cache));
        return cache.get(key);
    }
}
