package analyzer.group;

import analyzer.single.Analyzer;

import com.google.code.linkedinapi.schema.RecommendationsReceived;


public class RecommendationsReceivedAnalyzer extends CategoryAnalyzer {
	
	public RecommendationsReceivedAnalyzer(RecommendationsReceived rr){
		this.categoryName_ = "RecommendationsReceived";
	}
	
	public void process(){
		
	}
}
