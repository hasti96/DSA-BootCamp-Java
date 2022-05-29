package workAtTech.dynamicProgramming.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePathsMemo(3, 2, new HashMap<>()));
        System.out.println(uniquePathsMemo(2, 3, new HashMap<>()));
        System.out.println(uniquePathsMemo(3, 3, new HashMap<>()));
        System.out.println(uniquePathsMemo(2, 2, new HashMap<>()));

        System.out.println("==================================");
        
        System.out.println(uniquePathstable(3, 2));
        System.out.println(uniquePathstable(2, 3));
        System.out.println(uniquePathstable(3, 3));
        System.out.println(uniquePathstable(100, 100));

        Integer a = uniquePathstable(100, 100);
        System.out.println(a);

    }

    public static int uniquePaths(int m, int n) {
	    if(m == 1 && n == 1) return 1;
        if(m < 1 || n < 1) return 0;

        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
	}

    public static int uniquePathsMemo(int m, int n, Map<String, Integer> cache) {
        String key = String.valueOf(m) + "," + String.valueOf(n);
        if(cache.containsKey(key)) return cache.get(key);

	    if(m == 1 && n == 1) return 1;
        if(m < 1 || n < 1) return 0;

        cache.put(key, uniquePathsMemo(m-1, n, cache) + uniquePathsMemo(m, n-1, cache));
        return cache.get(key).intValue();
	}

    public static int uniquePathstable(int m, int n) {
		int[][] table = new int[m+1][n+1];
        for(int i=0; i < table.length; i++) {
            Arrays.fill(table[i], 0);
        }        
        
        table[1][1] = 1;

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i+1 <= m) {
                    table[i+1][j] = table[i][j] + table[i+1][j];
                }

                if(j+1 <= n) {
                    table[i][j+1] = table[i][j] + table[i][j+1];
                }

            }
        }

        return table[m][n];
	}
}
