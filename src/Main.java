import java.io.File;
import java.util.Scanner;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

public class Main {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("scegli che esercizio convalidare (21 o 24)");
        String es=sc.nextLine();

        String xmlFilePath = "file/"+es+"/file.xml";
        String xsdFilePath = "file/"+es+"/schema.xsd";

        // Convalida il file XML specificato
        validateXmlFile(xmlFilePath, xsdFilePath,es);
    }

    private static void validateXmlFile(String xmlFilePath, String xsdFilePath,String es) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(new File(xmlFilePath));
            validator.validate(source); //validazione schema XSD
            System.out.println("l'esercizio numero"+es+"è valido.");
        } catch (Exception e) {
            System.out.println("l'esercizio numero"+es+"non è valido. \nMotivo: " + e.getMessage());
        }
    }
}
