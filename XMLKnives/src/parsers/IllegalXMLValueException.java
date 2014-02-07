package parsers;

/**
 * The exception is thrown when a value of a tag or an attribute is invalid.
 * 
 * @author Andrei Loyevets
 * @version Feb-4-2014
 *
 */
public class IllegalXMLValueException extends Exception {
	private static final long serialVersionUID = 1L;
	private String element;
	private boolean isAttribute;
	
	public IllegalXMLValueException(String name, String value, boolean isAttr) {
		super(value);
		element = name;
		isAttribute = isAttr;
	}
	
	@Override
	public String getMessage() {
		return "Value " + super.getMessage() + " is not allowed for " +
	           (isAttribute ? "attribute" : "element") + element;
	}
}
