package model.card;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;

import model.effects.AddProtection;
import model.effects.Bang;
import model.effects.CatBalou;
import model.effects.DrawCardsFromDeck;
import model.effects.Duel;
import model.effects.Effect;
import model.effects.Gatling;
import model.effects.GeneralStore;
import model.effects.Indians;
import model.effects.ModifyLifePoints;
import model.effects.ModifyRetreat;
import model.effects.ModifySight;
import model.effects.Panic;
import model.effects.Saloon;

public class Card {

	//da aggiungere volcanic prigione riparo
	//da modificare emporio,panico,schiavat
    private static Map<String, Effect> cardEffectsMap = new HashMap<>(Map.ofEntries(
        entry("mancato", new AddProtection()),
        entry("bang", new Bang()),
        entry("schofield", new ModifySight(2)),
        entry("remington", new ModifySight(3)),
        entry("rev Carabine", new ModifySight(4)),
        entry("winchester", new ModifySight(5)),
        entry("mirino",new ModifySight(1)),
        entry("mustang", new ModifyRetreat(1)),
        entry("emporio", new GeneralStore()),
        entry("panico", new Panic()),
        entry("birra", new ModifyLifePoints(1)),
        entry("indians", new Indians()),
        entry("duello", new Duel()),
        entry("schivata", new AddProtection()), //???
        entry("wells fargo", new DrawCardsFromDeck(3)),
        entry("diligenza",new DrawCardsFromDeck(2)),
        entry("saloon", new Saloon(1)),
        entry("gatling", new Gatling()),
        entry("cat balou", new CatBalou())
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
