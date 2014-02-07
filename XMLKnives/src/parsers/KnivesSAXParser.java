package parsers;

import generated.KnifeDesc;
import generated.KnifeDesc.Visual;
import generated.KnifeDesc.Visual.Blade;
import generated.KnifeDesc.Visual.Handle;
import generated.KnifeDesc.Visual.Handle.Wood;
import generated.Knives;
import generated.MetalType;
import generated.WoodType;

import java.io.File;
import java.math.BigInteger;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import logic.Tags;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * This is the document handler for SAX parser.
 * @author Andrei Loyevets
 * @version Feb-4-2014
 *
 */
class KnivesDocHandler extends DefaultHandler {
	private Tags currentElem;
	private KnifeDesc currentKnife;
	private List<KnifeDesc> knives;
	private StringBuffer buffer = new StringBuffer();
	
	public List<KnifeDesc> getKnives() {
		return knives;
	}

	@Override
	public void startDocument() {
		System.out.println("SAX parser start...");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		String data = null;
		
		currentElem = Tags.getValueByName(qName);
		
		try {
		switch (currentElem) {
		case KNIVES:
			knives = new Knives().getKnife();
			break;
			
		case KNIFE:
			currentKnife = new KnifeDesc();

			data = attributes.getValue("name");

			if (data == null) {
				throw new NoSuchAttributeException("name");
			} else {
				currentKnife.setName(data);
			}
			break;
			
		case KNIFE_TYPE: case HANDY: case ORIGIN: break;
		
		case VISUAL:
			currentKnife.setVisual(new Visual());
			break;
			
		case BLADE:
			Blade blade = new Blade();

			// set blade attributes
			data = attributes.getValue("length");
			if (data == null) {
				throw new NoSuchAttributeException("length");
			} else {
				try {
					blade.setLength(new BigInteger(data));
				} catch (NumberFormatException e) {
					throw new IllegalXMLValueException("length", data, true);
				}
			}

			data = attributes.getValue("width");
			if (data == null) {
				throw new NoSuchAttributeException("width");
			} else {
				try {
					blade.setWidth(new BigInteger(data));
				} catch (NumberFormatException e) {
					throw new IllegalXMLValueException("width", data, true);
				}
			}

			data = attributes.getValue("metal");
			if (data == null) {
				throw new NoSuchAttributeException("metal");
			} else {
				try {
					blade.setMetal(MetalType.fromValue(data));
				} catch (IllegalArgumentException e) {
					throw new IllegalXMLValueException("metal", data, true);
				}
			}

			currentKnife.getVisual().setBlade(blade);
			break;
			
		case HANDLE:
			currentKnife.getVisual().setHandle(new Handle());
			break;
			
		case WOOD:
			Wood wood = new Wood();

			data = attributes.getValue("type");
			if (data == null) {
				throw new NoSuchAttributeException("type");
			} else {
				try {
					wood.setType(WoodType.fromValue(data));
				} catch (IllegalArgumentException e) {
					throw new IllegalXMLValueException("type", data, true);
				}
			}

			currentKnife.getVisual().getHandle().setWood(wood);
			break;
			
		case METAL:
			currentKnife.getVisual().getHandle().setMetal(new Object());
			break;
			
		case PLASTIC:
			currentKnife.getVisual().getHandle().setPlastic(new Object());
			break;
		
		case DOL: case COLLECTION: break;
		
		default:
			
			// element not found
			currentKnife = null;
			throw new SAXException("Unknown element " + qName);
		}} catch (NoSuchAttributeException e) {

			// required attribute is missing
			throw new SAXException(e.getMessage());
		} catch (IllegalXMLValueException e) {

			// wrong attribute value
			throw new SAXException(e.getMessage());
		} catch (NullPointerException e) {

			// illegal order of construction of a knife
			throw new SAXException("Illegal order of elements");
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		if (currentElem == Tags.KNIFE_TYPE ||
			currentElem == Tags.HANDY ||
			currentElem == Tags.ORIGIN ||
			currentElem == Tags.DOL ||
			currentElem == Tags.COLLECTION) {
			
			buffer.append(ch, start, length);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		String data = buffer.toString().trim();
		
		switch (Tags.getValueByName(qName)) {
		
		case KNIFE:
			knives.add(currentKnife);
			break;
			
		case KNIFE_TYPE:
			currentKnife.setKnifeType(data);
			break;
			
		case HANDY:
			currentKnife.setHandy(Integer.parseInt(data));
			break;
			
		case ORIGIN:
			currentKnife.setOrigin(data);
			break;
			
		case DOL:
			currentKnife.getVisual().setDol(Boolean.parseBoolean(data));
			break;
			
		case COLLECTION:
			currentKnife.setCollection(Boolean.parseBoolean(data));
			break;
		
		default:
				break;
		}
		
		buffer.setLength(0);
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("End of document");
	}
}

/**
 * This is a SAX parser for the XML document containing a collection of knives.
 * 
 * @author Tourist
 * @version Feb-4-2014
 *
 */
public class KnivesSAXParser {
	
	/**
	 * Parses the XML document and creates the list of records.
	 * @param filename the input XML document
	 * @return the list of knives (records)
	 */
	public List<KnifeDesc> parseDocument(String filename) {
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			KnivesDocHandler docHandler = new KnivesDocHandler();
			
			if (docHandler != null) {
				parser.parse(new File(filename), docHandler);
				
				return docHandler.getKnives();
			}
		} catch (Exception e) {
			System.out.println("SAX parser: error while parsing document");
		}
		
		return null;
	}
}