public class ForeachEx {
    enum Week {
        월, 화, 수, 목, 금, 토, 일
    }

    public static void main(String[] args) {
        int[] n = { 3, 4, 5, 6, 7 };
        String names[] = { "사과", "배", "복숭아", "파인애플", "딸기", "샤인머스켓" };

        int sum = 0;
        for (int k : n) {
            System.out.print(k + " ");
            sum += k;
        }
        System.out.println("합은 " + sum);

        for (String s : names)
            System.out.print(s + " ");
        System.out.println();

        for (Week day : Week.values())
            System.out.print(day + "요일 ");
        System.out.println();

    }
}
