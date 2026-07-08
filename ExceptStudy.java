/*orderService에 + Exception Error msg 출력'*/


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

public class ExceptStudy{
    public static void main(String[] args){

        Payable[] payments = {new NaverPay(0), new Toss(0)};

        for (Payable p : payments) {
            try { p.pay();}
               catch (IllegalArgumentException e) {
                System.out.println("오류발생 :" + e.getMessage());
               } 
            
        }
        
    }
}

/*
public void pay() {
    if (amount <= 0) {
        throw new IllegalArgumentException("결제 금액은 0보다 커야 합니다!");
    }
    System.out.println("결제 진행: " + amount + "원");


    try {
                p.pay();
            } catch (Exception e) {
                System.out.println("실패: " + e.getMessage());
            }
}*/