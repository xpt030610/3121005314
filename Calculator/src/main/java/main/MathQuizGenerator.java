package main;

import java.io.IOException;
import java.util.*;

/**
 *
 */
public class MathQuizGenerator {


    public static void main(String[] args) throws IOException {
        String check=args[0];
        //生成题目与答案
        if (check.equals("FALSE")){
            List<String> fractionQuestionList=generateFractionMathQuiz();
            List<String>  intQuestionList=generateMathQuiz();
            IOUtils.writeFile("test.txt",test.toString());
            IOUtils.writeFile("answer.txt",answer.toString());
        }
        //----------------------------
        //程序支持对给定的题目文件和答案文件，判定答案中的对错并进行数量统计
        if (check.equals("TRUE")) {
            String[] exercise = IOUtils.readFile("exerciseFile.txt").split("\n");
            System.out.println(exercise.length);
            String[] answer = IOUtils.readFile("answer.txt").split("\n");
            System.out.println(answer.length);
            check(exercise,answer);
            String content="正确题目："+correctList.toString()+"\n"
                    +"错误题目："+wrongList.toString();
            IOUtils.writeFile("Grade.txt",content);
        }



    }

    /**
     * 批改
     * @param exercise
     * @param answer
     */
    static List<String> correctList=new ArrayList<>();
    static List<String> wrongList=new ArrayList<>();
    private static void check(String[] exercise, String[] answer){

        for (int i = 0; i < exercise.length; i++) {
            if (Objects.equals(exercise[i], answer[i])){
                correctList.add((i+1)+"");
            }else {
                wrongList.add((i+1)+"");
            }

        }
    }
    private static final int MAX_NUMBER = 100; // 可以出现的最大数值
    private static final int MIN_NUMBER = 1;   // 可以出现的最小数值
    private static final int OPERATORS_COUNT = 4; // 操作符数量
    private static final int MAX_NUM_OF_QUESTIONS = 50; // 最大题目数量

    private static final char[] OPERATORS = {'+', '-', '*', '/'}; // 可用的操作符

    private static final Random random = new Random();
    private static final StringBuffer answer=new StringBuffer();
    private static final StringBuffer test=new StringBuffer();

    //获取到整数的answer
    public static String intAnswer(char operator,int a,int b){
        int answer=0;
        switch (operator) {
            case '+':
                answer=a+b;
                break;
            case '-':
                answer=a-b;
                break;
            case '*':
                answer=a*b;
                break;
            case '/':
                answer=a/b;
                break;
        }
        return answer+"";
    }



    /**
     * 生成整数的算数题目
     * @return 所有随机题目的list
     */
    public static List<String>  generateMathQuiz() {
        List<String> questions=new ArrayList<>();
        int count = 0; // 生成的题目数量
        while (count < MAX_NUM_OF_QUESTIONS) {
            int a = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int b = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;

            char operator = OPERATORS[random.nextInt(OPERATORS_COUNT)];

            // 除法运算时，要确保除数不为0且能够整除
            if (operator == '/' && (b == 0 || a % b != 0)) {
                continue;
            }
            //生成的题目中计算过程不能产生负数，也就是说算术表达式中如果存在形如e1− e2的子表达式，那么e1≥ e2
            if(operator=='-'&&(a<b)){
                continue;
            }
            // 构造题目字符串
            String question = "("+(count+1)+"):"+a + " " + operator + " " + b + " = ";



            // 判断新生成的题目是否与已有的题目重复
            boolean isDuplicate = false;
            for (String q : questions) {
                if (isEquivalentQuestion(question, q)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                questions.add(question);
                answer.append("("+(count+1+50)+"):"+intAnswer(operator,a,b)+"\n");
                test.append("("+(count+1+50)+"):"+a + " " + operator + " " + b + " = "+"\n");
            }
            count++;
        }
        return questions;

        }


    /**
     * 生成分数测试题
     * @return
     */
    public static List<String>  generateFractionMathQuiz() {
        List<String> questions=new ArrayList<>();
        int count = 0; // 生成的题目数量
        while (count < MAX_NUM_OF_QUESTIONS) {
            int a = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int b = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;// 随机分数a/b
            int c = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int d = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;//  c/d

            char operator = OPERATORS[random.nextInt(OPERATORS_COUNT)];

            // 除法运算时，要确保除数不为0且能够整除
            if (operator == '/' && (b == 0 || a % b != 0)) {
                continue;
            }

            // 构造题目字符串
            //a/b + c/d=
            Fraction fraction=new Fraction(a,b,c,d);
            fraction.oper(a + "/"+b+ operator + c+"/"+d);
            String question = "("+count+"):"+a + "/"+b+" " + operator + " " + c+"/"+d + " = "+Fraction.answer;
            //+fraction.oper( a+"/"+b+" " + operator + " " + c+"/"+d)

            //todo 分数前后重复不会判断。。。。。 潘哥加油
            questions.add(question);
            answer.append("("+(count+1)+"):"+Fraction.answer+"\n");
            test.append("("+(count+1)+"):"+a + "/"+b+" " + operator + " " + c+"/"+d + " = "+"\n");
            count++;
        }
        return questions;

    }

    /**
     * 判断两道整数题目是否等价，即通过有限次交换+和×左右的算术表达式变换为同一道题目
     *
     * @param question1 第一道题目
     * @param question2 第二道题目
     * @return 如果两道题目等价则返回 true，否则返回 false
     */
    public static boolean isEquivalentQuestion(String question1, String question2) {
        String[] tokens1 = question1.split(" ");
        String[] tokens2 = question2.split(" ");

        // 如果两道题目的操作数数量不同，则它们不等价
        if (tokens1.length != tokens2.length) {
            return false;
        }

        // 统计两道题目中 + 和 × 的数量和位置
        int numPlus1 = 0, numPlus2 = 0, numTimes1 = 0, numTimes2 = 0;
        List<Integer> plusPositions1 = new ArrayList<>();
        List<Integer> plusPositions2 = new ArrayList<>();
        List<Integer> timesPositions1 = new ArrayList<>();
        List<Integer> timesPositions2 = new ArrayList<>();
        for (int i = 1; i < tokens1.length - 1; i += 2) {
            if (tokens1[i].equals("+")) {
                numPlus1++;
                plusPositions1.add(i);
            } else if (tokens1[i].equals("*")) {
                numTimes1++;
                timesPositions1.add(i);
            }
            if (tokens2[i].equals("+")) {
                numPlus2++;
                plusPositions2.add(i);
            } else if (tokens2[i].equals("*")) {
                numTimes2++;
                timesPositions2.add(i);
            }
        }

        // 如果两道题目的 + 和 × 的数量不同，则它们不等价
        if (numPlus1 != numPlus2 || numTimes1 != numTimes2) {
            return false;
        }

        // 如果两道题目中 + 和 × 的位置不同，则它们不等价
        if (!plusPositions1.equals(plusPositions2) || !timesPositions1.equals(timesPositions2)) {
            return false;
        }

        // 对于两道题目中每个操作数，如果它们在相同的位置上，但值不同，则两道题目不等价
        for (int i = 0; i < tokens1.length; i += 2) {
            if (!tokens1[i].equals(tokens2[i])) {
                return false;
            }
        }
        return true;
    }
}



