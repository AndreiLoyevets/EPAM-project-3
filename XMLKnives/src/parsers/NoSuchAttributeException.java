package parsers;

/**
 * The exception is thrown when the parser cannot find the attribute by the 
 * given name.
 * @author Tourist
 *
 */
public class NoSuchAttributeException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NoSuchAttributeException(String attribute) {
		super(attribute);
	}
	
	@Override
	public String getMessage() {
		return "Attribute \'" + super.getMessage() + "\' not found";
	}
}