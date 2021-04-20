package view;

import java.util.List;

import libs.observe.*;

public class GameViewObservables {

    private ObservableElement<String> character;
    private ObservableElement<String> role;
    private ObservableElement<Integer> lifePoints;
    private ObservableElement<List<String>> hand;
    private ObservableElement<List<String>> blueCards;
    private ObservableElement<List<String>> otherPlayers;
    private ObservableElement<List<Integer>> otherLifePoints;
    private ObservableElement<List<List<String>>> otherBlueCards;
    private ObservableElement<Integer> turn;
    private ObservableElement<String> action;
	
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
    
    public ObservableElement<List<String>> getHand() {
        return hand;
    }
    
    public void setHand(final ObservableElement<List<String>> hand) {
        this.hand = hand;
    }
    
    public ObservableElement<List<String>> getBlueCards() {
        return blueCards;
    }
    
    public void setBlueCards(final ObservableElement<List<String>> blueCards) {
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
    
    public ObservableElement<List<List<String>>> getOtherBlueCards() {
        return otherBlueCards;
    }
    
    public void setOtherBlueCards(final ObservableElement<List<List<String>>> otherBlueCards) {
        this.otherBlueCards = otherBlueCards;
    }
	
    public ObservableElement<Integer> getTurn() {
        return this.turn;
    }
    
    public void setTurn(final ObservableElement<Integer> turn) {
        this.turn = turn;
    }
    
    public ObservableElement<String> getAction(){
        return this.action;
    }
    
    public void setAction(final ObservableElement<String> action) {
        this.action = action;
    }
		
}
