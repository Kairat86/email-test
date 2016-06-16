package testng;


import org.testng.TestNG;
import org.testng.xml.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestRunner {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        TestNG testNG = new TestNG();
        new Parser(TestRunner.class.getClassLoader().getResourceAsStream("testng.xml")).parseToList().forEach(testNG::setCommandLineSuite);
        testNG.run();
    }

}
