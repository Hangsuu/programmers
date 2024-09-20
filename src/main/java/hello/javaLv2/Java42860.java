package hello.javaLv2;

public class Java42860 {
    // 조이스틱
    // 탐욕법(Greedy)
    // courses/30/lessons/42860
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        // 글자 변경 횟수 계산
        for (int i = 0; i < length; i++) {
            char word = name.charAt(i);
            answer += Math.min(word - 'A', 'Z' - word + 1);
        }

        // 이동 횟수 계산 (최소 이동 횟수를 초기화)
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            int nextIndex = i + 1;

            // 연속된 'A'의 위치를 찾음
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 현재 위치에서 돌아가는 경우의 이동 횟수 비교
            minMove = Math.min(minMove, i + length - nextIndex + Math.min(i, length - nextIndex));
        }

        answer += minMove;

        return answer;

    }
}
