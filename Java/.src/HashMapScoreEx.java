import java.util.*;

public class HashMapScoreEx {
    public static void main(String[] args) {
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();

        scoreMap.put("김은비", 97);
        scoreMap.put("하여린", 88);
        scoreMap.put("전아린", 98);
        scoreMap.put("이동건", 70);
        scoreMap.put("양승연", 99);

        System.out.println("HashMap의 요소 개수:" + scoreMap.size());

        Set<String> keys = scoreMap.keySet();
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            String name = it.next();
            int score = scoreMap.get(name);
            System.out.println(name + " : " + score);
        }
    }
}
