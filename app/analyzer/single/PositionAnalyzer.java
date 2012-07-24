package analyzer.single;

import com.google.code.linkedinapi.schema.Position;


public class PositionAnalyzer extends Analyzer {
	private Position position_;
	
	public PositionAnalyzer(Position position,String keyword){
		this.position_ = position;
		this.keyword_ = keyword;
	}
	
	/**
	 * Do the counting of the frequency items 
	 */
	public void process(){
		//how many times does the word actually show up in this position
		
		//look at the titkle
		//this.position_.getTitle();
	}
}
