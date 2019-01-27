class Main {
    public static void main(String[] args) {
        TutorialGroup T05 = new TutorialGroupImpl("T05");

        T05.addStudent("Alice");
        T05.addStudent("Betrice");
        System.out.println(T05.toString());

    }
}
