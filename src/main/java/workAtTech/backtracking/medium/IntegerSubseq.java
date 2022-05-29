package workAtTech.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class IntegerSubseq {
    public static void main(String[] args) {
        System.out.println(subseqIterative(Arrays.asList(4, 4, 4, 1, 4)));
    }

    public static List<List<Integer>> subseqIterative(List<Integer> input) {
        input.sort(Comparator.naturalOrder());
        List<List<Integer>> retVal = new ArrayList<>();
        retVal.add(new ArrayList<>());

        int start = 0;
        int end = retVal.size() - 1;
        Integer previousValue = -1;

        for (Integer value : input) {
            List<List<Integer>> temp = new ArrayList<>();

            if (previousValue != value) {
                retVal.forEach(e -> temp.add(new ArrayList<>(e)));
                
            } else {

                for(int i=start; i < retVal.size(); i++) {
                    temp.add(new ArrayList(retVal.get(i)));
                }
            }

            for (List<Integer> list : temp) {
                list.add(value);
            }
            
            retVal.addAll(temp);

            previousValue = value;
            start = end + 1;
            end = retVal.size() - 1;
        }

        return retVal;
    }
}
