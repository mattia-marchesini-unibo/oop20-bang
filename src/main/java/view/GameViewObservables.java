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
    private ObservableElement<String> action;
    private IObservable turn;
	
    public GameViewObservables(ObservableElement<String> character, ObservableElement<String> role,
            ObservableElement<Integer> lifePoints, ObservableElement<List<String>> hand,
            ObservableElement<List<String>> blueCards, ObservableElement<List<String>> otherPlayers,
            ObservableElement<List<Integer>> otherLifePoints, ObservableElement<List<List<String>>> otherBlueCards,
            IObservable turn, ObservableElement<String> action) {
        this.character = character;
        this.role = role;
        this.lifePoints = lifePoints;
        this.hand = hand;
        this.blueCards = blueCards;
        this.otherPlayers = otherPlayers;
        this.otherLifePoints = otherLifePoints;
        this.otherBlueCards = otherBlueCards;
        this.turn = turn;
        this.action = action;
    }

    public ObservableElement<String> getCharacter() {
        return this.character;
    }
    
    public void setCharacter(final ObservableElement<String> character) {
        this.character = character;
    }
    
    public ObservableElement<String> getRole() {
        return this.role;
    }
    
    public void setRole(final ObservableElement<String> role) {
        this.role = role;
    }
    
    public ObservableElement<Integer> getLifePoints() {
        return this.lifePoints;
    }
    
    public void setLifePoints(final ObservableElement<Integer> lifePoints) {
        this.lifePoints = lifePoints;
    }
    
    public ObservableElement<List<String>> getHand() {
        return this.hand;
    }
    
    public void setHand(final ObservableElement<List<String>> hand) {
        this.hand = hand;
    }
    
    public ObservableElement<List<String>> getBlueCards() {
        return this.blueCards;
    }
    
    public void setBlueCards(final ObservableElement<List<String>> blueCards) {
        this.blueCards = blueCards;
    }
    
    public ObservableElement<List<String>> getOtherPlayers() {
        return this.otherPlayers;
    }
    
    public void setOtherPlayer(final ObservableElement<List<String>> otherPlayers) {
        this.otherPlayers = otherPlayers;
    }
    
    public ObservableElement<List<Integer>> getOtherLifePoints() {
        return this.otherLifePoints;
    }
    
    public void setOtherLifePoints(final ObservableElement<List<Integer>> otherLifePoints) {
        this.otherLifePoints = otherLifePoints;
    }
    
    public ObservableElement<List<List<String>>> getOtherBlueCards() {
        return this.otherBlueCards;
    }
    
    public void setOtherBlueCards(final ObservableElement<List<List<String>>> otherBlueCards) {
        this.otherBlueCards = otherBlueCards;
    }
	
    public ObservableElement<String> getAction(){
        return this.action;
    }
    
    public void setAction(final ObservableElement<String> action) {
        this.action = action;
    }
    public IObservable getTurn() {
        return this.turn;
    }
    
    public void setTurn(final IObservable turn) {
        this.turn = turn;
    }
}
