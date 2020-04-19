package org.wikipedia.webpages;

public enum Sizes {
	SMALL("Small"),
	MEDIUM("Medium"),
	LARGE("Large"),
	XLARGE("X-Large"),
	XXLARGE("2X-Large");
	
	private String value;
	
	public String getValue() {
		return value;
	}

	private Sizes(String value) {
		this.value = value;
	}
}
