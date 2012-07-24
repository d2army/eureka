package scorelogic;

public interface ScoreLogicInterface {

	/**
	 * Based on the current content stored,
	 * do the necessary processing to come up with a score
	 * 
	 */
	public Weight calculateScore();
	
	/**
	 * Content accepted for processing
	 */
	public void acceptContent(String s);
}
