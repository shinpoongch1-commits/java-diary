class Calculator {
    int a, b;

    Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void calculate() {
        System.out.println("두 수를 더합니다: " + (a + b));
    }
}

class MultiplyCa extends Calculator {
    MultiplyCa (int a, int b) {
        
    }
    

    // TODO 1: 생성자 만들기 (super 사용해서 부모 생성자 호출)

    // TODO 2: calculate() 오버라이딩
    //         — super.calculate() 먼저 호출한 다음
    //         — 곱셈 결과를 계산해서 출력
}

public class MathSystem {
    public static void main(String[] args) {
        MultiplyCa m = new MultiplyCa(10, 5);
        m.calculate();
    }
}