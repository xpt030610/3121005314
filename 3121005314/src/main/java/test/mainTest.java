package test;

import main.Demo;
import org.testng.annotations.Test;
import util.ReadFile;
import util.SimHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mainTest {
    @Test
    void test1() throws IOException {
        ReadFile rf=new ReadFile();
        String article1=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig.txt");
        String article2=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig.txt");

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

    @Test
    void test2() throws IOException {
        ReadFile rf=new ReadFile();
        String article1=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig.txt");
        String article2=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_add.txt");

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

    @Test
    void test3() throws IOException {
        ReadFile rf=new ReadFile();
        String article1=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig.txt");
        String article2=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_del.txt");

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

    @Test
    void test4() throws IOException {
        ReadFile rf=new ReadFile();
        String article1=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig.txt");
        String article2=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_dis_1.txt");

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

    @Test
    void test5() throws IOException {
        ReadFile rf=new ReadFile();
        String article1=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig.txt");
        String article2=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_dis_10.txt");

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

    @Test
    void test6() throws IOException {
        ReadFile rf=new ReadFile();
        String article1=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig.txt");
        String article2=rf.read("C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_dis_15.txt");

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
