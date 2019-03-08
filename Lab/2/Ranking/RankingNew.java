import java.util.*;

public class RankingNew {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] namelist = new Person[n];
        long[] sortedScores = new long[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            long score = sc.nextLong();
            Person p = new Person(name, score);
            namelist[i] = p;
            sortedScores[i] = score;
        }

        Arrays.sort(sortedScores); //scores in asc order

        for (Person person: namelist) {
            for (int s = (n-1); s >=0; s--) {
                if (person.score == sortedScores[s]) {
                    sb.append(person.toString() + (n-s) + "\n");
                    break;
                }
            }
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }

    public static void main(String[] args) {
        RankingNew newRanking = new RankingNew();
        newRanking.run();
    }

    class Person implements Comparable<Person> {
        String name;
        long score;

        public Person(String name, long score) {
            this.name = name;
            this.score = score;
        }

        public int compareTo(Person p) {
            if (this.score > p.score) {
                return -1;
            } else if (this.score == p.score) {
                return 0;
            } else {
                return 1;
            }
        }

        public String toString() {
            return this.name + " ";
        }
    }
}
