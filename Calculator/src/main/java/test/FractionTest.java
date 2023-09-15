package test;

import main.Fraction;
import org.testng.annotations.Test;

public class FractionTest {

    Fraction fraction=new Fraction(10,11,12,13);

    @Test
    public void printTest(){
        fraction.print(10,1);
    }

    @Test
    public void sumTest(){
        fraction.sum();
    }

    @Test
    public void jianTest(){
        fraction.jian();
    }

    @Test
    public void chengTest(){
        fraction.cheng();
    }

    @Test
    public void chuTest(){
        fraction.chu();
    }

    @Test
    public void operTest(){
        String s="10/32+60/456";
        fraction.oper(s);
    }
}
