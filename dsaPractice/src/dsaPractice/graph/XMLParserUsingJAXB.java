package dsaPractice.graph;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.StringReader;

public class XMLParserUsingJAXB {
    public static void main(String[] args) {
        String xmlString = "<Document>\n" +
                "    <Xyz>\n" +
                "        <RmtInf>\n" +
                "            <Ustrd>test1</Ustrd>\n" +
                "            <Ustrd>test2</Ustrd>\n" +
                "            <Ustrd>test3</Ustrd>\n" +
                "            <Ustrd>test4</Ustrd>\n" +
                "        </RmtInf>\n" +
                "    </Xyz>\n" +
                "</Document>";

        try {
            // Create a JAXB context
            JAXBContext jaxbContext = JAXBContext.newInstance();

            // Create an Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Unmarshal the XML string into a JAXBElement
            JAXBElement<?> element = (JAXBElement<?>) unmarshaller.unmarshal(new StringReader(xmlString));

            // Get the value of the <RmtInf> element
            JAXBElement<?> rmtInfElement = (JAXBElement<?>) element.getValue();

            // Get the value of the <Ustrd> elements
            Object rmtInfValue = rmtInfElement.getValue();
            if (rmtInfValue instanceof String) {
                // Handle case where there is only one <Ustrd> element
                System.out.println("Ustrd value: " + rmtInfValue);
            } else if (rmtInfValue instanceof JAXBElement) {
                // Handle case where there are multiple <Ustrd> elements
                JAXBElement<?> ustrdElement = (JAXBElement<?>) rmtInfValue;
                Object ustrdValue = ustrdElement.getValue();
                if (ustrdValue instanceof String) {
                    System.out.println("Ustrd value: " + ustrdValue);
                } else if (ustrdValue instanceof JAXBElement) {
                    // Handle case where there are multiple <Ustrd> elements
                    JAXBElement<?>[] ustrdArray = (JAXBElement<?>[]) ustrdValue;
                    for (JAXBElement<?> ustrd : ustrdArray) {
                        System.out.println("Ustrd value: " + ustrd.getValue());
                    }
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
