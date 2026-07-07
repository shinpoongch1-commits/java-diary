/*public class Study {
    public static void main(String[] args) {
        // 1. 변수와 데이터 타입
        String lesson = "Java 기초";
        int level = 1;

        System.out.println(lesson + " 레벨: " + level + " 시작합니다!");
    
        // 2. 제어문 (반복문)
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + "번째 반복 학습 중...");
        }

        // 3. 제어문 (조건문)
        if (level == 1) {
            System.out.println("기초 학습 완료입니다!");
        }
    }
}
*/

public class Study{
    public static void main(String[] args) {
        String lesson = "기초";
        int level = 1;
        int i = 0;

        System.out.println( "수준 :" + lesson + ", 단계:" + level);
       
        for (i=0 ; i<4; i++) {
            System.out.println("i:" + i);
        }

        if (level == 1) {
            System.out.println("단계 :"+ level);
        } else {
            System.out.println("수준급입니다");
        }
    }
} 