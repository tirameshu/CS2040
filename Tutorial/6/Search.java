import java.util.*;

class Search {
    public static void main(String[] args) {

        String mainStr = "thequickbrownfoxjumpsoverthelazydog";
        String pattern = "the";
        HashMap<String, Integer> map = new HashMap<>();

        int k = pattern.length();
        for (int i = 0; i < mainStr.length() - k; i++) {
            String sub = mainStr.substring(i, i+k);
            if (map.containsKey(sub)) {
                int val = map.get(sub);
                map.put(sub, val+1);
            } else {
                map.put(sub, 1);
            }
        }

        System.out.println(map.get(pattern));
    }
}
