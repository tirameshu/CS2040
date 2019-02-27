import java.util.*;

class Permutation {
    public static ArrayList<StringBuilder> permutate(String string) {
        if (string.length() < 1) {
            return string;
        } else {
            ArrayList<StringBuilder> lst = permutate(new StringBuilder(string).substring(1));
            return combine(string.charAt(0), lst);
        }
    }

    private static ArrayList<String> combine(char c, ArrayList<String> lst) {
        for (String string: lst) {
            for (int i = 0; i < string.length(); i++) {

    public static void main(String[] args) {
        String string = "word";
        System.out.println(permutate(string));
    }
