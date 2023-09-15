package test;

import main.MathQuizGenerator;
import org.testng.annotations.Test;

import java.util.List;

public class MathQuizGeneratorTest {

    @Test
    public void intAnswerTest() {
        String operator = "+";
        char c = operator.charAt(0);
        int a = 1;
        int b = 2;
        MathQuizGenerator.intAnswer(c, a, b);
    }

    @Test
    public static void generateMathQuizTest() {
        List<String> list = MathQuizGenerator.generateMathQuiz();
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public static void generateFractionMathQuizTest() {
        List<String> list = MathQuizGenerator.generateFractionMathQuiz();
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public static void isEquivalentQuestionTest() {
        String question1, question2;
        question1="24/65+894/1548";
        question2="85/798-156/456";
        boolean b = MathQuizGenerator.isEquivalentQuestion(question1,question2);
        System.out.println(b);
    }
}
