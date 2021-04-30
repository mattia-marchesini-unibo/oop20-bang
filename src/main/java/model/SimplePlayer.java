package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.card.Card;
import model.card.Color;

public class SimplePlayer implements Player {

    private static final int BASIC_SIGHT = 1;
    private static final int MAX_LIFE_POINTS = 4;
    private int sight = BASIC_SIGHT;
    private String name;
    private int retreat = 0;
    private Role role;
    private List<Card> hand = new ArrayList<>();
    private List<Card> activeCards = new ArrayList<>();
    private int maxLifePoints;
    private int lifePoints;
    private int protections = 0;
    private boolean usedBang = false;

    public SimplePlayer(Role role, String name) {
        this.name = name;
        this.role = role;
        if (this.role.equals(Role.SHERIFF)) {
            this.maxLifePoints = MAX_LIFE_POINTS + 1;
        } else {
            this.maxLifePoints = MAX_LIFE_POINTS;
        }
        this.lifePoints = this.maxLifePoints;
    }
    
    @Override
    public boolean getUsedBang() {
        return this.usedBang;
    }

    @Override
    public void setUsedBang(boolean b) {
        this.usedBang = b;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setRange(int sight) {
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
    public List<Card> getCardsByName(String name) {
        return this.hand.stream().filter(c -> c.getRealName().equals(name)).collect(Collectors.toList());
    }
    
    @Override
    public List<Card> getActiveCardsByName(String name) {
        return this.activeCards.stream().filter(c -> c.getRealName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public void addCard(Card card) {
        this.hand.add(card);
    }

    @Override
    public void playCard(String name, Table table) {
        Card card = this.getCardsByName(name).get(0);

        if (card.getColor() == Color.BROWN) {
            this.removeCard(card);
        }

        card.getEffect().useEffect(table);
    }

    @Override
    public void removeCard(Card card) {
        this.hand.remove(card);
    }

    @Override
    public List<Card> getActiveCards() {
        return this.activeCards;
    }

    @Override
    public void addActiveCard(final Card card) {
        if (!this.activeCards.contains(card)) {
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
    public void modifyLifePoints(int points) {
        int newLifePoints;
        newLifePoints = this.lifePoints + points;
        if (newLifePoints >= this.maxLifePoints) {
            this.lifePoints = this.maxLifePoints;
        } else if (newLifePoints < 0) {
            this.lifePoints = 0;
        } else {
            this.lifePoints = newLifePoints;
        }
    }

    @Override
    public void modifySight(int sight) {
        this.sight += sight;

        if (this.sight < 0) {
            this.sight = 0;
        }
    }

    @Override
    public void modifyRetreat(int retreat) {
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
