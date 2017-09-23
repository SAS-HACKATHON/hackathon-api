package com.sofrecom.hackathon.enumeration;

public enum ArticleType {

	Actu("ACTU"), ACTUTECHNO("ACTUTECHNO"), EVENT("EVENT");

	private String text;

	ArticleType(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static ArticleType fromString(String text) {
		for (ArticleType b : ArticleType.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}
