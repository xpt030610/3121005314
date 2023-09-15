package test;

import main.IOUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class IOUtilsTest {

    @Test
    public void readFileTest() throws IOException {
        IOUtils.readFile("test.txt");
    }

    @Test
    public void writeFileTest() throws IOException {
        IOUtils.writeFile("writeFileTest.txt","我爱刘德华！");
    }

}
