package analyzer.single;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.StringManip;

abstract public class Analyzer {
	protected static String finalResults_ = "";
	
	
	
	//keyword to search for
	protected String keyword_ = "";
	abstract public void process();
	
	public String getFinalResults(){
		return Analyzer.finalResults_;
	}
	
	protected static void addData(String value){
		Analyzer.finalResults_ = Analyzer.finalResults_.concat(value);
	}
	

	
}
