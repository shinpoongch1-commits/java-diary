import java.util.ArrayList;


interface Payable {
    void pay();
    default void printLog() {
        System.out.println("로그: 결제 수단이 호출되었습니다.");
}
}

interface Refundable{
    void refund();
}


class NaverPay implements Payable, Refundable{
    int amount;
    NaverPay(int amount) { this.amount = amount;}
    @Override
    public void pay() {
        System.out.println("Naverpay 결제" + amount + "원 입니다");
    } 

    public void refund() {
        System.out.println("Naverpay 환불" + amount + "원 입니다");
    } 
}

class Toss implements Payable, Refundable{
    int amount;
    Toss(int amount) { this.amount = amount;}
    @Override
    public void pay() {
        System.out.println("Tosss 결제" + amount + "원 입니다");
    } 

    public void refund() {
        System.out.println("Toss 환불" + amount + "원 입니다");
    } 
}

public class ArrayStudy {
    public static void main(String[] args){
        ArrayList<Payable> payments = new ArrayList<>();

        // 3. add()를 사용해서 자유롭게 추가
        payments.add(new NaverPay(0));
        payments.add(new Toss(2000));
        payments.add(new NaverPay(5000));

        for (Payable p : payments) {
            try { p.pay();
                  p.printLog(); }// 인터페이스의 default 메서드를 호출!}
            catch (IllegalArgumentException e) {
                System.out.println("오류발생 :" + e.getMessage());
               }  
      }
    }
}
