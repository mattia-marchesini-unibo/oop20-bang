package model.card;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;

import model.effects.*;

public class Card {

	//da aggiungere volcanic prigione riparo
	//da modificare emporio,panico,schiavat
    private static Map<String, Effect> cardEffectsMap = new HashMap<>(Map.ofEntries(
        entry("missed", new AddProtection()),
        entry("bang", new Bang()),
        entry("schofield", new Weapon(2)),
        entry("remington", new Weapon(3)),
        entry("rev Carabine", new Weapon(4)),
        entry("winchester", new Weapon(5)),
        entry("scope",new Scope()),
        entry("mustang", new ModifyRetreat(1)),
        entry("hideout", new ModifyRetreat(1)),
        entry("generalstore", new GeneralStore()),
        entry("panic", new Panic()),
        entry("beer", new ModifyLifePoints(1)),
        entry("indians", new Indians()),
        entry("duel", new Duel()),
        entry("dodge", new AddProtection()), //???
        entry("wells fargo", new DrawCardsFromDeck(3)),
        entry("stagecoach",new DrawCardsFromDeck(2)),
        entry("saloon", new Saloon(1)),
        entry("gatling", new Gatling()),
        entry("cat balou", new CatBalou()),
        entry("jail", new Jail()),
        entry("volcanic", new Weapon(1))
        ));

	private String localName;
	private String realName;
	private String cardId;
	private Color color;
	private Effect effect;

	public Card(final String cardId, final Color color, final String localName, final String realName) {
		this.cardId = cardId;
		this.localName = localName;
		this.realName = realName;
		this.color = color;
		this.effect = cardEffectsMap.get(realName);
	}

	public String getId() {
	    return this.cardId;
	}

	public Effect getEffect() {
		return this.effect;
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
