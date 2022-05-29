package workAtTech.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

    public static void main(String[] args) {
        System.out.println(restoreIp("8888"));
        System.out.println(restoreIp("25525511135"));
        System.out.println(restoreIp("0000"));
        System.out.println(restoreIp("002500"));        
    }

    public static List<String> restoreIp(String input) {
        List<String> result = new ArrayList<>();

        for(int i = 1; i < 4 && i < input.length(); i++) {
            String first = input.substring(0, i);
            
            if(isValidPart(first)) {
                
                for(int j = 1; i + j < input.length() && j < 4; ++j) {
                    String second = input.substring(i, i + j);
                    
                    if(isValidPart(second)) {
                        for(int k = 1; i+j+k < input.length() && k < 4; ++k) {
                            String third = input.substring(i+j, i+j+k);
                            String fourth = input.substring(i+j+k);

                            if(isValidPart(third) && isValidPart(fourth)) {
                                result.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    private static boolean isValidPart(String input) {
        if(input.isEmpty()) return false;
        if(input.length() > 3) return false;
        if(input.startsWith("0") && input.length() > 1) return false;

        int intVal = Integer.parseInt(input);

        return intVal <= 255 && intVal >= 0;
    }
}
