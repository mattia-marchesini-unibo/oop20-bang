package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.effects.*;

import static java.util.Map.entry;

public class Card {

	//da aggiungere volcanic prigione riparo
	//da modificare emporio,panico,schiavat
	private static HashMap cardMap = new HashMap<>(Map.ofEntries(
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

	private String localName;
	private String realName;
	private String cardId;
	private Color color;
	private List<Effects> effects;

	public Card(final String cardId, final Color color, final String localName, final String realName) {
		this.cardId = cardId;
		this.localName = localName;
		this.realName = realName;
		this.color = color;
		this.effects = effects;
	}

	public String getId() {
	    return this.cardId;
	}

	public List<Effects> getEffects() {
		return this.effects;
	}

	public Color getColor() {
		return this.color;
	}

	public String getRealName() {
	    return this.realName;
	}

	public String getLocalName() {
	    return this.localName;
	}
}
