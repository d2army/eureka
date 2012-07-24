package analyzer.group;

import analyzer.single.PositionAnalyzer;

import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Positions;

public class PositionsAnalyzer extends CategoryAnalyzer {
	private Positions positions_;
	
	public PositionsAnalyzer(Positions positions, String keyword){
		this.positions_ = positions;
		this.categoryName_ = "Positions";
		this.keyword_ = keyword;
	}
	
	public void process(){
		if (this.positions_ != null){
	          for(Position position : this.positions_.getPositionList()){
	        	  PositionAnalyzer pa = new PositionAnalyzer(position,this.keyword_);
	        	  pa.process();
	          }
		}
	}
}

