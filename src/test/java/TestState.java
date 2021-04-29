import org.junit.Test;

import libs.CircularList;
import model.GameStateMachine;
import model.Player;
import model.Role;
import model.SimplePlayer;
import model.SimpleTable;
import model.card.Card;
import model.card.Color;
import model.states.CheckDeadPlayersState;
import model.states.CheckGameOverState;
import model.states.ChooseActionState;
import model.states.ChoosePlayerCardState;
import model.states.EndGameState;
import model.states.EndTurnState;
import model.states.PlayCardState;
import model.states.StartTurnState;

import static org.junit.Assert.assertEquals;

import java.util.Map;

public class TestState {

	@Test
	public void testChooseActionState() {
		CircularList<Player> c = new CircularList<Player>();
		c.add(new SimplePlayer(Role.DEPUTY, "p1"));
		GameStateMachine g = new GameStateMachine(new SimpleTable(null,c));
		g.setCurrentState(new ChooseActionState());
		g.setMessage("PlayCard");
		g.go();
		assertEquals(g.getCurrentState().getClass(), new ChoosePlayerCardState().getClass());
		g.setCurrentState(new ChooseActionState());
		g.setMessage("EndTurn");
		g.go();
		assertEquals(g.getCurrentState().getClass(), new EndTurnState().getClass());
	}
	 
	@Test
	public void testCheckDeadPlayersState() {
		CircularList<Player> c = new CircularList<Player>();
		Player p1 = new SimplePlayer(Role.DEPUTY, "p1");
		c.add(p1);
		GameStateMachine g = new GameStateMachine(new SimpleTable(null,c));
		g.setCurrentState(new CheckDeadPlayersState());
		g.setMessage("");
		g.go();
		assertEquals(g.getCurrentState().getClass(), new ChooseActionState().getClass());
		p1.modifyLifePoints(-5);
		g.setCurrentState(new CheckDeadPlayersState());
		g.go();
		assertEquals(g.getCurrentState().getClass(), new CheckGameOverState().getClass());
	}
	
	@Test
	public void testCheckGameOverState() {
		CircularList<Player> c = new CircularList<Player>();
		Player p1 = new SimplePlayer(Role.SHERIFF, "p1");
		c.add(p1);
		Player p2 = new SimplePlayer(Role.OUTLAW, "p2");
		c.add(p2);
		GameStateMachine g = new GameStateMachine(new SimpleTable(null,c));
		g.setCurrentState(new CheckGameOverState());
		g.setMessage("");
		g.go();
		assertEquals(g.getCurrentState().getClass(), new ChooseActionState().getClass());
		c.remove(p1);
		g.setCurrentState(new CheckGameOverState());
		g.go();
		assertEquals(g.getCurrentState().getClass(), new EndGameState().getClass());
		c.add(p1);
		c.remove(p2);
		g.setCurrentState(new CheckGameOverState());
		g.go();
		assertEquals(g.getCurrentState().getClass(), new EndGameState().getClass());
	}
	@Test
	public void testEndTurnState() {
		CircularList<Player> c = new CircularList<Player>();
		Player p1 = new SimplePlayer(Role.SHERIFF, "p1");
		c.add(p1);
		Player p2 = new SimplePlayer(Role.OUTLAW, "p2");
		c.add(p2);
		GameStateMachine g = new GameStateMachine(new SimpleTable(null,c));
		g.setCurrentState(new EndTurnState());
		g.setMessage("");
		g.go();
		assertEquals(g.getCurrentState().getClass(), new StartTurnState().getClass());
		assertEquals(p2,g.getTable().getCurrentPlayer());
	}
	//serve mattia
	@Test
	public void testStartTurnState() {
		CircularList<Player> c = new CircularList<Player>();
		Player p1 = new SimplePlayer(Role.SHERIFF, "p1");
		c.add(p1);
		Player p2 = new SimplePlayer(Role.OUTLAW, "p2");
		c.add(p2);
		GameStateMachine g = new GameStateMachine(new SimpleTable(null,c));
		g.setCurrentState(new StartTurnState());
		g.setMessage("");
		g.go();
		assertEquals(g.getCurrentState().getClass(), new ChooseActionState().getClass());
	}
	
	@Test
	public void testChoosePlayerCardState() {
		CircularList<Player> c = new CircularList<Player>();
		Player p1 = new SimplePlayer(Role.SHERIFF, "p1");
		c.add(p1);
		Player p2 = new SimplePlayer(Role.OUTLAW, "p2");
		c.add(p2);
		GameStateMachine g = new GameStateMachine(new SimpleTable(null,c));
		g.setCurrentState(new ChoosePlayerCardState());
		g.setMessage("");
		var card = new Card("b1",Color.BROWN,"bang","bang");
		p1.addCard(card);
		p2.addCard(card);
		g.getTable().getChooseCardsObservable().set(Map.of(card,p1));
		g.go();
		assertEquals(g.getCurrentState().getClass(), new PlayCardState(card).getClass());
		
	}
	@Test
	public void testPlayCardState() {
		
	}
	
	@Test
	public void testEndGameState() {
		CircularList<Player> c = new CircularList<Player>();
		Player p1 = new SimplePlayer(Role.DEPUTY, "p1");
		c.add(p1);
		GameStateMachine g = new GameStateMachine(new SimpleTable(null,c));
		g.setCurrentState(new EndGameState());
		g.setMessage("");
		g.go();
		assertEquals(g.getMessageObservable().get(),"end");
	}
}
