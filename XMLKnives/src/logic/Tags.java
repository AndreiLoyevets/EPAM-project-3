package logic;

/**
 * Tag names in the form of enumerations instead of their string representations.
 * 
 * @author Andrei Loyevets
 * @version Feb-5-2014
 *
 */
public enum Tags {
	KNIVES("knives"),
	KNIFE("knife"),
	KNIFE_TYPE("knifeType"),
	HANDY("handy"),
	ORIGIN("origin"),
	VISUAL("visual"),
	BLADE("blade"),
	HANDLE("handle"),
	WOOD("wood"),
	METAL("metal"),
	PLASTIC("plastic"),
	DOL("dol"),
	COLLECTION("collection");
	
	private final String tagName;
	
	private Tags(String s) {
		tagName = s;
	}
	
	public static Tags getValueByName(String name) {
		for (Tags tag : Tags.values()) {
			if (name.equals(tag.tagName)) {
				return tag;
			}
		}
		
		return null;
	}
}
