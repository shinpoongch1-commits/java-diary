


// 부모 클래스

class Animal {
    String name ;
    void eat() {
        System.out.println(name + "가 먹습니다");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("whooo");
    }
}

public class InheritanceStudy{
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.name = "Dori";
        myDog.eat();
        myDog.bark();
    }
}

/*
// 자식 클래스 (Animal을 상속받음)
class Dog extends Animal {
    void bark() {
        System.out.println("멍멍!");
    }
}

public class InheritanceStudy {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.name = "바둑이"; // 부모에게 물려받은 필드 사용
        myDog.eat();          // 부모에게 물려받은 메서드 사용
        myDog.bark();         // 자식만의 메서드 사용
    }
} */