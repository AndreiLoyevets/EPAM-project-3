package logic;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * This class validates the XML document according to the given XSD schema.
 * 
 * @author Andrei Loyevets
 * @version Feb-6-2014
 *
 */
public class KnivesXMLValidator {
	
	/**
	 * Validates the XML document according to the XSD schema.
	 * @param xsdSchema the filename of the XSD schema file
	 * @param xmlFile the XML document for validation
	 */
	public void validate(String xsdSchema, String xmlFile) {
		try {
			SchemaFactory schemaFactory = SchemaFactory.newInstance(
					XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new File(xsdSchema));
			Validator validator = schema.newValidator();
			
			validator.validate(new StreamSource(new File(xmlFile)));
			
		} catch (Exception e) {
			System.out.println("File " + xmlFile + " is not valid!\n" + e.getMessage());
			return;
		}
		
		System.out.println("File " + xmlFile + " is valid!");
	}
}
