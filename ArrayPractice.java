// TODO 1: for문으로 scores 배열의 모든 값을 출력하기

        // TODO 2: scores 배열 값들의 총합을 구해서 출력하기 (sum 변수 사용)

        // TODO 3: scores.length를 출력해서 배열 크기 확인하기


public class ArrayPractice {
    public static void main(String[] args) {
        int[] scores = {85, 90, 78, 92, 88};
        int total = 0;
        int i = 0;

        for (i=0; i<scores.length; i++){
            System.out.println("배열 값["+i+"]의 점수 : " + scores[i] );
            total = total + scores[i] ;
                    }
        System.out.println("총 합계 : " + total );
        System.out.println("배열의 개수 : " + scores.length);
        
    }
}