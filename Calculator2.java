class Calculator{
    int a, b;

    Calculator(int a, int b) {
        this.a = a;
        this.b = b;

        System.out.println ("Calculato생성자 생성");
            }
}

class MultiplyCa extends Calculator {
    MultiplyCa(int a, int b) {
       // super(a,b);
         System.out.println ("MultiplyCa 생성자 실행");
            super(a,b);
    }
    void multi(){
        System.out.println (a*b);
    }
}

public class Calculator2 {
    public static void main(String[] args){
        MultiplyCa m = new  MultiplyCa(20,10);
         m.multi();
    }
}

/*class Calculator {
    int a, b;
    
    calculate(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("생성사 실행");
    }
}


class MultiplyCa extends Calculator {
    MultiplyCa(int a, int b){
        super(a,b);
        System.out.println("multi 생성자실행");
    }
    void multi() {
        System.out.println(a*b);
    }
}


public class Calculator2 {
    public static void main(String[] args) {
        MultiplyCa m = new MultiplyCa(10,5);
        m.multi();
    }
}
*/

/*

class Calculator {
    int a, b, c = 0;

    void calculate() {
        System.out.println("두 수를 더합니다");
    }
}

class MultiplyCa extends Calculator {
    @Override
    void calculate() {
        super.calculate();          // 부모의 calculate() 먼저 실행
        c = a * b;
        System.out.println("곱셈 결과: " + c);
    }
}


class Calculator {
    int a, b;

    Calculator(int a, int b) {   // 부모 생성자
        this.a = a;
        this.b = b;
        System.out.println("Calculator 생성자 실행");
    }
}





class MultiplyCa extends Calculator {
    MultiplyCa(int a, int b) {
        super(a, b);              // 반드시 첫 줄에 위치해야 함
        System.out.println("MultiplyCa 생성자 실행");
    }

    void multi() {
        System.out.println(a * b);
    }
}*/