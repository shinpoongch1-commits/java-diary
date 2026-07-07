/* 설계도
class MyObject {
    String name;
    
    MyObject(String name) {
        this.name = name;
    }
}

// 실행부
public class ObjectStudy {
    public static void main(String[] args) {
        // 객체 생성
        MyObject obj1 = new MyObject("첫 번째 객체");
        MyObject obj2 = new MyObject("두 번째 객체");
        
        System.out.println(obj1.name);
        System.out.println(obj2.name);
    }
} */

/*public class ObjectStudy{
    public static void main(String[] args) {
        String obj1 ="첫번째 객체";
        String obj2 ="두번째 객체";

        System.out.println (obj1 + "와 " + obj2);
    }
} */


class MyObject{ 
    String name ;

    MyObject(String name) {
        this.name = name;
    }
}

public class ObjectStudy {
    public static void main(String[] args) {

        MyObject obj1 = new MyObject("첫번째 OB");
        MyObject obj2 = new MyObject ("두번째 OB");
        MyObject obj3 = new MyObject ("세번째 ob"); 

              
        System.out.println(obj1.name);
        System.out.println(obj2.name);
        System.out.println(obj3.name);
    }
}
*/

class MyObject {
    String name;

    MyObject(String name) {
        this.name = name;
    }

    // 기능 추가: 객체가 스스로 자기 이름을 말하게 합니다!
    void introduce() {
        System.out.println("안녕하세요, 저는 " + this.name + "입니다.");
    }
}

public class ObjectStudy {
    public static void main(String[] args) {
        MyObject obj1 = new MyObject("첫번째 OB");
        
        // 이제 시스템이 출력하는 게 아니라, 객체가 스스로 말하게 합니다.
        obj1.introduce(); 
    }
}

*/


class MyObject {
    String name; 
    MyObject(String name) {
        this.name = name;
    }
    void introduce() {
        System.out.println ("저는" + this.name);
    }
}

public class ObjectStudy {
    public static void main(String[] args) {
        MyObject obj1 = new MyObject("my first ob");
        obj1.introduce();

    }
}


public class ObjectStudy{
    public static void main (String[] args) {
        String obj1  ="my first ob";
        System.out.println("저는"+ obj1 +"입니다");

    }
}

