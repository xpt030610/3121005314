package main;

import java.util.Scanner;

/**
 * 用于生成分数
 * a/b 与 c/d 两个分数
 */
public class Fraction {
    int a, b, c, d, m, n;
    static String answer;

    public Fraction(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    //分式约分
    public void print(int m, int n) {
        int x = Math.abs(m);
        int y = Math.abs(n);
        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }
        while (y != 0) {
            int k = x % y;
            x = y;
            y = k;
        }
        m = m / x;
        n = n / x;
        if (n == 1)
           // System.out.println(m);
            answer=m+"";
        else
            //System.out.println(m + "/" + n);
        answer=m + "/" + n;
    }
    //四则运算
    public void sum() {
        m = a * d + b * c;
        n = b * d;
        print(m, n);
    }

    public void jian() {
        m = a * d - b * c;
        n = b * d;
        print(m, n);
    }

    public void cheng() {
        m = a * c;
        n = b * d;
        print(m, n);
    }

    public void chu() {
        m = a * d;
        n = b * c;
        print(m, n);
    }
    //判断四则运算类型
    public void oper(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            if (ss == '+') {
                sum();
                break;
            } else if (ss == '-') {
                jian();
                break;
            } else if (ss == '*') {
                cheng();
                break;
            } else if (ss == '\\') {
                chu();
                break;
            }
        }
    }
}





