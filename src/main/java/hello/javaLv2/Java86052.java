package hello.javaLv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java86052 {
    // 빛의 경로 사이클
    // BFS
    // courses/30/lessons/86052
    public int[] solution(String[] grid) {
        List<Integer> answerList = new ArrayList<>();

        int gridRow = grid.length;
        int gridCol = grid[0].length();
        String[][] gridArray = new String[gridRow][gridCol];

        for(int i=0; i<gridRow; i++) {
            String[] temp = grid[i].split("");
            for(int j=0; j<gridCol; j++) {
                gridArray[i][j] = temp[j];
            }
        }

        boolean[][][] visitedGrid = new boolean[gridRow][gridCol][4];
        /**
         * 0 : right
         * 1 : left
         * 2 : up
         * 3 : down
         */
        for(int i=0; i<gridRow; i++) {
            for(int j=0; j<gridCol; j++) {
                for(int k=0; k<4; k++) {
                    if(!visitedGrid[i][j][k]) {
                        int row = i;
                        int col = j;
                        int way = k;
                        int count = 1;

                        while(true) {
                            visitedGrid[row][col][way] = true;
                            if(way == 0) { // right
                                int newCol = (col+1)%gridArray[0].length;
                                if (gridArray[row][newCol].equals("S")) {
                                    if(!visitedGrid[row][newCol][0]) {
                                        col = newCol;
                                        way = 0;
                                        count ++;
                                    } else {
                                        break;
                                    }
                                } else if(gridArray[row][newCol].equals("L")) {
                                    if(!visitedGrid[row][newCol][2]) {
                                        col = newCol;
                                        count++;
                                        way = 2;
                                    } else {
                                        break;
                                    }
                                } else {
                                    if(!visitedGrid[row][newCol][3]) {
                                        col = newCol;
                                        count++;
                                        way = 3;
                                    } else {
                                        break;
                                    }
                                }
                            } else if(way == 1) { // left
                                int newCol = (col-1 + gridArray[0].length)%gridArray[0].length;
                                if (gridArray[row][newCol].equals("S")) {
                                    if(!visitedGrid[row][newCol][1]) {
                                        col = newCol;
                                        count++;
                                        way = 1;
                                    } else {
                                        break;
                                    }
                                } else if(gridArray[row][newCol].equals("L")) {
                                    if(!visitedGrid[row][newCol][3]) {
                                        col = newCol;
                                        count++;
                                        way = 3;
                                    } else {
                                        break;
                                    }
                                } else {
                                    if(!visitedGrid[row][newCol][2]) {
                                        col = newCol;
                                        count++;
                                        way = 2;
                                    } else {
                                        break;
                                    }
                                }
                            } else if(way == 2) { // up
                                int newRow = (row+1)%gridArray.length;
                                if (gridArray[newRow][col].equals("S")) {
                                    if(!visitedGrid[newRow][col][2]) {
                                        row = newRow;
                                        count++;
                                        way = 2;
                                    } else {
                                        break;
                                    }
                                } else if(gridArray[newRow][col].equals("L")) {
                                    if(!visitedGrid[newRow][col][1]) {
                                        row = newRow;
                                        count++;
                                        way = 1;
                                    } else {
                                        break;
                                    }
                                } else {
                                    if(!visitedGrid[newRow][col][0]) {
                                        row = newRow;
                                        count++;
                                        way = 0;
                                    } else {
                                        break;
                                    }
                                }
                            } else { // down
                                int newRow = (row-1+gridArray.length)%gridArray.length;
                                if (gridArray[newRow][col].equals("S")) {
                                    if(!visitedGrid[newRow][col][3]) {
                                        row = newRow;
                                        count++;
                                        way = 3;
                                    } else {
                                        break;
                                    }
                                } else if(gridArray[newRow][col].equals("L")) {
                                    if(!visitedGrid[newRow][col][0]) {
                                        row = newRow;
                                        count++;
                                        way = 0;
                                    } else {
                                        break;
                                    }
                                } else {
                                    if(!visitedGrid[newRow][col][1]) {
                                        row = newRow;
                                        count++;
                                        way = 1;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }

                        answerList.add(count);
                    }
                }
            }
        }
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
