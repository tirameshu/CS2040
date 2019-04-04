/*
 * Name       : Wang Xinman 
 * Matric No. : A0180257E
 * Plab Acct. : -
 */
import java.util.*;

public class Transmission {
    private void run() {
        //implement your "main" method here
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int q = sc.nextInt();
        TreeSet<Long> sleeping = new TreeSet<>();
        sleeping.add(Long.valueOf("-1"));
        sleeping.add(n+1);

        for (int i = 0; i < q; i++) {
            String command = sc.next();
            switch (command) {
                case "WAKE":
                    sleeping.remove(sc.nextLong());
                    break;
                case "SLEEP":
                    sleeping.add(sc.nextLong());
                    break;
                case "TRANSMIT":
                    Long x = sc.nextLong();
                    Long y = sc.nextLong();
                    //Long f = sleeping.lower(x); //never null because of -1
                    Long c = sleeping.floor(y); //never null because of n+1
                    if (x <= c && c <= y) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Transmission newTransmission = new Transmission();
        newTransmission.run();
    }
}
