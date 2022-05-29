package workAtTech.backtracking.medium;

import java.util.*;

@SuppressWarnings("all")
public class TugOfWar {
    public static void main(String[] args) {

        List<Integer> input1 = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(getSubSetMinDif(new ArrayList<>(), new ArrayList<>(), input1, (input1.size() + 1) / 2));

    }

    private static int getSubSetMinDif(List<Integer> s1, List<Integer> s2, List<Integer> input, int size) {

        if (input.isEmpty()) {
            int sum1 = s1.stream().reduce(0, Integer::sum);
            int sum2 = s2.stream().reduce(0, Integer::sum);
            int ans = sum1 - sum2;
            // System.out.println("s1 : " + s1 + " \t s2 : " + s2 + " \t diff : " + ans);
            return ans < 0 ? ans * -1 : ans;
        }

        int min = 999; // constraint given in question

        List<Integer> temp1 = new ArrayList<>(s1);
        temp1.add(input.get(0));

        List<Integer> temp2 = new ArrayList<>(s2);
        temp2.add(input.get(0));

        if (temp1.size() <= size) {
            min = Math.min(min, getSubSetMinDif(temp1, s2, input.subList(1, input.size()), size));
        }

        if (temp2.size() <= size) {
            min = Math.min(min, getSubSetMinDif(s1, temp2, input.subList(1, input.size()), size));
        }

        return min;
    }

    private static List<List<Integer>> getSubSetList(List<Integer> p, List<Integer> input) {
        if (input.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(p));
            return ans;
        }

        List<List<Integer>> retVal = new ArrayList<>();

        List<Integer> temp = new ArrayList<>(p);
        retVal.addAll(getSubSetList(temp, input.subList(1, input.size())));
        temp.add(input.get(0));
        retVal.addAll(getSubSetList(temp, input.subList(1, input.size())));

        return retVal;
    }

}
