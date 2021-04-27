package model;

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
    private List<Card> hand;
    private int maxLifePoints;
    private int lifePoints;
    private int protections = 0;
    private boolean useBang = false;

    public SimplePlayer(Role role, String name) {
        this.name = name;
        this.role = role;
        if(this.role.equals(Role.SHERIFF)) {
            this.maxLifePoints = MAX_LIFE_POINTS + 1;
        } else {
            this.maxLifePoints = MAX_LIFE_POINTS;
        }
        this.lifePoints = this.maxLifePoints;
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
<<<<<<< HEAD
        int newLifePoints = this.lifePoints + points;

        if (newLifePoints >= this.character.getLifePoints()) {
            this.lifePoints = this.character.getLifePoints();
        }
        else if(newLifePoints < 0) {
            this.lifePoints = 0;
        }
        else {
            this.lifePoints = newLifePoints;
=======
        int newLifePoints;
        newLifePoints = this.lifePoints + points;
        if (newLifePoints >= this.maxLifePoints) {
            this.lifePoints = this.maxLifePoints;
        } else if(newLifePoints < 0 ){
            this.lifePoints = 0;
        } else {
        	this.lifePoints = newLifePoints;
>>>>>>> origin/feature/logics
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

	@Override
	public boolean getUSeBang() {
		return this.useBang;
	}

	@Override
	public void setUseBang(boolean b) {
		this.useBang = b;
	}
}
