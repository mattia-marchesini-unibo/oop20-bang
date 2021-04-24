package model;

import java.util.List;
import java.util.stream.Collectors;

import model.card.Card;
import model.card.Color;

public class SimplePlayer implements Player {

    private static final int BASIC_SIGHT = 1;
    private int sight = BASIC_SIGHT;
    private int retreat = 0;
    private Character character;
    private Role role;
    private List<Card> hand;
    private List<Card> activeCards;
    private int lifePoints;
    private int protections = 0;

    public SimplePlayer(final Role role, final Character character) {
        this.character = character;
        this.role = role;
    }

    @Override
    public void setRange(final int sight) {
        this.sight = sight;
    }

    @Override
    public int getSight() {
        return this.sight;
    }

    @Override
    public int getRetreat() {
        return this.retreat;
    }

    @Override
    public List<Card> getCards() {
        return this.hand;
    }

    @Override
    public List<Card> getCardsByName(final String name) {
        return this.hand.stream().filter(c -> c.getRealName().equals(name)).collect(Collectors.toList());
    }
    
    @Override
    public List<Card> getActiveCardsByName(final String name){
        return this.activeCards.stream().filter(c -> c.getRealName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public void addCard(final Card card) {
        this.hand.add(card);
    }

    @Override
    public void playCard(final String name, final Table table) {
        Card card = this.getCardsByName(name).get(0);

        if (card.getColor() == Color.BLUE) {
            this.addActiveCard(card);
        }

        card.getEffect().useEffect(table);
        this.removeCard(card);
    }

    @Override
    public void removeCard(final Card card) {
        this.hand.remove(card);
    }

    @Override
    public List<Card> getActiveCards(){
        return this.activeCards;
    }
    
    @Override
    public void addActiveCard(final Card card) {
        if(!this.activeCards.contains(card)) {
            this.activeCards.add(card);
        }
    }
    
    @Override
    public void removeActiveCard(final Card card) {
        this.activeCards.remove(card);
    }
    
    @Override
    public Role getRole() {
        return this.role;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public void modifyLifePoints(final int points) {
        int newLifePoints;
        newLifePoints = this.lifePoints + points;
        if (newLifePoints >= this.character.getLifePoints()) {
            this.lifePoints = this.character.getLifePoints();
        } else {
            this.lifePoints = newLifePoints;
        }
    }

    @Override
    public void modifySight(final int sight) {
        this.sight += sight;

        if (this.sight < 0) {
            this.sight = 0;
        }
    }

    @Override
    public void modifyRetreat(final int retreat) {
        this.retreat = retreat;
    }

    @Override
    public void addProtection() {
        this.protections++;
    }

    @Override
    public void removeProtection() {
        this.protections--;

        if (this.protections < 0) {
            this.protections = 0;
        }
    }

    @Override
    public boolean hasProtection() {
        return this.protections > 0;
    }
}
