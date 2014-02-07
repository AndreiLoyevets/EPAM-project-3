package parsers;

import generated.KnifeDesc;
import generated.KnifeDesc.Visual;
import generated.KnifeDesc.Visual.Blade;
import generated.KnifeDesc.Visual.Handle;
import generated.KnifeDesc.Visual.Handle.Wood;
import generated.MetalType;
import generated.WoodType;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import logic.Tags;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This is a DOM parser for the XML document containing a collection of knives.
 * 
 * @author Andrei Loyevets
 * @version Feb-6-2014
 *
 */
public class KnivesDOMParser {
	
	/**
	 * Creates DOM model of the XML file.
	 * 
	 * @param filename the input XML document
	 * @return corresponding DOM document
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public Document getDocument(String filename) throws
	       ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(new File(filename));
		
		return doc;
	}
	
	/**
	 * Parses the XML document and creates the list of records.
	 * @param filename the input XML document
	 * @return the list of knives (records)
	 */
	public List<KnifeDesc> parseDocument(String filename) {
		List<KnifeDesc> knives = new ArrayList<>();
		KnifeDesc knife = null;
		Node currentNode = null;
		
		try {
			Document doc = getDocument(filename);
			NodeList records = doc.getDocumentElement().getElementsByTagName("knife");
			
			for (int i = 0; i < records.getLength(); ++i) {
				currentNode = records.item(i);
				
				// create new knife instance
				knife = new KnifeDesc();
				
				// get name
				knife.setName(((Element) currentNode).getAttribute("name"));
				
				// get child tags
				NodeList children = currentNode.getChildNodes();
				
				for (int j = 0; j < children.getLength(); ++j) {
					Node node = children.item(j);
					
					if (node instanceof Element) {
						switch (Tags.getValueByName(node.getNodeName())) {
						case KNIFE_TYPE:
							knife.setKnifeType(node.getTextContent());
							break;
						
						case HANDY:
							knife.setHandy(Integer.parseInt(node.getTextContent()));
							break;
							
						case ORIGIN:
							knife.setOrigin(node.getTextContent());
							break;
							
						case VISUAL:
							knife.setVisual(new Visual());
							
							NodeList visualAttrs = node.getChildNodes();
							
							for (int k = 0; k < visualAttrs.getLength(); ++k) {
								Node visualNode = visualAttrs.item(k);
								
								if (visualNode instanceof Element) {
									switch (Tags.getValueByName(visualNode.getNodeName())) {
									
									case BLADE:
										
										Blade blade = new Blade();
										
										blade.setLength(new BigInteger(((Element) visualNode).getAttribute("length")));
										blade.setWidth(new BigInteger(((Element) visualNode).getAttribute("width")));
										blade.setMetal(MetalType.fromValue(((Element) visualNode).getAttribute("metal")));
										
										knife.getVisual().setBlade(blade);
										
										break;
										
									case HANDLE:
										knife.getVisual().setHandle(new Handle());
										
										// check wood
										NodeList woodNode = ((Element) visualNode).getElementsByTagName("wood");
										
										if (woodNode.getLength() > 0) {
											Wood wood = new Wood();
											wood.setType(WoodType.fromValue(((Element) woodNode.item(0)).getAttribute("type")));
											knife.getVisual().getHandle().setWood(wood);
											break;
										}
										
										// check metal
										if (((Element) visualNode).getElementsByTagName("metal").getLength() > 0) {
											knife.getVisual().getHandle().setMetal(new Object());
											break;
										}
										
										// check plastic
										if (((Element) visualNode).getElementsByTagName("plastic").getLength() > 0) {
											knife.getVisual().getHandle().setPlastic(new Object());
											break;
										}
										
									case DOL:
										knife.getVisual().setDol(Boolean.parseBoolean(visualNode.getTextContent()));
										break;
										
									default:
										knife = null;
										throw new IllegalArgumentException();
									}
								}
							}
							
							break;
							
						
							
						case COLLECTION:
							knife.setCollection(Boolean.parseBoolean(node.getTextContent()));
							break;
							
						default:
							knife = null;
							throw new IllegalArgumentException();
						}
					}
				}
				
				knives.add(knife);
			}
			
		} catch (Exception e) {
			System.out.println("DOM parser: error while parsing document");
		}
		
		return knives;
	}
}