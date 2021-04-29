package view;

import java.util.List;

import libs.observe.*;

public class GameViewObservables {

    private ObservableElement<String> currentPlayer = new ObservableElement<>();
    private ObservableElement<String> role = new ObservableElement<>();
    private ObservableElement<Integer> lifePoints = new ObservableElement<>();
    private ObservableElement<List<String>> hand = new ObservableElement<>();
    private ObservableElement<List<String>> blueCards = new ObservableElement<>();
    private ObservableElement<List<String>> otherPlayers = new ObservableElement<>();
    private ObservableElement<List<Integer>> otherLifePoints = new ObservableElement<>();
    private ObservableElement<List<List<String>>> otherBlueCards = new ObservableElement<>();
    private ObservableElement<String> action = new ObservableElement<>();
    private ObservableElement<List<String>> targets = new ObservableElement<>();
    private String chosenCard = "";
    private String chosenPlayer = "";
    
    public ObservableElement<String> getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    public void setCurrentPlayer(final ObservableElement<String> currentPlayer) {
        this.currentPlayer = currentPlayer;
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
    
    public ObservableElement<List<String>> getTargets() {
        return this.targets;
    }
    
    public void setTargets(final ObservableElement<List<String>> targets) {
        this.targets = targets;
    }
    
    public String getChoosenCard() {
        return this.chosenCard;
    }
    
    public void setChoosenCard(String choosenCard) {
        this.chosenCard = choosenCard;
    }
    
    public String getChoosenPlayer() {
        return this.chosenPlayer;
    }
    
    public void setChoosenPlayer(String choosenPlayer) {
        this.chosenPlayer = choosenPlayer;
    }
}