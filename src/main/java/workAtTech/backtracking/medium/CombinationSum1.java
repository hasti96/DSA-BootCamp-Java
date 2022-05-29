package workAtTech.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CombinationSum1 {
    public static void main(String[] args) {
        // System.out.println(combSum1(Arrays.asList(2, 3, 6, 7), 7));
        // System.out.println(combSum1Memo(Arrays.asList(2, 3, 6, 7), 7, new
        // HashMap<>()));
        System.out.println(combSum1List(new ArrayList<>(), Arrays.asList(1, 2), 4));

    }

    public static List<List<Integer>> combSum1List(List<Integer> down, List<Integer> input, int target) {
        if (target == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(down));
            return ans;
        }

        if (target < 0) {
            return null;
        }

        List<List<Integer>> retList = new ArrayList<>();

        for (Integer num : input) {
            List<Integer> temp = new ArrayList<>(down);
            if (!temp.isEmpty() && temp.get(temp.size() - 1) > num)
                continue;
            temp.add(num);

            List<List<Integer>> list = combSum1List(temp, input, target - num);
            if (list != null) {
                retList.addAll(list);
            }

            temp.remove(temp.size() - 1);
        }

        return retList;
    }

    public static void combSum1(List<Integer> down, List<Integer> input, int target) {
        if (target == 0) {
            System.out.println(down);
            return;
        }

        if (target < 0) {
            return;
        }

        for (Integer num : input) {
            List<Integer> temp = new ArrayList<>(down);
            if (!temp.isEmpty() && temp.get(temp.size() - 1) > num)
                continue;
            temp.add(num);
            combSum1(temp, input, target - num);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> combSum1(List<Integer> input, int target) {
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;

        List<List<Integer>> ans = null;

        for (Integer val : input) {
            if (val <= target) {
                List<List<Integer>> retList = combSum1(input, target - val);

                if (retList != null) {
                    if (ans == null)
                        ans = new ArrayList<>();

                    if (retList.isEmpty()) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(val);
                        ans.add(temp);
                        return ans;
                    } else {
                        for (List<Integer> e : retList) {
                            List<Integer> temp = new ArrayList<>();
                            if (val <= e.get(0)) {
                                temp.add(val);
                                temp.addAll(e);
                                ans.add(temp);
                            }
                        }
                    }
                }
            }
        }

        return ans;

    }

    public static List<List<Integer>> combSum1Memo(List<Integer> input, int target,
            Map<Integer, List<List<Integer>>> cache) {
        if (cache.containsKey(target))
            return cache.get(target);

        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;

        List<List<Integer>> ans = null;

        for (Integer val : input) {
            if (val <= target) {
                List<List<Integer>> retList = combSum1Memo(input, target - val, cache);

                if (retList != null) {
                    if (ans == null)
                        ans = new ArrayList<>();

                    if (retList.isEmpty()) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(val);
                        ans.add(temp);

                        cache.put(target, ans);
                        return ans;
                    } else {
                        for (List<Integer> e : retList) {
                            List<Integer> temp = new ArrayList<>();
                            if (val <= e.get(0)) {
                                temp.add(val);
                                temp.addAll(e);
                                ans.add(temp);
                            }
                        }
                    }
                }
            }
        }

        cache.put(target, ans);
        return ans;

    }

}
