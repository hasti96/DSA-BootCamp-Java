package recursion.freecodecamp.dynamicprogramming.tabulation;

import java.util.ArrayList;
import java.util.List;

public class GridTraveller {
    
    public static void main(String[] args) {
        gridTraveller(3, 3);
        gridTraveller(4, 4);
        gridTraveller(18, 18);
    }

    public static int gridTraveller(int row, int col) {
        List<Integer> rowList = new ArrayList<>();
        for (int i = 0; i <= col; i++) {
            rowList.add(0);
        }

        List<List<Integer>> grid = new ArrayList<>();

        for (int i = 0; i <= row; i++) {
            grid.add(new ArrayList<>(rowList));
        }

        grid.get(1).set(1, 1);

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                Integer currentElement = grid.get(i).get(j);

                if(j+1 <= col) {
                    Integer right = grid.get(i).get(j+1);
                    grid.get(i).set(j+1, currentElement + right);
                }

                if(i+1 <= row) {
                    Integer down = grid.get(i+1).get(j);
                    grid.get(i+1).set(j, currentElement + down);
                }
            }
        }

        System.out.println(grid);
        return 0;
    }
}
