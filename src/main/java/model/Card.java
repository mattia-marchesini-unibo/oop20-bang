package model;

import java.util.List;

public class Card {
	
	private String name;
	private int cardId;
	private Color color;
	private List<Effects> effects;
	
	public Card(final int cardId, final Color color, final String name, List<Effects> effects ) {
		this.cardId = cardId;
		this.name = name;
		this.color = color;
		this.effects = effects;
	}
	
	public List<Effects> getEffects() {
		return this.effects;
	}

	
	public Color getColor() {
		return this.color;
	}
}
