/* Calculator는 부모 타입이니까, List<Calculator>에 자식 객체(MultiplyCa, DivideCalc)를 자유롭게 담을 수 있어요 */

import java.util.ArrayList;
import java.util.List;

class Calculator{
    int a, b; 
    Calculator(int a, int b){this.a = a; this.b = b;}
    void calculate() {
        System.out.println("결과값 없습니다");
    }
}

class MultiplyCa extends Calculator {
    MultiplyCa (int a, int b) {
        super(a,b);
    }
    @Override
    void calculate() {
        System.out.println("곱하기 결과 " + a*b);
    }
}


class DivideCalc extends Calculator {
    DivideCalc (int a, int b) {
        super(a,b);
    }
    @Override
    void calculate() {
        System.out.println("나누기 결과 " + a/b);
    }
}


public class PT {
    public static void main(String[] args) {
        List<Calculator> calcList = new ArrayList<>();

        calcList.add(new MultiplyCa(10000,20));
        calcList.add(new DivideCalc(10000,20));

        for (Calculator c : calcList) {
            c.calculate();
        }
    }
}

