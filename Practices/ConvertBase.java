import java.util.*;

class ConvertBase {

    public static void convert(int number, int base) {
        if (number >= base) {
            convert(number/base, base);
        }
        System.out.print(number%base);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int base = sc.nextInt();

        convert(number, base);
    }
}
