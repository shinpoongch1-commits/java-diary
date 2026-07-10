/*class Storage<T> {
    private T value;

    void save(T value) {
        this.value = value;
    }

    T load() {
        return value;
    }
} */


    

/* public class GenericStudy {
    public static void main(String[] args) {
        // TODO 1: Storage<String> 객체 만들고 "hello" 저장 후 출력

        // TODO 2: Storage<Integer> 객체 만들고 42 저장 후 출력
    }
}
*/


class G<T>{
    private T value;
    void save(T value) {
        this.value = value;
    }
    T load() {
        return value;
    }
}

public class GenericStudy{
    public static void main(String[] args) {
        G<String> s = new G<>();
        s.save("hello");
        System.out.println(s.load());


        G<Integer> n = new G<>();
        n.save(12);
        System.out.println(n.load());

    }
}