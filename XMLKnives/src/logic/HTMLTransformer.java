package logic;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * This class allows to transform XML document to HTML document. The structure
 * of the HTML document is specified in xml/knives.xsl.
 * 
 * @author Andrei Loyevets
 * @version Feb-6-2014
 *
 */
public class HTMLTransformer {
	
	/**
	 * Creates HTML document from XML
	 * @param xmlSource the filename of XML document
	 * @param htmlDest the filename of output HTML document
	 */
	public void transformToHTML(String xmlSource, String htmlDest) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource("xml/knives.xsl"));
			transformer.transform(new StreamSource(xmlSource), new StreamResult(htmlDest));
			
		} catch (Exception e) {
			System.out.println("Cannot transform XML to HTML");
		}
	}
}
