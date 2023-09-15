package test;

import org.testng.annotations.Test;
import util.SimHash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SimHashTest {

    @Test
    void cleanResumeTest() throws IOException {
        String s1 = "C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_del.txt";
        String article1=null;
        char[] chs=new char[1024];
        int len;
        BufferedReader br = new BufferedReader(new FileReader(s1));
        while ((len= br.read(chs))!=-1){
            article1= new String(chs,0,len);
        }
        br.close();
        SimHash simHash=new SimHash(article1);
        System.out.println("结果为："+simHash.cleanResume(article1));
    }

    @Test
    void hash() throws IOException {
        String s1 = "C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_del.txt";
        String article1=null;
        char[] chs=new char[1024];
        int len;
        BufferedReader br = new BufferedReader(new FileReader(s1));
        while ((len= br.read(chs))!=-1){
            article1= new String(chs,0,len);
        }
        br.close();
        SimHash simHash=new SimHash(article1);
        System.out.println("结果为："+simHash.hash(article1));
    }

    @Test
    void simHash() throws IOException {
        String s1 = "C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_del.txt";
        String article1=null;
        char[] chs=new char[1024];
        int len;
        BufferedReader br = new BufferedReader(new FileReader(s1));
        while ((len= br.read(chs))!=-1){
            article1= new String(chs,0,len);
        }
        br.close();
        SimHash simHash=new SimHash(article1);
        System.out.println("结果为："+simHash.simHash());
    }

    @Test
    void hammingDistance() throws IOException {
        String s1 = "C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_del.txt";
        String article1=null;
        char[] chs=new char[1024];
        int len;
        BufferedReader br = new BufferedReader(new FileReader(s1));
        while ((len= br.read(chs))!=-1){
            article1= new String(chs,0,len);
        }
        br.close();
        SimHash simHash=new SimHash(article1);
        System.out.println("结果为："+simHash.hammingDistance(simHash));
    }

    @Test
    void getSemblance() throws IOException {
        String s1 = "C:\\Users\\86198\\Desktop\\xpt\\3121005314\\assets\\orig_0.8_del.txt";
        String article1=null;
        char[] chs=new char[1024];
        int len;
        BufferedReader br = new BufferedReader(new FileReader(s1));
        while ((len= br.read(chs))!=-1){
            article1= new String(chs,0,len);
        }
        br.close();
        SimHash simHash=new SimHash(article1);
        System.out.println("结果为："+simHash.getSemblance(simHash));
    }
}


