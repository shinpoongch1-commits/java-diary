// 1. 추상 클래스 (미완성 설계도)
abstract class Calculator {
    int a, b;
    Calculator(int a, int b) { this.a = a; this.b = b; }
    
    // 이 메서드는 자식이 반드시 구현해야 함 (내용 없음)
    abstract void calculate( );
}

// 2. 자식 클래스 (부모의 숙제를 완성)
class MultiplyCalc extends Calculator {
    MultiplyCalc(int a, int b) { super(a, b); }

    @Override
   /* void calculate(){ 
        System.out.println("곱셈 결과: " + (a * b));
    }*/
}

// 3. 메인 로직
public class AbstractStudy {
    public static void main(String[] args) {
        // Calculator c = new Calculator(20, 10); // 에러 발생! (추상 클래스는 객체 생성 불가)
        
        Calculator c = new MultiplyCalc(20, 10); // 자식은 가능!
        c.calculate();
    }
}