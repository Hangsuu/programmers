package hello.javaLv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java67257 {
    // 수식 최대화
    // courses/30/lessons/67257
    static Map<String, List<Integer>> formulaMap = new HashMap<>();

    public long solution(String expression) {
        String[] numberString = expression.split("\\+|\\*|-");
        String formula = expression.replaceAll("\\d", "");
        String[] formulas = formula.split("");
        List<String> expressions = new ArrayList<>();
        for(int i=0; i<numberString.length; i++) {
            expressions.add(numberString[i]);
            if(i < numberString.length - 1) {
                expressions.add(formulas[i]);
            }
        }

        long answer = 0L;
        answer = Math.max(answer, calculate(expressions, "+", "-", "*"));
        answer = Math.max(answer, calculate(expressions, "+", "*", "-"));
        answer = Math.max(answer, calculate(expressions, "-", "+", "*"));
        answer = Math.max(answer, calculate(expressions, "-", "*", "+"));
        answer = Math.max(answer, calculate(expressions, "*", "-", "+"));
        answer = Math.max(answer, calculate(expressions, "*", "+", "-"));
        return answer;
    }

    private long calculate(List<String> expressions, String first, String second, String third) {
        List<String> tempExpressions = getExpressions(expressions);
        while(true) {
            int index = tempExpressions.indexOf(first);
            if(index == -1) {
                break;
            }
            long firstNum = Long.parseLong(tempExpressions.get(index-1));
            long secondNum = Long.parseLong(tempExpressions.get(index+1));
            long result = 0L;
            if("+".equals(first)) {
                result = firstNum + secondNum;
            } else if("-".equals(first)) {
                result = firstNum - secondNum;
            } else {
                result = firstNum * secondNum;
            }
            tempExpressions.set(index-1, result+"");
            tempExpressions.remove(index);
            tempExpressions.remove(index);
        }
        while(true) {
            int index = tempExpressions.indexOf(second);
            if(index == -1) {
                break;
            }
            long firstNum = Long.parseLong(tempExpressions.get(index-1));
            long secondNum = Long.parseLong(tempExpressions.get(index+1));
            long result = 0L;
            if("+".equals(second)) {
                result = firstNum + secondNum;
            } else if("-".equals(second)) {
                result = firstNum - secondNum;
            } else {
                result = firstNum * secondNum;
            }
            tempExpressions.set(index-1, result+"");
            tempExpressions.remove(index);
            tempExpressions.remove(index);
        }
        while(true) {
            int index = tempExpressions.indexOf(third);
            if(index == -1) {
                break;
            }
            long firstNum = Long.parseLong(tempExpressions.get(index-1));
            long secondNum = Long.parseLong(tempExpressions.get(index+1));
            long result = 0L;
            if("+".equals(third)) {
                result = firstNum + secondNum;
            } else if("-".equals(third)) {
                result = firstNum - secondNum;
            } else {
                result = firstNum * secondNum;
            }
            tempExpressions.set(index-1, result+"");
            tempExpressions.remove(index);
            tempExpressions.remove(index);
        }
        return Math.abs(Long.parseLong(tempExpressions.get(0)));
    }

    private List<String> getExpressions(List<String> expressions) {
        List<String> tempExpressions = new ArrayList<>();
        for(String expression : expressions) {
            tempExpressions.add(expression);
        }
        return tempExpressions;
    }
}
