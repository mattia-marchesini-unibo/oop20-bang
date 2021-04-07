package model;

import java.util.Set;
import model.deck.IDeck;
import libs.CircularList;

public class SimpleTable implements Table{
    
    private IDeck deck;
    private CircularList<Player> players;
    private Player currentPlayer;
    private boolean sheriffIsDead = false;
    private int countOutlaws = 0;
    
    public SimpleTable(final IDeck deck, final CircularList<Player> players) {
        this.deck = deck;
        this.players = players;
        this.currentPlayer = players.getCurrentElement();
        this.players.forEach(p -> {
            if(p.getRole.equals(Role.OUTLAW) || p.getRole.equals(Role.RENEGADE)) {
                this.countOutlaws++;
            }
        });
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
    public void action(Effects effects, Set<Player> targets) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Player getNextPlayer() {
        return players.getNext();
    }

    @Override
    public boolean isOver() {
        return this.sheriffIsDead || this.countOutlaws == 0;
    }

}
