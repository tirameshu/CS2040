import java.util.*;

class Sort {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("a");
        lst.add("b");
        lst.add("g");
        lst.add("d");
        lst.add("o");

        lst.sort(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        for (String s: lst) {
            System.out.println(s);
        }

    }
}
