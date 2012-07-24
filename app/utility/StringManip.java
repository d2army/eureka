package utility;

public class StringManip {
	public static String trimLeft(String s) {
	    return s.replaceAll("^\\s+", "");
	}
	 
	public static String trimRight(String s) {
	    return s.replaceAll("\\s+$", "");
	}
	
	public static String trim(String s){
		return trimLeft(trimRight(s));
	}
}
