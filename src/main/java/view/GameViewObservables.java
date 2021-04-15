package view;

import java.util.List;

import libs.observe.*;

public class GameViewObservables {

    private ObservableElement<String> character;
    private ObservableElement<String> role;
    private ObservableElement<Integer> lifePoints;
    private ObservableElement<List<Integer>> hand;
    private ObservableElement<List<Integer>> blueCards;
    private ObservableElement<List<String>> otherPlayers;
    private ObservableElement<List<Integer>> otherLifePoints;
    private ObservableElement<List<List<Integer>>> otherBlueCards;
	
    public ObservableElement<String> getCharacter() {
        return character;
    }
    
    public void setCharacter(final ObservableElement<String> character) {
        this.character = character;
    }
    
    public ObservableElement<String> getRole() {
        return role;
    }
    
    public void setRole(final ObservableElement<String> role) {
        this.role = role;
    }
    
    public ObservableElement<Integer> getLifePoints() {
        return lifePoints;
    }
    
    public void setLifePoints(final ObservableElement<Integer> lifePoints) {
        this.lifePoints = lifePoints;
    }
    
    public ObservableElement<List<Integer>> getHand() {
        return hand;
    }
    
    public void setHand(final ObservableElement<List<Integer>> hand) {
        this.hand = hand;
    }
    
    public ObservableElement<List<Integer>> getBlueCards() {
        return blueCards;
    }
    
    public void setBlueCards(final ObservableElement<List<Integer>> blueCards) {
        this.blueCards = blueCards;
    }
    
    public ObservableElement<List<String>> getOtherPlayers() {
        return otherPlayers;
    }
    
    public void setOtherPlayer(final ObservableElement<List<String>> otherPlayers) {
        this.otherPlayers = otherPlayers;
    }
    
    public ObservableElement<List<Integer>> getOtherLifePoints() {
        return otherLifePoints;
    }
    
    public void setOtherLifePoints(final ObservableElement<List<Integer>> otherLifePoints) {
        this.otherLifePoints = otherLifePoints;
    }
    
    public ObservableElement<List<List<Integer>>> getOtherBlueCards() {
        return otherBlueCards;
    }
    
    public void setOtherBlueCards(final ObservableElement<List<List<Integer>>> otherBlueCards) {
        this.otherBlueCards = otherBlueCards;
    }
	
		
}
