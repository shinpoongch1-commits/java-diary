/*결제 시스템에 "결제 일시를 출력하는 기능"을 모든 결제 수단에 공통으로 넣고 싶다고 해보죠.
이제 NaverPay나 Toss는 printLog()를 새로 만들지 않아도, Payable 인터페이스를 구현했다는 이유만으로 printLog() 기능을 즉시 사용할 수 있습니다.
// 인터페이스에 추가
interface Payable {
    void pay();
    
    default void printLog() {
        System.out.println("로그: 결제 수단이 호출되었습니다.");
    }
}

// 클래스들은 수정할 필요가 없음!
// 하지만 원한다면 오버라이딩(재정의)도 가능함.

public class OrderService {
    public static void main(String[] args) {
        Payable p = new NaverPay(10000);
        p.pay();
        p.printLog(); // 인터페이스의 default 메서드를 호출!
    }
}
}*/


interface Payable{
    void pay();
    
    default void printLog() {
        System.out.println("로그: 결제 수단이 호출되었습니다.");
}
}

interface Refundable{
    void refund();
}



class NaverPay implements Payable, Refundable { // 'implements' 키워드 사용
    int amount;
    NaverPay(int amount) { this.amount = amount; }

    @Override
    public void pay() { // 인터페이스 구현 시 접근제어자는 public 필수!
    if (amount <= 0) {
        throw new IllegalArgumentException("NaverPay 잔액이 부족합니다!");}
        System.out.println("NaverPay 결제: " + amount + "원 ");        
    }

    public void refund() { // 인터페이스 구현 시 접근제어자는 public 필수!
        System.out.println("NaverPay 환불: " + amount + "원");
}
}

class Toss implements Payable, Refundable { // 'implements' 키워드 사용
    int amount;
    Toss(int amount) { this.amount = amount; }

    @Override
    public void pay() { // 인터페이스 구현 시 접근제어자는 public 필수!
      if (amount<=0){throw new IllegalArgumentException("tOSS 결제금액을 확인하십시오");}
        System.out.println("Toss 결제: " + amount + "원 ");        
    }
    public void refund() { // 인터페이스 구현 시 접근제어자는 public 필수!
        System.out.println("Toss 환불: " + amount + "원");
}
}

public class DefaultStudy{
    public static void main(String[] args){

        Payable[] payments = {new NaverPay(0), new Toss(20)};

        for (Payable p : payments) {
            try { p.pay();
                  p.printLog(); }// 인터페이스의 default 메서드를 호출!}
            catch (IllegalArgumentException e) {
                System.out.println("오류발생 :" + e.getMessage());
               } 
            
        
        
    }
}

}