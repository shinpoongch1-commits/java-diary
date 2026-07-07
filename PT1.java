public class PT1 {
    public static void main(String[] args) {
        int i = 7;
        String number = "판별기";
        System.out.println("지금부터" + number +  i + "의 숫자를 판별합니다");

        if (i<=4) {
            System.out.println("여기는" + i + "이하의 숫자입니다");
        } else {
            System.out.println("여기는" + i + "이상의 숫자입니다");
        }

        for (i=1;i<4;i++) {
              System.out.println("현재" + i + "번째의 수행중");
        }

        showResult();
    }
public static void showResult() {
        System.out.println("--- 게임이 종료되었습니다 ---");
}
}







/*
public class Practice {
    public static void main(String[] args) {
        // 1. 변수 선언: 데이터 저장
        String gameName = "숫자 판별기";
        int myNumber = 7;

        System.out.println("--- " + gameName + " 시작 ---");

        // 2. 조건문: 상황에 따른 판단
        if (myNumber > 5) {
            System.out.println("입력한 숫자 " + myNumber + "은(는) 5보다 큽니다.");
        } else {
            System.out.println("입력한 숫자 " + myNumber + "은(는) 5 이하입니다.");
        }

        // 3. 반복문: 같은 작업 반복
        System.out.println("반복 카운트 시작:");
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + "번째 반복 중...");
        }

        // 4. 메서드 호출: 기능 사용
        showResult();
    }

    // 5. 메서드: 반복되는 기능을 묶어서 정의
    public static void showResult() {
        System.out.println("--- 게임이 종료되었습니다 ---");
    }
}

*/