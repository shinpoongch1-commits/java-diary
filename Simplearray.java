import java.util.ArrayList;

public class Simplearray{
    public static void main(String[] agrs){
        ArrayList<String> names = new ArrayList();

names.add("king");
names.add("king1");
names.add("king2");
names.add("king3");
names.add("king4");
names.add("king5");

/*for (String name : names) {
    // 변수명을 하나씩 꺼내서 씀
    System.out.println(name + "welcome!");
}*/

for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i) +" " + i );
}

System.out.println(names.get(3));
System.out.println(names.size());


names.remove("king5");
System.out.println(names);

names.remove(0);
System.out.println(names);


    }
}
