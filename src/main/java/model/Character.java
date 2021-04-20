package model;
import model.card.*;
import java.util.List;

public class Character {
    private String name;
    private List <CharacterSkill> skill;
	private int LifePoints ;
    private List <Card> Card;
    
    public Character (final String name, final List <CharacterSkill> skill, final int LifePoints ,final List <Card> Card) {
    	this.name= name;
    	this.skill = skill;
    	this.LifePoints = LifePoints;
    	this.Card = Card;	
    }
      
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<CharacterSkill> getSkill() {
	return skill;
}

public void setSkill(List<CharacterSkill> skill) {
	this.skill = skill;
}

public int getLifePoints() {
	return LifePoints;
}

public void setLifePoints(int lifePoints) {
	LifePoints = lifePoints;
}

public List<Card> getCard() {
	return Card;
}

public void setCard(List<Card> card) {
	Card = card;
}
}
