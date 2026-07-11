/*  Main에서  TODO 1: Counter 객체 3개 만들기
        TODO 2: 각각 show() 호출
        TODO 3: Counter.total 출력
    } */

class Counter {
    static int total = 0;
    int id;

    Counter() {
        total++;
        this.id = total;
    }

    void show() {
        System.out.println("나는 " + id + "번째 객체입니다");
    }
}

public class StaticStudy {
    public static void main(String[] args) {
        
        Counter a = new Counter();
        Counter b = new Counter();
        Counter c = new Counter();

        a.show();
        b.show();
        c.show();

        System.out.println("최종값은 " + Counter.total + "입니다.");
    }
}