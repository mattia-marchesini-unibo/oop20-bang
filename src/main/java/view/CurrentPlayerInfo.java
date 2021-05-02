package view;

import java.util.List;

import libs.observe.ObservableElement;

public class CurrentPlayerInfo extends PlayerInfo {
    
    private ObservableElement<List<String>> hand = new ObservableElement<>();
    private ObservableElement<List<String>> activeCards = new ObservableElement<>();
    
    public CurrentPlayerInfo(final String name, final int lifePoints, final String role, final List<String> blueCards) {
        super(name, lifePoints, role, blueCards);
    }
    
    public ObservableElement<List<String>> getHand(){
        return this.hand;
    }
    
    public ObservableElement<List<String>> getActiveCards(){
        return this.activeCards;
    }
}
