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
    private int lifePoints;
    private int protections = 0;

    public SimplePlayer(Role role, Character character) {
        this.character = character;
        this.role = role;
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
        this.hand.forEach(i -> {
            if (i.equals(card)) {
                this.hand.remove(i);
            }
        });
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
        int newLifePoints = this.lifePoints + points;

        if (newLifePoints >= this.character.getLifePoints()) {
            this.lifePoints = this.character.getLifePoints();
        }
        else if(newLifePoints < 0) {
            this.lifePoints = 0;
        }
        else {
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
