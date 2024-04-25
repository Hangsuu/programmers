package hello.javaLv2;

public class Java135807 {
    // 숫자 카드 나누기
    // courses/30/lessons/135807
    public int solution(int[] arrayA, int[] arrayB) {
        int maxDivision = Math.max(arrayA[0], arrayB[0]);
        int answer = 0;
        for(int i=2; i<=maxDivision; i++) {
            if((hasDivision(arrayA, i) && hasNoDivision(arrayB, i))
                    || (hasDivision(arrayB, i) && hasNoDivision(arrayA, i))) {
                answer = i;
            }
        }

        return answer;
    }

    private static boolean hasDivision(int[] checkArray, int division) {
        for(int i=0; i<checkArray.length; i++) {
            if(checkArray[i] % division != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasNoDivision(int[] checkArray, int division) {
        for(int i=0; i<checkArray.length; i++) {
            if(checkArray[i] % division == 0) {
                return false;
            }
        }
        return true;
    }
}
