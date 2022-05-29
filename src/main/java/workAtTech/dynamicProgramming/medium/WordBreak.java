package workAtTech.dynamicProgramming.medium;

import java.util.Map;

public class WordBreak {
    public static void main(String[] args) {
        String[] wordBank = {"work", "problem", "at", "tech"};
        System.out.println(wordBreak("workattech", wordBank));
    }

    public static boolean wordBreak(String s, String[] w) {
        if(s.isEmpty()) return true;

        for(int i=0; i < w.length; i++) {
            if(s.indexOf(w[i]) == 0) {
                if(wordBreak(s.substring(w[i].length()), w)) {
                    return true;
                }
            }
        }

        return false;
	}

    public static boolean wordBreak(String s, String[] w, Map<String, Boolean> cache) {
        if(cache.containsKey(s)) return cache.get(s).booleanValue();
        if(s.isEmpty()) return true;

        for(int i=0; i < w.length; i++) {
            if(s.indexOf(w[i]) == 0) {
                if(wordBreak(s.substring(w[i].length()), w)) {
                    cache.put(s, true);
                    return cache.get(s);
                }
            }
        }

        cache.put(s, false);
        return cache.get(s);
	}

    
}
