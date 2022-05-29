package workAtTech.backtracking.hard;

public class KthPermutation {
    public static void main(String[] args) {
        // getKthPermutation(n, k)
        System.out.println(getKthPermutation(4, 17));
    }

    public static String getKthPermutation(int n, int k) {
        StringBuilder input = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            input.append((char) ('0' + i));
        }

        StringBuilder ans = new StringBuilder();
        k = k - 1;
        int length = factorial(n);

        while (input.length() > 0) {
            length /= n;
            int position = k / length;
            k %= length;

            ans.append(input.charAt(position));
            input.deleteCharAt(position);
            n--;

        }

        return ans.toString();
    }

    public static int factorial(int input) {
        if (input == 1) {
            return 1;
        }

        return factorial(input - 1) * input;
    }
}
