package scorelogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.StringManip;

public class ScoreLogic implements ScoreLogicInterface {

	private Weight weightValue_;
	
	ScoreLogic() {
		this.weightValue_ = new Weight();
	}
	
	private int countKeywordAppearance(String haystack, String keyword){
		int count = 0;
		
		if ((keyword != null) && (keyword != "")) {
			
			//make sure this keyword is trimmed of spaces in the beginning
			//and end
			keyword = StringManip.trim(keyword);
			
			// now do a pattern match within the haystack
			String regExpPattern = "(?<![a-zA-Z])"
					+ keyword.toLowerCase() + "(?![^a-zA-Z])";

			Pattern p = Pattern.compile(regExpPattern);
			Matcher m = p.matcher(keyword);

			//count the number of matches
			while(m.find()) {
				count++;
			}
		}
		
		return count;
	}
	
	public Weight calculateScore() {
		
		return this.weightValue_;
	}
	
	public void acceptContent(String s){
		
	}
}
