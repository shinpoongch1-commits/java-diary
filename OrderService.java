/*1: 뼈대 설계 (Interface)
먼저 우리 쇼핑몰의 규칙(약속)을 정합니다. (지불과 환불)

2단계: 구현체 만들기 (클래스)
이제 NaverPay라는 클래스를 만들 텐데, 이 녀석은 Payable과 Refundable을 동시에 수행할 수 있게 만들어 봅시다.

3단계: 관리자(OrderService) 만들기 (핵심!)
이 클래스는 특정 결제 수단에 의존하지 않습니다. 오직 '역할'만 수행합니다.

실습 과제
이제 질문자님이 직접 main 메서드에서 다음을 구현해 보세요.
NaverPay 객체를 생성한다.
OrderService 객체를 생성한다.
OrderService를 통해 payOrder와 cancelOrder를 호출해 본다.

*4. Toss 결제금액 */


interface Payable{
    void pay();
}

interface Refundable{
    void refund();
}


class NaverPay implements Payable, Refundable { // 'implements' 키워드 사용
    int amount;
    NaverPay(int amount) { this.amount = amount; }

    @Override
    public void pay() { // 인터페이스 구현 시 접근제어자는 public 필수!
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
        System.out.println("Toss 결제: " + amount + "원 ");        
    }
    public void refund() { // 인터페이스 구현 시 접근제어자는 public 필수!
        System.out.println("Toss 환불: " + amount + "원");
}
}
public class OrderService{
    public static void main(String[] args){

        Payable[] payments = {new NaverPay(10000), new Toss(2000)};

        for (Payable p : payments) {
            p.pay();
        }
        /*Payable payOrder  = mypay;
        Refundable  cancelOrder =  mypay;

        payOrder.pay();
        cancelOrder.refund(); */
        
    }
}