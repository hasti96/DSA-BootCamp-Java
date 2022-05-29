package workAtTech.backtracking.medium;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(genParentheseList("", 0, 0, 3));
        
    }

    public static List<String> genParentheseList(String down, int open, int close, int val) {
        if(close == val) {
            List<String> temp = new ArrayList<>();
            temp.add(down);
            // System.out.println(down);
            return temp;
        }

        if(open == close) {
            down = down + "(";
            open++;
        }

        List<String> ans = new ArrayList<>();

        if(close < open) {
            if(open < val) {
                List<String> left = genParentheseList(down + "(", open + 1, close, val);
                ans.addAll(left);
            }

            if(close < val) {
                List<String> right = genParentheseList(down + ")", open, close + 1, val);    
                ans.addAll(right);
            }
        }

        return ans;
    }

    public static void genParenthese(String down, int open, int close, int val) {
        if(close == val) {
            System.out.println(down);
            return;
        }


        if(open == close) {
            down = down + "(";
            open++;
        }

        if(close < open) {
            if(open < val) {
                genParenthese(down + "(", open + 1, close, val);
            }

            if(close < val) {
                genParenthese(down + ")", open, close + 1, val);    
            }
        }
    }
}
