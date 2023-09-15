package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public String read(String road) throws IOException {
        String article=null;
        char[] chs=new char[1024];
        int len;
        BufferedReader br = new BufferedReader(new FileReader(road));
        while ((len= br.read(chs))!=-1){
            article= new String(chs,0,len);
        }
        br.close();
        return article;
    }
}
