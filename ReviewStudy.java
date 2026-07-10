import java.util.ArrayList;


interface Payable{
    void pay();
}

interface Refundable{
    void refund();
}

class Creditcard implements Payable, Refundable {
    int amount;
    Creditcard (int amount) {  this.amount = amount;}
    @Override
    public void  pay() {
        System.out.println("신용카드 결제금액 : " + amount +"원 입니다");
        }
    
    public void  refund() {
        System.out.println("신용카드 환불금액 : " + amount +"원 입니다");
        }
}


class Cash implements Payable, Refundable {
    int amount;
    Cash (int amount) { this.amount = amount;}
    @Override
    public void  pay() {
        System.out.println("현금 결제금액 : " + amount +"원 입니다");
        }
    
    public void  refund() {
        System.out.println("현금 환불금액 : " + amount +"원 입니다");
        }
}

public class ReviewStudy {
    public static void main(String[] agrs) {
        Creditcard c1 = new Creditcard(1000);
        Cash c2 = new Cash(2000);

        Creditcard r1 = new Creditcard(300);
        Cash r2 = new Cash(100);

        c1.pay();
        c2.pay();
        r1.refund();
        r2.refund();
    }
}