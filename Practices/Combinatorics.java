import java.util.Scanner;

class Combinatorics {
    public static int choose (int n, int k) {
        if (n < k || n <= 0) {
            return 0;
        } else if (n == k || k == 0) {
            return 1;
        } else {
            return choose(n-1, k-1) + choose(n-1, k);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(choose(n, k));
    }
}
