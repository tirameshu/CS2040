class NumberOfOnes {
    public static int calculate(int n) {
        if (n < 2) {
            return n;
        } else {
            if (n % 2 == 0) {
                return calculate(n/2);
            } else {
                return calculate(n/2) + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(NumberOfOnes.calculate(13));
        System.out.println(NumberOfOnes.calculate(2));
    }
}
