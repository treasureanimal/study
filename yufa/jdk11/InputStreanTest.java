package jdk11;

import java.io.FileOutputStream;

public class InputStreanTest {
    public static void main(String[] args) throws Exception {
        InputStreanTest inputStreanTest = new InputStreanTest();
        inputStreanTest.readFile();
    }

    private void readFile() throws Exception {
        var is = this.getClass().getResourceAsStream("file");
        try (var os = new FileOutputStream("name")) {
            is.transferTo(os); //java11添加将
        }
        is.close();
    }
}
