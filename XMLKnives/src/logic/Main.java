package logic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import parsers.KnivesDOMParser;
import parsers.KnivesSAXParser;
import parsers.KnivesStAXParser;
import generated.KnifeDesc;

/**
 * This is the driver class. It opens the XML document, validates it according
 * to XSD schema and parses the document using SAX, DOM and StAX parsers.
 * Then it creates a collection of knives and sorts them by name.
 * It also generates HTML document according to the structure specified in
 * XSL file.
 * 
 * @author Andrei Loyevets
 * @version Feb-6-2014
 */
public class Main {
	
	/**
	 * Sorts knives by name.
	 * @param knives the list of knives to sort
	 */
	private static void sortKnives(List<KnifeDesc> knives) {
		Collections.sort(knives, new Comparator<KnifeDesc>() {
			@Override
			public int compare(KnifeDesc o1, KnifeDesc o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}
	
	/**
	 * Parses XML document using SAX parser.
	 */
	public static void SAXTest() {
		List<KnifeDesc> knives = new KnivesSAXParser().parseDocument("xml/knives.xml");
		
		sortKnives(knives);
		
		for (KnifeDesc knife : knives) {
			showKnife(knife);
		}
	}
	
	/**
	 * Parses XML document using DOM parser.
	 */
	public static void DOMTest() {
		List<KnifeDesc> knives = new KnivesDOMParser().parseDocument("xml/knives.xml");
		
		Collections.sort(knives, new Comparator<KnifeDesc>() {
			@Override
			public int compare(KnifeDesc o1, KnifeDesc o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for (KnifeDesc knife : knives) {
			showKnife(knife);
		}
	}
	
	/**
	 * Parses XML document using StAX parser.
	 */
	public static void StAXTest() {
		List<KnifeDesc> knives = new KnivesStAXParser().parseDocument("xml/knives.xml");
		
		Collections.sort(knives, new Comparator<KnifeDesc>() {
			@Override
			public int compare(KnifeDesc o1, KnifeDesc o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for (KnifeDesc knife : knives) {
			showKnife(knife);
		}
	}
	
	/**
	 * Runs 3 tests for different parsers, validates XML document and generates
	 * the corresponding HTML document.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String [] args) {
		System.out.println("Start validating XML document...");
		new KnivesXMLValidator().validate("xml/schema.xsd", "xml/knives.xml");
		
		System.out.println("Test SAX...");
		SAXTest();
		
		System.out.println("Test DOM...");
		DOMTest();
		
		System.out.println("Test StAX...");
		StAXTest();
		
		System.out.println("Creating HTML page (xml/knives.html)...");
		new HTMLTransformer().transformToHTML("xml/knives.xml", "xml/knives.html");
	}
	
	/**
	 * Prints brief information about the knife to console.
	 * 
	 * @param knife
	 */
	private static void showKnife(KnifeDesc knife) {
		System.out.println("Name: " + knife.getName());
		System.out.println("Type: " + knife.getKnifeType());
		System.out.println("Handy: " + knife.getHandy());
		System.out.println("Origin: " + knife.getOrigin());
		System.out.println("Blade: " + knife.getVisual().getBlade().getLength() +
				" " + knife.getVisual().getBlade().getWidth() + " " +
				knife.getVisual().getBlade().getMetal());
		System.out.println("Dol: " + knife.getVisual().isDol());
		System.out.println("Collection: " + knife.isCollection() + "\n");
	}
}