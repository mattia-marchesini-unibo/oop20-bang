package model;

import java.util.Set;
import model.deck.IDeck;
import libs.CircularList;

public class SimpleTable implements Table{
    
    private IDeck deck;
    private CircularList<Player> players;
    private Player currentPlayer;
    private boolean sheriffIsDead = false;
    private int countOutlaws;
    
    public SimpleTable(final IDeck deck, final CircularList<Player> players, final Player currentPlayer, final int countOutlaws) {
        this.deck = deck;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.countOutlaws = countOutlaws;
    }

    @Override
    public IDeck getDeck() {
        return this.deck;
    }

    @Override
    public CircularList<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    @Override
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    @Override
    public void drawCards(int nCards) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void action(Action action, Set<Player> targets) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Player getNextPlayer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isOver() {
        return this.sheriffIsDead || this.countOutlaws == 0;
    }

    @Override
    public Player getCurrentPlayer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Player getNextPlayer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Player getCurrentPlayer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Player getNextPlayer() {
        // TODO Auto-generated method stub
        return null;
    }

}