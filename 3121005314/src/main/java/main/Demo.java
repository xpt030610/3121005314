package main;

import util.SimHash;

import java.io.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        String s1 = null;
        String s2 = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入原文章的绝对地址：");
        s1 = sc.nextLine();
        System.out.print("请输入查重文章的绝对地址：");
        s2 = sc.nextLine();
        String article1=null;
        String article2=null;
        char[] chs=new char[1024];
        int len;
        BufferedReader br = new BufferedReader(new FileReader(s1));
        while ((len= br.read(chs))!=-1){
            article1= new String(chs,0,len);
        }
        br = new BufferedReader(new FileReader(s2));
        while ((len= br.read(chs))!=-1){
            article2= new String(chs,0,len);
        }
        br.close();
        long l3 = System.currentTimeMillis();
        SimHash hash1 = new SimHash(article1, 64);
        SimHash hash2 = new SimHash(article2, 64);
        System.out.println("======================================");
        System.out.println("海明距离：" + hash1.hammingDistance(hash2));
        System.out.println("文本相似度：" + hash1.getSemblance(hash2));
        long l4 = System.currentTimeMillis();
        System.out.println("总计用时：" + (l4 - l3));
        System.out.println("======================================");
    }

}
