package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

public class Card {
	 
	//da aggiungere volcanic prigione riparo
	//da modificare emporio,panico,schiavat
	private HashMap cardMap = new HashMap<>(Map.ofEntries(
			entry("mancato",new Protection()),
			entry("bang",new Strike()),
			entry("schofield",new Sight(2)),
			entry("remington", new Sight(3)),
			entry("rev Carabine", new Sight(4)),
			entry("winchester",new Sight(5)),
			entry("mirino",new Sight(1)),
			entry("mustang", new Retreat(1)),
			entry("emporio", new DrawCard(0)),
			entry("panico", new DrawCard(0)),
			entry("birra",new Protection()),
			entry("indiani", new Strike()),
			entry("duello", new Strike()),
			entry("schivata", new Protection()),
			entry("wells fargo", new DrawCard(3)),
			entry("diligenza",new DrawCard(2)),
			entry("saloon", new Protection()),
			entry("gatling",new Strike())
			)); 
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
