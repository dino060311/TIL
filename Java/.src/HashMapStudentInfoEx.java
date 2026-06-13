import java.util.*;

class StudentInfo {
    private int id;
    private String tel;
    public StudentInfo(int id, String tel) { this.id = id; this.tel = tel; }
    public int getId() { return id; }
    public String getTel() { return tel; }
}

public class HashMapStudentInfoEx {
    public static void main(String[] args) {
        HashMap<String, StudentInfo> map = new HashMap<String, StudentInfo>();
        map.put("황기태", new StudentInfo(1, "010-111-1111"));
        map.put("이재문", new StudentInfo(2, "010-222-2222"));
        map.put("정인환", new StudentInfo(3, "010-333-3333"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("검색할 이름? ");
            String name = scanner.nextLine();
            if (name.equals("exit"))
                break;
            StudentInfo student = map.get(name);
            if (student == null)
                System.out.println(name + "은 없는 사람입니다.");
            else
                System.out.println("id: " + student.getId() + ", 전화: " + student.getTel());
        }
        scanner.close();
    }
}