/*부모 클래스(Payment):

abstract class로 만드세요.
공통으로 필요한 필드: amount (결제 금액)
생성자에서 amount를 받아 초기화하세요.
추상 메서드: abstract void pay(); (결제 처리 기능을 강제)

자식 클래스 2개 이상 만들기:
CreditCard 클래스: pay()를 오버라이딩해서 "신용카드로 [amount]원을 결제합니다." 출력.
KakaoPay 클래스: pay()를 오버라이딩해서 "카카오페이로 [amount]원을 결제합니다." 출력.


메인 클래스(PaymentApp):
Payment 타입의 배열을 만들어서 CreditCard 객체와 KakaoPay 객체를 담으세요.

[힌트]
for문을 돌면서 각 객체의 pay()를 실행하세요.
for (Payment p : payments) 문법을 사용하면 아주 깔끔하게 출력할 수 있습니다.
@Override 어노테이션은 꼭 붙여보세요!

abstract를 빼먹지 않도록 주의하세요.*/


abstract class Payment{
    int amount;
    Payment(int amount) {
        this.amount = amount;
       
    }
    abstract void pay();
}

class CreditCard extends Payment{
    CreditCard(int amount){super (amount);    }
    @Override
    void pay(){ 
        System.out.println("신용카드로 "+amount+"원을 결제합니다");
    }
}

class KakaoPay extends Payment{
    KakaoPay(int amount){super (amount);    }
    @Override
    void pay(){ 
        System.out.println("카카오페이로" + amount+ "원을 결제합니다.");
    }
}


public class PaymentPT{
    public static void main(String[] args) {
        Payment c = new CreditCard (10000);
        Payment k = new KakaoPay (20000);

        c.pay();
        k.pay();

    }
}
