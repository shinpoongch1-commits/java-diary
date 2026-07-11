/* 국어   영어   수학
학생1    90    85    88
학생2    70    95    80
학생3    100   60    75


int[][] scores = {
    {90, 85, 88},    // 학생1
    {70, 95, 80},    // 학생2
    {100, 60, 75}    // 학생3
};

System.out.println(scores[0][0]);   // 90 (학생1의 국어)
System.out.println(scores[1][2]);   // 80 (학생2의 수학)
System.out.println(scores[2][1]);   // 60 (학생3의 영어)


for (int i = 0; i < scores.length; i++) {          // 바깥: 학생(행) 순회
    for (int j = 0; j < scores[i].length; j++) {    // 안쪽: 과목(열) 순회
        // scores[i][j] 로 값 꺼내서 출력
    }
} */


public class TwoArray {
    public static void main(String[] args) {
        int[][] scores = {
            {90, 85, 88},
            {70, 95, 80},
            {100, 60, 75}
        };
        int i, j;

        for(i=0 ; i< scores.length ; i++ ){
            for (j=0 ; j< scores[i].length ; j++) {
                switch (j) {
                    case 0:
                    System.out.println("학생[" +i+ "] 국어점수 :" + scores[i][j] );
                    break;
                    case 1:
                    System.out.println("학생[" +i + "] 수학점수 :" + scores[i][j] );
                    break;
                    case 2:
                    System.out.println("학생[" +i + "] 영어점수 :" + scores[i][j] );
                    break;}
            }
        }
    }
}
