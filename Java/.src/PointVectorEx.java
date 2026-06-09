import java.util.Vector;

class MyPoint {
    private int x, y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class PointVectorEx {
    public static void main(String[] args) {
        Vector<MyPoint> v = new Vector<MyPoint>();

        v.add(new MyPoint(2, 3));
        v.add(new MyPoint(-5, 20));
        v.add(new MyPoint(30, -8));

        v.remove(1);

        for (int i = 0; i < v.size(); i++) {
            MyPoint p = v.get(i);
            System.out.println(p);
        }
    }
}