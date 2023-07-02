package uk.ac.york.sesame.testing.evolutionary.grammar;

public class TreeGenerationFailed extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reason;
	
	public TreeGenerationFailed(String reason) {
		this.reason = reason;
	}

}
