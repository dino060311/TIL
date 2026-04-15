public class AssignmentIncDecOperator {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;

        a += 2; // a = 3
        b *= 3; // b = 6
        c %= 2; // c = 1
        System.out.println("a=" + a + ", b=" + b + ", c=" + c);

        int d = 5;
        a = d++; // a = 5, d = 6
        System.out.println("a=" + a + ", d=" + d);
        a = --d; // a = 5, d = 5
        System.out.println("a=" + a + ", d=" + d);
    }

}
