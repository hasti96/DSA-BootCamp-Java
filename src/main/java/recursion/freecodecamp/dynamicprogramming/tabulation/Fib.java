package recursion.freecodecamp.dynamicprogramming.tabulation;

import java.util.Arrays;

/**
 * Write a function 'fib(n)' that takes in a number as an argument,
 * The function should return the n-th number of the Fibonacci sequence.
 */

public class Fib {
    
    public static void main(String[] args) {
        System.out.println(fibUsingIterative(6));
        System.out.println(fibUsingIterative(7));
        System.out.println(fibUsingIterative(8));
        System.out.println(fibUsingIterative(50));
    }

    public static Integer fibUsingIterative(int n) {
        int[] table = new int[n+2];
        Arrays.fill(table, 0);
        table[1] = 1;

        for (int i = 0; i < n; i++) {
            table[i+1] = table[i+1] + table[i];
            table[i+2] = table[i+2] + table[i];
        }

        return table[n];
    }

}
