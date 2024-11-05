package hello.javaLv2;

public class Java17683 {
    // 방금그곡
    // 2018 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/17683
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int playTime = 0;
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
        m = m.replace("B#", "b");

        for(int i=0; i<musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            String[] startTime = musicInfo[0].split(":");
            String[] endTime = musicInfo[1].split(":");
            int startMin = Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);
            int endMin = Integer.parseInt(endTime[0])*60 + Integer.parseInt(endTime[1]);

            String musicCode = musicInfo[3];
            musicCode = musicCode.replace("C#", "c");
            musicCode = musicCode.replace("D#", "d");
            musicCode = musicCode.replace("F#", "f");
            musicCode = musicCode.replace("G#", "g");
            musicCode = musicCode.replace("A#", "a");
            musicCode = musicCode.replace("B#", "b");

            String wholeMusic = "";
            for(int j=0; j<(endMin-startMin)/musicCode.length(); j++) {
                wholeMusic += musicCode;
            }
            wholeMusic += musicCode.substring(0, (endMin-startMin)%musicCode.length());
            System.out.println(wholeMusic.length() + wholeMusic);
            if(wholeMusic.contains(m) && playTime < endMin-startMin) {
                answer = musicInfo[2];
                playTime = endMin-startMin;
            }
        }
        if(answer.length() == 0) {
            answer = "(None)";
        }
        return answer;
    }
}
