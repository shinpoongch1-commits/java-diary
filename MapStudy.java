/*  Map은 인터페이스, HashMap은 구현체
javaMap<String, Integer> price = new HashMap<>();
↑                              ↑
 인터페이스 (설계도/규칙)      실제 구현체 (진짜 동작하는 것) */

//import java.util.HashMap;
//import java.util.Map;

import java.util.HashMap;
import java.util.Map;


public class MapStudy{
    public static void main(String[] args) {
        Map<String, Integer> cost = new HashMap<>();
        cost.put ("apple", 100);
        cost.put ("orange", 300);
        cost.put ("banana", 500);
        cost.put ("grapes", 700);

        System.out.println(cost.get("apple"));

        cost.put("apple",800);
        System.out.println(cost.get("apple"));

        System.out.println(cost.containsKey("banaana"));
        cost.remove("grapes");
        System.out.println(cost.size());

    } 
}

/* 
public class MapStudy {
    public static void main(String[] args) {
        Map<String, Integer> price = new HashMap<>();

        price.put("사과", 1000);     // 저장 (key, value)
        price.put("바나나", 500);
        price.put("포도", 3000);

        System.out.println(price.get("사과"));   // 값 꺼내기 → 1000

        price.put("사과", 1200);     // 같은 key로 put하면 값이 덮어씌워짐
        System.out.println(price.get("사과"));   // → 1200

        System.out.println(price.containsKey("바나나"));  // key 존재 확인 → true
        price.remove("포도");                              // 삭제

        System.out.println(price.size());   // 남은 개수 → 2
    }
} */