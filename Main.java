class Calculator {
    int a, b;
    Calculator(int a, int b)
     { this.a = a; this.b = b; 
     System.out.println("[단계 1-1] 부모 생성자: a=" + a + ", b=" + b + " 저장 완료");
     }
    
    void calculate() {
        System.out.println("부모 계산기");
    }
}


class MultiplyCalc extends Calculator {
    MultiplyCalc(int a, int b) { 
        super(a, b);
        System.out.println("[단계 1-2] 자식 생성자 실행 완료"); }

    //@Override // 안전장치!
    void calculate() { 
        System.out.println("곱셈 결과: " + (a * b));
    }
}

public class Main {
    public static void main(String[] args) {
        // 부모 타입 변수(c)에 자식 객체(MultiplyCalc)를 대입함 (다형성)
        Calculator c = new MultiplyCalc(20, 10);
        
        // 자식 클래스에서 오버라이딩된 calculate()가 실행됨
        c.calculate(); 
    }
}