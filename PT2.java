/*[요구사항]

1. 부모 클래스(Calculator):
int a, int b라는 필드를 가집니다. (계산할 숫자 두 개)
void calculate() 메서드를 가집니다. (기본적으로 "두 수를 더합니다: " 라고 출력)
2. 자식 클래스(MultiplyCalc, DivideCalc):
calculator를 상속받습니다.
calculate() 메서드를 오버라이딩하여 각각 곱하기 결과와 나누기 결과를 출력하도록 만드세요.

3. 실행 클래스(MathSystem):
MultiplyCalc 객체와 DivideCalc 객체를 생성합니다.
두 객체에 각각 숫자를 넣어주고, calculate()를 호출하여 연산 결과를 확인하세요.*/





/*

class Calculator{
    int a = 0;
    int b = 0;
    int c = 0;
    void calculate() {
        System.out.println("두 수를 더합니다");
    }
}


class MultiplyCa extends Calculator{
    void calculate() {
        c = a * b;
        System.out.println(c);
    }
}

class  DivideCalc extends Calculator{
    void calculate( ) {
        c = a / b;
        System.out.println(c);
    }
}
    
public class PT2{
    public static void main(String[] args) {
        MultiplyCa mymulti = new MultiplyCa();
        DivideCalc mydivide = new DivideCalc();

        mymulti.a = 10;
        mymulti.b = 5; 
        mymulti.calculate();

        mydivide.a = 10;
        mydivide.b = 5; 
        mydivide.calculate();
    
    }
} */



class Calculator {
    int a, b;
    void calculate() {
        System.out.println("기본 연산입니다.");
    }
}

class MultiplyCalc extends Calculator {
    @Override // 부모의 메서드를 재정의함
    void calculate() {
        System.out.println("곱셈 결과: " + (a * b));
    }
}

class DivideCalc extends Calculator {
    @Override // 부모의 메서드를 재정의함
    void calculate() {
        System.out.println("나눗셈 결과: " + (a / b));
    }
}
    
public class PT2 {
    public static void main(String[] args) {
        MultiplyCalc mymulti = new MultiplyCalc();
        DivideCalc mydivide = new DivideCalc();

        mymulti.a = 10; mymulti.b = 5;
        mymulti.calculate(); // 이제 다 같은 이름으로 호출 가능!

        mydivide.a = 10; mydivide.b = 5;
        mydivide.calculate(); 
    }
}