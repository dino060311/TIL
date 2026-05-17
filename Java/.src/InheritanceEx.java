class Person {
    private int weight; // private 접근 지정. Student 클래스에서 접근 불가
    int age;
    protected int height;
    public String name;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class Student extends Person {
    public void set() {
        age = 1;
        name = "아기공룡";
        height = 40;
        // weight = 80; // 오류. 슈퍼 클래스의 private 멤버 접근 불가
        setWeight(80); // private 멤버 weight은 setWeight()으로 간접 접근
    }
}

public class InheritanceEx {
    public static void main(String[] args) {
        Student s = new Student();
        s.set();
    }
}
