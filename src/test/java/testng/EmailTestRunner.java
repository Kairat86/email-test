package testng;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class EmailTestRunner {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

    }

    public void run() throws IOException, SAXException, ParserConfigurationException {
        TestNG testNG = new TestNG();
        new Parser(EmailTestRunner.class.getClassLoader().getResourceAsStream("testng.xml")).parseToList().forEach(testNG::setCommandLineSuite);
        testNG.run();
    }

}
