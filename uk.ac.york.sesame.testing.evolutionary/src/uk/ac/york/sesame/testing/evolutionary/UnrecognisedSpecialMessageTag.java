package uk.ac.york.sesame.testing.evolutionary;

public class UnrecognisedSpecialMessageTag extends Exception {
	private String tag;
	private static final long serialVersionUID = 1L;

	public UnrecognisedSpecialMessageTag(String tag) {
		this.tag = tag;
	}
}
